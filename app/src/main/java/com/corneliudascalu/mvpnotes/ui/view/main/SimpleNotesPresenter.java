package com.corneliudascalu.mvpnotes.ui.view.main;

import com.corneliudascalu.mvpnotes.data.interactor.NoteInteractor;
import com.corneliudascalu.mvpnotes.data.model.Note;

import org.joda.time.DateTime;

import java.util.List;

/**
 * Implements a simple note presenter, that handles the data input from the {@link
 * com.corneliudascalu.mvpnotes.ui
 * .view.main.NotesView} and communicates with the {@link com.corneliudascalu.mvpnotes.data.interactor.NoteInteractor}
 *
 * @author Corneliu Dascalu <corneliu.dascalu@gmail.com>
 */
public class SimpleNotesPresenter implements NotesPresenter, OnNoteOperationListener {

    private NotesView notesView;

    private NoteInteractor noteInteractor;

    public SimpleNotesPresenter(NotesView notesView, NoteInteractor noteInteractor) {
        this.notesView = notesView;
        this.noteInteractor = noteInteractor;
    }

    @Override
    public void requestNotes() {
        noteInteractor.getAllNotes(this);
    }

    @Override
    public void submitNewNote(String title, String text) {
        Note note = new Note();
        note.createdDate = new DateTime();
        note.text = text;
        note.title = title;
        noteInteractor.storeNote(note, this);
    }

    @Override
    public void deleteNote(Note note) {
        noteInteractor.deleteNote(note, this);
    }

    @Override
    public void onNoteAdded(Note note) {
        notesView.addNotes(note);
    }

    @Override
    public void onNoteAddError(Note.Error error) {
        notesView.setNoteError(error.getMessage());
    }

    @Override
    public void onNoteDeleted(Note note) {notesView.removeNote(note);
    }

    @Override
    public void onNoteDeleteError(Note.Error error) {
        notesView.setNoteError(error.getMessage());
    }

    @Override
    public void onNoteRetrieved(Note note) {
        notesView.addNotes(note);
    }

    @Override
    public void onNoteListRetrieved(List<Note> notes) {
        notesView.addNotes(notes.toArray(new Note[notes.size()]));
    }

    @Override
    public void onRetrieveError(Note.Error error) {
        notesView.setNoteError(error.getMessage());
    }
}
