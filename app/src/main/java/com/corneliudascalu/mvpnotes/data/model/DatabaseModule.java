package com.corneliudascalu.mvpnotes.data.model;

import com.corneliudascalu.mvpnotes.AppModule;
import com.corneliudascalu.mvpnotes.MVPNotesApp;
import com.corneliudascalu.mvpnotes.data.interactor.impl.NoteInteractorImpl;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author Corneliu Dascalu <corneliu.dascalu@gmail.com>
 */
@Module(injects = NoteInteractorImpl.class, addsTo = AppModule.class)
public class DatabaseModule {

    @Provides
    @Singleton
    public SimpleDatabase provideSimpleDatabase(MVPNotesApp app) {
        SharedPreferences sharedPreferences = app
                .getSharedPreferences("notes_db", Context.MODE_PRIVATE);
        return new SimpleDatabase(sharedPreferences);
    }
}
