package com.corneliudascalu.mvpnotes.ui.view.main;

import com.corneliudascalu.mvpnotes.AppModule;
import com.corneliudascalu.mvpnotes.data.interactor.NoteInteractor;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

/**
 * Provides the stuff needed by the activity. In this case, the {@link com.corneliudascalu.mvpnotes.ui.view.main
 * .NotesPresenter}. Interesting to note, the {@link com.corneliudascalu.mvpnotes.data.interactor.NoteInteractor}
 * from the {@link #provideNotesPresenter(NotesView, com.corneliudascalu.mvpnotes.data.interactor.NoteInteractor)}
 * method definition is provided by the {@link com.corneliudascalu.mvpnotes.AppModule},
 * through the {@link com.corneliudascalu.mvpnotes.data.interactor.InteractorsModule InteractorsModule}
 *
 * @author Corneliu Dascalu <corneliu.dascalu@gmail.com>
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

    @Provides
    @Singleton
    public NotesView provideNotesView() {
        return notesView;
    }

    @Provides
    @Singleton
    public NotesPresenter provideNotesPresenter(NotesView notesView, NoteInteractor noteInteractor) {
        return new SimpleNotesPresenter(notesView, noteInteractor);
    }
}
