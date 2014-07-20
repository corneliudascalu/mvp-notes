package com.corneliudascalu.mvpnotes.ui.view.details;

import com.corneliudascalu.mvpnotes.data.interactor.NoteInteractor;
import com.corneliudascalu.mvpnotes.data.model.Note;
import com.corneliudascalu.mvpnotes.ui.view.details.interfaces.NoteDetailsPresenter;
import com.corneliudascalu.mvpnotes.ui.view.details.interfaces.NoteDetailsView;
import com.corneliudascalu.mvpnotes.ui.view.main.OnNoteOperationListener;

import java.util.List;

/**
 * @author Corneliu Dascalu <corneliu.dascalu@gmail.com>
 */
public class SimpleNoteDetailsPresenter implements NoteDetailsPresenter {

    private final NoteDetailsView view;

    private final NoteInteractor interactor;

    private Note note;

    public SimpleNoteDetailsPresenter(NoteDetailsView view, NoteInteractor interactor) {
        this.view = view;
        this.interactor = interactor;
    }

    @Override
    public void setData(Note note) {
        this.note = note;
    }

    @Override
    public void viewReady() {
        view.setNote(note);
    }

    @Override
    public void deleteNote() {
        interactor.deleteNote(note, new OnNoteOperationListener() {
            @Override
            public void onNoteAdded(Note note) {

            }

            @Override
            public void onNoteAddError(Note.Error error) {

            }

            @Override
            public void onNoteDeleted(Note note) {
                view.close();
            }

            @Override
            public void onNoteDeleteError(Note.Error error) {
                view.showError(error.getMessage());
                view.close();
            }

            @Override
            public void onNoteRetrieved(Note note) {

            }

            @Override
            public void onNoteListRetrieved(List<Note> notes) {

            }

            @Override
            public void onRetrieveError(Note.Error error) {

            }
        });
    }
}
