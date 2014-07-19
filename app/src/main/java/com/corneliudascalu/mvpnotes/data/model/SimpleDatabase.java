package com.corneliudascalu.mvpnotes.data.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.corneliudascalu.mvpnotes.util.DateTimeDeserializer;
import com.corneliudascalu.mvpnotes.util.DateTimeSerializer;

import org.joda.time.DateTime;

import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author Corneliu Dascalu <corneliu.dascalu@gmail.com>
 */
public class SimpleDatabase {

    private final SharedPreferences mDatabase;


    public SimpleDatabase(SharedPreferences sharedPreferences) {
        mDatabase = sharedPreferences;
    }

    /**
     * Add/replace a note to the database, setting an id if it's zero.
     *
     * @return The id of the note
     */
    public long addOrReplace(Note note) {
        if (note.id == 0) {
            note.id = System.currentTimeMillis();
        }
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(DateTime.class, new DateTimeSerializer())
                .registerTypeAdapter(DateTime.class, new DateTimeDeserializer())
                .create();
        String json = gson.toJson(note);
        mDatabase.edit().putString(String.valueOf(note.id), json).apply();
        return note.id;
    }

    /**
     * Retrieve a note from the database
     *
     * @param id The id of the wanted note
     * @return The note, if found, or null otherwise
     */
    public Note get(long id) {
        String json = mDatabase.getString(String.valueOf(id), null);
        if (json != null) {
            return new GsonBuilder()
                    .registerTypeAdapter(DateTime.class, new DateTimeSerializer())
                    .registerTypeAdapter(DateTime.class, new DateTimeDeserializer())
                    .create().fromJson(json, Note.class);
        }
        return null;
    }

    /**
     * Return all the notes in the database
     */
    public List<Note> getAll() {
        Map<String, String> all = (Map<String, String>) mDatabase.getAll();
        Collection<String> values = all.values();
        if (values.size() == 0) {
            return new ArrayList<Note>();
        }

        ArrayList<Note> notes = new ArrayList<Note>(values.size());
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(DateTime.class, new DateTimeSerializer())
                .registerTypeAdapter(DateTime.class, new DateTimeDeserializer())
                .create();

        for (String value : values) {
            notes.add(gson.fromJson(value, Note.class));
        }
        return notes;
    }

    /**
     * Delete the note with the supplied id from the database
     *
     * @return The number of deleted notes
     */
    public int delete(long id) {
        if (mDatabase.contains(String.valueOf(id))) {
            mDatabase.edit().remove(String.valueOf(id)).apply();
            return 1;
        }
        return 0;
    }

}
