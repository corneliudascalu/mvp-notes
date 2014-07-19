package com.corneliudascalu.mvpnotes.ui.view.main;

import com.corneliudascalu.mvpnotes.R;
import com.corneliudascalu.mvpnotes.common.BaseInjectedActivity;
import com.corneliudascalu.mvpnotes.data.model.Note;

import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimeFormatterBuilder;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;


public class NotesActivity extends BaseInjectedActivity implements NotesView {

    @InjectView(R.id.noteText)
    TextView noteText;

    @InjectView(R.id.submitNoteButton)
    Button submitNote;

    @InjectView(R.id.notesList)
    ListView notesList;

    @Inject
    NotesPresenter notesPresenter;

    DateTimeFormatter dateTimeFormatter;

    private ArrayAdapter<Note> mAdapter;

    private ArrayList<Note> mNotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        ButterKnife.inject(this);
        DateTimeFormatterBuilder builder = new DateTimeFormatterBuilder();
        builder.appendHourOfDay(2).appendLiteral(":").appendMinuteOfHour(2).appendLiteral(":")
                .appendSecondOfMinute(2);
        dateTimeFormatter = builder.toFormatter();

        mNotes = new ArrayList<Note>();
        mAdapter = new ArrayAdapter<Note>(this,
                android.R.layout.simple_list_item_2, mNotes) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                if (convertView == null) {
                    convertView = LayoutInflater.from(parent.getContext())
                            .inflate(android.R.layout.simple_list_item_2, parent, false);
                }

                Note note = getItem(position);
                ((TextView) convertView.findViewById(android.R.id.text1)).setText(note.title);
                ((TextView) convertView.findViewById(android.R.id.text2)).setText(note.text);

                return convertView;
            }
        };

        notesList.setAdapter(mAdapter);
        notesPresenter.requestNotes();
    }

    /**
     * We'll need the {@link com.corneliudascalu.mvpnotes.ui.view.main.NotesModule} to supply the
     * {@link com
     * .corneliudascalu.mvpnotes.ui.view.main.NotesPresenter} (and maybe other stuff, in the
     * future)
     */
    @Override
    protected List<Object> getModules() {
        return Arrays.<Object>asList(new NotesModule(this));
    }

    @OnClick(R.id.submitNoteButton)
    public void submitNote() {
        notesPresenter.submitNewNote("Note", noteText.getText().toString());
        noteText.setText(null);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.notes, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setNoteError(String error) {
        noteText.setError(error);
    }

    @Override
    public void addNotes(Note... notes) {
        Collections.addAll(mNotes, notes);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void removeNote(Note note) {
        mNotes.remove(note);
        mAdapter.notifyDataSetChanged();
    }

}
