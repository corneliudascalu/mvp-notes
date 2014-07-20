package com.corneliudascalu.mvpnotes.ui.view.details.interfaces;

import com.corneliudascalu.mvpnotes.data.model.Note;

/**
 * @author Corneliu Dascalu <corneliu.dascalu@gmail.com>
 */
public interface NoteDetailsPresenter {

    void setData(Note note);

    void viewReady();

    void deleteNote();
}
