package com.corneliudascalu.mvpnotes.ui.view.main;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import com.corneliudascalu.mvpnotes.R;
import com.corneliudascalu.mvpnotes.common.BaseInjectedActivity;
import com.corneliudascalu.mvpnotes.data.model.Note;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimeFormatterBuilder;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;


public class NotesActivity extends BaseInjectedActivity implements NotesView {

    @InjectView(R.id.noteText)
    TextView noteText;
    @InjectView(R.id.submitNoteButton)
    Button submitNote;
    @InjectView(R.id.notesList)
    TextView notesList;

    @Inject
    NotesPresenter notesPresenter;
    DateTimeFormatter dateTimeFormatter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        ButterKnife.inject(this);
        DateTimeFormatterBuilder builder = new DateTimeFormatterBuilder();
        builder.appendHourOfDay(2).appendLiteral(":").appendMinuteOfHour(2).appendLiteral(":").appendSecondOfMinute(2);
        dateTimeFormatter = builder.toFormatter();
    }

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
    public void addNote(Note note) {
        notesList.append("\n---\n");
        notesList.append(note.title);
        notesList.append(" [" + note.createdDate.toString(dateTimeFormatter) + "] ");
        notesList.append("\n");
        notesList.append(note.text);
    }

}
