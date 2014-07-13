package com.corneliudascalu.mvpnotes.data.model;

import org.joda.time.DateTime;

/**
 * @author Corneliu Dascalu <corneliu.dascalu@osf-global.com>
 */
public class Note {
    public int id;
    public String title;
    public String text;
    public DateTime createdDate;

    public static class Error extends Exception {

        public Note note;

        public Error(Note note, String s) {
            super(s);
            this.note = note;
        }
    }
}
