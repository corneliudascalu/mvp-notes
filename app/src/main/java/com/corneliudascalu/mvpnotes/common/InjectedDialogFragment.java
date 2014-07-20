package com.corneliudascalu.mvpnotes.common;

import android.app.DialogFragment;
import android.os.Bundle;

import java.util.List;

import dagger.ObjectGraph;

/**
 * @author Corneliu Dascalu <corneliu.dascalu@gmail.com>
 */
public abstract class InjectedDialogFragment extends DialogFragment {

    private ObjectGraph objectGraph;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        objectGraph = ObjectGraphHolder
                .createScopedObjectGraph(getActivity().getApplication(), getModules().toArray());
        objectGraph.inject(this);
    }

    protected abstract List<Object> getModules();

    @Override
    public void onDestroy() {
        super.onDestroy();
        objectGraph = null;
    }
}
