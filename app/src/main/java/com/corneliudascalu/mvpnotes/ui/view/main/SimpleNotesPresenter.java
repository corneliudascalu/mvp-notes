package com.corneliudascalu.mvpnotes.ui.view.main;

import com.corneliudascalu.mvpnotes.data.interactor.NoteInteractor;
import com.corneliudascalu.mvpnotes.data.model.Note;
import org.joda.time.DateTime;

/**
 * @author Corneliu Dascalu <corneliu.dascalu@osf-global.com>
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
