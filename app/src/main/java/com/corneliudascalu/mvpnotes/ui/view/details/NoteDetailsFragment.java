package com.corneliudascalu.mvpnotes.ui.view.details;

import com.corneliudascalu.mvpnotes.R;
import com.corneliudascalu.mvpnotes.common.InjectedFragment;
import com.corneliudascalu.mvpnotes.data.model.Note;
import com.corneliudascalu.mvpnotes.ui.view.details.interfaces.NoteDetailsPresenter;
import com.corneliudascalu.mvpnotes.ui.view.details.interfaces.NoteDetailsView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * @author Corneliu Dascalu <corneliu.dascalu@gmail.com>
 */
public class NoteDetailsFragment extends InjectedFragment implements NoteDetailsView {

    @Inject
    NoteDetailsPresenter mNoteDetailsPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected List<Object> getModules() {
        return Arrays.<Object>asList(new NoteDetailsModule(this));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.note_details, container, false);
        ButterKnife.inject(this, view);

        return view;
    }

    @Override
    public void setNote(Note note) {

    }

    @Override
    public void close() {

    }
}
