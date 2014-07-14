package com.corneliudascalu.mvpnotes.data.interactor;

import com.corneliudascalu.mvpnotes.data.interactor.impl.NoteInteractorImpl;
import dagger.Module;
import dagger.Provides;

/**
 * Provides the list of interactors used throughout the app. Handy to have them all in the same file,
 * and the {@code library} annotation means that only needed interactors will be injected in the target object
 *
 * @author Corneliu Dascalu <corneliu.dascalu@gmail.com>
 */
@Module(library = true)
public class InteractorsModule {
    @Provides
    public NoteInteractor provideNotesInteractor() {
        return new NoteInteractorImpl();
    }
}
