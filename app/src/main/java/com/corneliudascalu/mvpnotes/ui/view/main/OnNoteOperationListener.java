package com.corneliudascalu.mvpnotes.ui.view.main;

import com.corneliudascalu.mvpnotes.data.model.Note;

import java.util.List;

/**
 * @author Corneliu Dascalu <corneliu.dascalu@gmail.com>
 */
public interface OnNoteOperationListener {

    void onNoteAdded(Note note);

    void onNoteAddError(Note.Error error);

    void onNoteDeleted(Note note);

    void onNoteDeleteError(Note.Error error);

    void onNoteRetrieved(Note note);

    void onNoteListRetrieved(List<Note> notes);

    void onRetrieveError(Note.Error error);
}
