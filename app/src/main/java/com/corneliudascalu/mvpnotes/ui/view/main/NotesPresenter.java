package com.corneliudascalu.mvpnotes.ui.view.main;

import com.corneliudascalu.mvpnotes.data.model.Note;

/**
 * Defines the methods of a NotesPresenter implementation
 *
 * @author Corneliu Dascalu <corneliu.dascalu@gmail.com>
 */
public interface NotesPresenter {

    /**
     * Request a list of notes from the presenter
     */
    void requestNotes();

    /**
     * Send a note to the presenter, to store it
     */
    void submitNewNote(String title, String text);

    /**
     * Request to the presenter to delete this note
     */
    void deleteNote(Note note);
}
