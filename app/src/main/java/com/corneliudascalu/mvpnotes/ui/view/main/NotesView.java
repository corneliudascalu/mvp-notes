package com.corneliudascalu.mvpnotes.ui.view.main;

import com.corneliudascalu.mvpnotes.data.model.Note;

/**
 * Defines the methods of a NotesView. In our case, the interface will be implemented by an activity,
 * but it could just as well be implemented by a fragment or a simple view.
 *
 * @author Corneliu Dascalu <corneliu.dascalu@gmail.com>
 */
public interface NotesView {
    void setNoteError(String error);

    void addNotes(Note... note);

    void removeNote(Note note);
}
