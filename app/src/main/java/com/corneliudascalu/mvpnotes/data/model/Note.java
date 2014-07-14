package com.corneliudascalu.mvpnotes.data.model;

import org.joda.time.DateTime;

/**
 * Simple model of a note
 *
 * @author Corneliu Dascalu <corneliu.dascalu@gmail.com>
 */
public class Note {
    public int id;
    public String title;
    public String text;
    public DateTime createdDate;

    /**
     * A note-related error. I find it useful to define exceptions this way, to make it easy and clear when using an
     * event bus.
     */
    public static class Error extends Exception {

        public Note note;

        public Error(Note note, String s) {
            super(s);
            this.note = note;
        }
    }
}
