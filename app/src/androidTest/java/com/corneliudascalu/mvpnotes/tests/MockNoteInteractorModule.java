package com.corneliudascalu.mvpnotes.tests;

import com.corneliudascalu.mvpnotes.data.interactor.NoteInteractor;
import dagger.Module;
import dagger.Provides;

/**
 * @author Corneliu Dascalu <corneliu.dascalu@osf-global.com>
 */
@Module(overrides = true, library = true)
public class MockNoteInteractorModule {

    @Provides
    NoteInteractor provideNoteInteractor() {
        return new MockNoteInteractor();
    }
}
