package com.corneliudascalu.mvpnotes.tests;

import com.corneliudascalu.mvpnotes.data.interactor.NoteInteractor;
import com.corneliudascalu.mvpnotes.data.model.Note;
import com.corneliudascalu.mvpnotes.ui.view.main.OnNoteAddedListener;
import timber.log.Timber;

import java.util.Random;

/**
 * A different implementation of a {@link com.corneliudascalu.mvpnotes.data.interactor.NoteInteractor}. There's not
 * much difference to {@link com.corneliudascalu.mvpnotes.data.interactor.impl.NoteInteractorImpl} used in the app,
 * but assume that the one from the app is doing real work
 *
 * @author Corneliu Dascalu <corneliu.dascalu@gmail.com>
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
