package com.corneliudascalu.mvpnotes.tests;

import com.corneliudascalu.mvpnotes.data.interactor.NoteInteractor;
import com.corneliudascalu.mvpnotes.data.model.Note;
import com.corneliudascalu.mvpnotes.ui.view.main.OnNoteAddedListener;
import timber.log.Timber;

import java.util.Random;

/**
 * @author Corneliu Dascalu <corneliu.dascalu@osf-global.com>
 */
public class MockNoteInteractor implements NoteInteractor {
    @Override
    public void addNote(Note note, OnNoteAddedListener listener) {
        if (new Random().nextInt(10) > 3) {
            Timber.d("MockNote", "Adding note");
            listener.onNoteAdded(note);
        } else {
            Timber.d("MockNote", "Generating note error");
            listener.onNoteAddError(new Note.Error(note, "Mock error"));
        }
    }

    @Override
    public void deleteNote(Note note) {

    }
}
