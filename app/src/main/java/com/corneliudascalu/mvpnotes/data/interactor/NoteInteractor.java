package com.corneliudascalu.mvpnotes.data.interactor;

import com.corneliudascalu.mvpnotes.data.model.Note;
import com.corneliudascalu.mvpnotes.ui.view.main.OnNoteAddedListener;

/**
 * Defines the notes interactor, which takes care of storing and deleting notes, either directly or by communicating
 * with another layer.
 *
 * @author Corneliu Dascalu <corneliu.dascalu@gmail.com>
 */
public interface NoteInteractor {
    void addNote(Note note, OnNoteAddedListener listener);

    void deleteNote(Note note);
}
