package com.corneliudascalu.mvpnotes;

import android.app.Application;
import com.corneliudascalu.mvpnotes.common.ObjectGraphCreator;
import com.corneliudascalu.mvpnotes.common.ObjectGraphHolder;
import dagger.ObjectGraph;

import java.util.Arrays;
import java.util.List;

/**
 * @author Corneliu Dascalu <corneliu.dascalu@osf-global.com>
 */
public class MVPNotesApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ObjectGraphHolder.setObjectGraphCreator(new ObjectGraphCreator() {
            @Override
            public ObjectGraph create(Application application) {
                return ObjectGraph.create(getModules().toArray());
            }
        });
    }

    private List<Object> getModules() {
        return Arrays.<Object>asList(new AppModule(this));
    }

    public ObjectGraph createScopedObjectGraph(Object... modules) {
        return ObjectGraphHolder.getObjectGraph(this).plus(modules);
    }

}
