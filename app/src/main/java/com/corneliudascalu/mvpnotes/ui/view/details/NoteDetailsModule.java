package com.corneliudascalu.mvpnotes.ui.view.details;

import com.corneliudascalu.mvpnotes.AppModule;
import com.corneliudascalu.mvpnotes.data.interactor.NoteInteractor;
import com.corneliudascalu.mvpnotes.ui.view.details.interfaces.NoteDetailsPresenter;
import com.corneliudascalu.mvpnotes.ui.view.details.interfaces.NoteDetailsView;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author Corneliu Dascalu <corneliu.dascalu@gmail.com>
 */
@Module
        (injects = NoteDetailsDialogFragment.class,
                addsTo = AppModule.class)
public class NoteDetailsModule {

    private final NoteDetailsView view;

    public NoteDetailsModule(NoteDetailsView view) {
        this.view = view;
    }

    @Provides
    public NoteDetailsView provideNoteDetailsView() {
        return view;
    }

    @Provides
    @Singleton
    public NoteDetailsPresenter provideNoteDetailsPresenter(NoteDetailsView view,
            NoteInteractor noteInteractor) {
        return new SimpleNoteDetailsPresenter(view, noteInteractor);
    }
}
