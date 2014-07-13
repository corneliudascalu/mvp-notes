package com.corneliudascalu.mvpnotes.data.interactor.impl;

import android.os.Handler;
import com.corneliudascalu.mvpnotes.data.interactor.NoteInteractor;
import com.corneliudascalu.mvpnotes.data.model.Note;
import com.corneliudascalu.mvpnotes.ui.view.main.OnNoteAddedListener;

import java.util.Random;

/**
 * @author Corneliu Dascalu <corneliu.dascalu@osf-global.com>
 */
public class NoteInteractorImpl implements NoteInteractor {
    @Override
    public void addNote(final Note note, final OnNoteAddedListener listener) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (new Random().nextInt(5) > 0) {
                    listener.onNoteAdded(note);
                } else {
                    listener.onNoteAddError(new Note.Error(note, "Generic error"));
                }
            }
        }, 2000);
    }

    @Override
    public void deleteNote(Note note) {

    }
}