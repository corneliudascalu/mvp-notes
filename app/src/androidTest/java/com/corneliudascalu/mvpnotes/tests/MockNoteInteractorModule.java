package com.corneliudascalu.mvpnotes.tests;

import com.corneliudascalu.mvpnotes.data.interactor.NoteInteractor;
import dagger.Module;
import dagger.Provides;

/**
 * An interactor module that supplies a different {@link com.corneliudascalu.mvpnotes.data.interactor
 * .NoteInteractor}, by overriding the one from the {@link com.corneliudascalu.mvpnotes.data.interactor
 * .InteractorsModule}
 *
 * @author Corneliu Dascalu <corneliu.dascalu@gmail.com>
 */
@Module(overrides = true, library = true)
public class MockNoteInteractorModule {

    @Provides
    NoteInteractor provideNoteInteractor() {
        return new MockNoteInteractor();
    }
}
