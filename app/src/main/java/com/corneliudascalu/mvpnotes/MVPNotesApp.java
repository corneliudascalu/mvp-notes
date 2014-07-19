package com.corneliudascalu.mvpnotes;

import com.corneliudascalu.mvpnotes.common.ObjectGraphCreator;
import com.corneliudascalu.mvpnotes.common.ObjectGraphHolder;

import android.app.Application;

import java.util.Arrays;
import java.util.List;

import dagger.ObjectGraph;

/**
 * @author Corneliu Dascalu <corneliu.dascalu@gmail.com>
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

    /**
     * The list of modules containing application-level stuff
     */
    private List<Object> getModules() {
        return Arrays.<Object>asList(new AppModule(this));
    }

    /**
     * Create a scoped object graph by adding some modules to the app modules
     */
    public ObjectGraph createScopedObjectGraph(Object... modules) {
        return ObjectGraphHolder.getObjectGraph(this).plus(modules);
    }

}
