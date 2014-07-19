package com.corneliudascalu.mvpnotes.ui.view.main;

/**
 * Defines the methods of a NotesPresenter implementation
 *
 * @author Corneliu Dascalu <corneliu.dascalu@gmail.com>
 */
public interface NotesPresenter {

    void requestNotes();

    void submitNewNote(String title, String text);
}
