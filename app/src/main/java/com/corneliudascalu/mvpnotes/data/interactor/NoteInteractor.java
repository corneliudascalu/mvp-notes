package com.corneliudascalu.mvpnotes.data.interactor;

import com.corneliudascalu.mvpnotes.data.model.Note;
import com.corneliudascalu.mvpnotes.ui.view.main.OnNoteOperationListener;

/**
 * Defines the notes interactor, which takes care of storing and deleting notes, either directly or
 * by communicating
 * with another layer.
 *
 * @author Corneliu Dascalu <corneliu.dascalu@gmail.com>
 */
public interface NoteInteractor {

    void storeNote(Note note, OnNoteOperationListener listener);

    void deleteNote(Note note, OnNoteOperationListener listener);

    void getNote(long id, OnNoteOperationListener listener);

    void getAllNotes(OnNoteOperationListener listener);
}
