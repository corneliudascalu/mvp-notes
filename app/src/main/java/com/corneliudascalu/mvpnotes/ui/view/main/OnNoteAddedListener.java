package com.corneliudascalu.mvpnotes.ui.view.main;

import com.corneliudascalu.mvpnotes.data.model.Note;

/**
 * @author Corneliu Dascalu <corneliu.dascalu@osf-global.com>
 */
public interface OnNoteAddedListener {
    void onNoteAdded(Note note);

    void onNoteAddError(Note.Error error);
}
