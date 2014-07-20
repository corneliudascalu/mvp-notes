package com.corneliudascalu.mvpnotes.data.model;

import org.joda.time.DateTime;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Simple model of a note
 *
 * @author Corneliu Dascalu <corneliu.dascalu@gmail.com>
 */
public class Note implements Parcelable {

    public long id;

    public String title;

    public String text;

    public DateTime createdDate;

    /**
     * A note-related error. I find it useful to define exceptions this way, to make it easy and
     * clear when using an
     * event bus.
     */
    public static class Error extends Exception {

        private long id;

        public Note note;

        public Error(Note note, String s) {
            super(s);
            this.note = note;
        }

        public Error(long id, String s) {
            super();
            this.id = id;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.id);
        dest.writeString(this.title);
        dest.writeString(this.text);
        dest.writeString(this.createdDate.toString());
    }

    public Note() {
    }

    private Note(Parcel in) {
        this.id = in.readLong();
        this.title = in.readString();
        this.text = in.readString();
        this.createdDate = new DateTime(in.readString());
    }

    public static final Parcelable.Creator<Note> CREATOR = new Parcelable.Creator<Note>() {
        public Note createFromParcel(Parcel source) {
            return new Note(source);
        }

        public Note[] newArray(int size) {
            return new Note[size];
        }
    };
}
