package com.corneliudascalu.mvpnotes.data.interactor;

import com.corneliudascalu.mvpnotes.data.model.Note;
import com.corneliudascalu.mvpnotes.ui.view.main.OnNoteAddedListener;

/**
 * @author Corneliu Dascalu <corneliu.dascalu@osf-global.com>
 */
public interface NoteInteractor {
    void addNote(Note note, OnNoteAddedListener listener);

    void deleteNote(Note note);
}
