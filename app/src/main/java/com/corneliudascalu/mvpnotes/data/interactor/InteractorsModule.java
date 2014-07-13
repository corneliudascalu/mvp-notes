package com.corneliudascalu.mvpnotes.data.interactor;

import com.corneliudascalu.mvpnotes.data.interactor.impl.NoteInteractorImpl;
import dagger.Module;
import dagger.Provides;

/**
 * @author Corneliu Dascalu <corneliu.dascalu@osf-global.com>
 */
@Module(library = true)
public class InteractorsModule {
    @Provides
    public NoteInteractor provideNotesInteractor() {
        return new NoteInteractorImpl();
    }
}
