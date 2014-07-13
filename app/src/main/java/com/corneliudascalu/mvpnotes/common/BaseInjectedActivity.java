package com.corneliudascalu.mvpnotes.common;

import android.app.Activity;
import android.os.Bundle;
import dagger.ObjectGraph;

import java.util.List;

/**
 * @author Corneliu Dascalu <corneliu.dascalu@osf-global.com>
 */
public abstract class BaseInjectedActivity extends Activity {

    private ObjectGraph objectGraph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        objectGraph = ObjectGraphHolder.createScopedObjectGraph(getApplication(), getModules().toArray());
        objectGraph.inject(this);
    }

    protected abstract List<Object> getModules();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        objectGraph = null;
    }
}
