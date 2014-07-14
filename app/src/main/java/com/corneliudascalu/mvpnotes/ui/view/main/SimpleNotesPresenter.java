package com.corneliudascalu.mvpnotes.ui.view.main;

import com.corneliudascalu.mvpnotes.data.interactor.NoteInteractor;
import com.corneliudascalu.mvpnotes.data.model.Note;
import org.joda.time.DateTime;

/**
 * Implements a simple note presenter, that handles the data input from the {@link com.corneliudascalu.mvpnotes.ui
 * .view.main.NotesView} and communicates with the {@link com.corneliudascalu.mvpnotes.data.interactor.NoteInteractor}
 *
 * @author Corneliu Dascalu <corneliu.dascalu@gmail.com>
 */
public class SimpleNotesPresenter implements NotesPresenter, OnNoteAddedListener {

    private NotesView notesView;
    private NoteInteractor noteInteractor;

    public SimpleNotesPresenter(NotesView notesView, NoteInteractor noteInteractor) {
        this.notesView = notesView;
        this.noteInteractor = noteInteractor;
    }

    @Override
    public void submitNewNote(String title, String text) {
        Note note = new Note();
        note.createdDate = new DateTime();
        note.text = text;
        note.title = title;
        noteInteractor.addNote(note, this);
    }

    @Override
    public void onNoteAdded(Note note) {
        notesView.addNote(note);
    }

    @Override
    public void onNoteAddError(Note.Error error) {
        notesView.setNoteError(error.getMessage());
    }
}
