package com.corneliudascalu.mvpnotes.ui.view.details.interfaces;

import com.corneliudascalu.mvpnotes.data.model.Note;

/**
 * @author Corneliu Dascalu <corneliu.dascalu@gmail.com>
 */
public interface NoteDetailsView {

    void setNote(Note note);

    void close();
}
