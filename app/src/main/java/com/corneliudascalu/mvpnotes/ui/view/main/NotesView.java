package com.corneliudascalu.mvpnotes.ui.view.main;

import com.corneliudascalu.mvpnotes.data.model.Note;

/**
 * @author Corneliu Dascalu <corneliu.dascalu@osf-global.com>
 */
public interface NotesView {
    void setNoteError(String error);

    void addNote(Note note);
}
