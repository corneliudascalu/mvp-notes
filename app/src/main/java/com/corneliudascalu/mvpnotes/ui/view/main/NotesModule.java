package com.corneliudascalu.mvpnotes.ui.view.main;

import com.corneliudascalu.mvpnotes.AppModule;
import com.corneliudascalu.mvpnotes.data.interactor.NoteInteractor;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

/**
 * @author Corneliu Dascalu <corneliu.dascalu@osf-global.com>
 */
@Module(
        injects = {NotesActivity.class},
        addsTo = AppModule.class
)
public class NotesModule {
    private NotesView notesView;

    public NotesModule(NotesView notesView) {
        this.notesView = notesView;
    }

    @Provides @Singleton public NotesView provideNotesView() {
        return notesView;
    }

    @Provides @Singleton public NotesPresenter provideNotesPresenter(NotesView notesView, NoteInteractor noteInteractor) {
        return new SimpleNotesPresenter(notesView, noteInteractor);
    }
}
