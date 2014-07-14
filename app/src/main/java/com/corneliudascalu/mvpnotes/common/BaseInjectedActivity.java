package com.corneliudascalu.mvpnotes.common;

import android.app.Activity;
import android.os.Bundle;
import dagger.ObjectGraph;

import java.util.List;

/**
 * Base class for all activities, which creates a scoped object graph and injects is in the activity. Extended
 * classes will implement the {@link #getModules()} method to specify the needed modules
 *
 * @author Corneliu Dascalu <corneliu.dascalu@gmail.com>
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
