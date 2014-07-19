package com.corneliudascalu.mvpnotes.data.interactor.impl;

import com.corneliudascalu.mvpnotes.MVPNotesApp;
import com.corneliudascalu.mvpnotes.common.ObjectGraphHolder;
import com.corneliudascalu.mvpnotes.data.interactor.NoteInteractor;
import com.corneliudascalu.mvpnotes.data.model.DatabaseModule;
import com.corneliudascalu.mvpnotes.data.model.Note;
import com.corneliudascalu.mvpnotes.data.model.SimpleDatabase;
import com.corneliudascalu.mvpnotes.ui.view.main.OnNoteOperationListener;

import android.os.Handler;

import java.util.List;
import java.util.Random;

import javax.inject.Inject;

import dagger.ObjectGraph;

/**
 * A very simple implementation of a NoteInteractor, which simulates delayed operations.
 * Because this is just a sample, I'm using the SimpleDatabase class directly, not an interface.
 * Normally, there should be a ContentProvider there, or something similar.
 *
 * @author Corneliu Dascalu <corneliu.dascalu@gmail.com>
 */
public class NoteInteractorImpl implements NoteInteractor {

    private Handler mHandler;

    public NoteInteractorImpl(MVPNotesApp app) {
        mHandler = new Handler();
        ObjectGraph objectGraph = ObjectGraphHolder.createScopedObjectGraph(app)
                .plus(DatabaseModule.class);
        objectGraph.inject(this);
    }

    @Inject
    SimpleDatabase mSimpleDatabase;

    private void simulateExecuteInBackground(Runnable runnable) {
        mHandler.postDelayed(runnable, 1000);
    }

    @Override
    public void storeNote(final Note note, final OnNoteOperationListener listener) {
        simulateExecuteInBackground(new Runnable() {
            @Override
            public void run() {
                if (new Random().nextInt(5) > 0) {
                    long id = mSimpleDatabase.addOrReplace(note);
                    if (id > 0) {
                        note.id = id;
                        listener.onNoteAdded(note);
                    } else {
                        listener.onNoteAddError(new Note.Error(note, "Note not inserted in db"));
                    }
                } else {
                    listener.onNoteAddError(new Note.Error(note, "Generic error"));
                }
            }
        });
    }

    @Override
    public void deleteNote(final Note note, final OnNoteOperationListener listener) {
        simulateExecuteInBackground(new Runnable() {
            @Override
            public void run() {
                int deleted = mSimpleDatabase.delete(note.id);
                if (deleted > 0) {
                    listener.onNoteDeleted(note);
                } else {
                    listener.onNoteDeleteError(new Note.Error(note, "Note not deleted"));
                }
            }
        });

    }

    @Override
    public void getNote(final long id, final OnNoteOperationListener listener) {
        simulateExecuteInBackground(new Runnable() {
            @Override
            public void run() {
                Note note = mSimpleDatabase.get(id);
                if (note != null) {
                    listener.onNoteRetrieved(note);
                } else {
                    listener.onRetrieveError(new Note.Error(id, "Couldn't retrieve note"));
                }
            }
        });

    }

    @Override
    public void getAllNotes(final OnNoteOperationListener listener) {
        simulateExecuteInBackground(new Runnable() {
            @Override
            public void run() {
                List<Note> all = mSimpleDatabase.getAll();
                listener.onNoteListRetrieved(all);
            }
        });

    }

}
