package com.corneliudascalu.mvpnotes.ui.view.details;

import com.corneliudascalu.mvpnotes.R;
import com.corneliudascalu.mvpnotes.common.InjectedDialogFragment;
import com.corneliudascalu.mvpnotes.data.model.Note;
import com.corneliudascalu.mvpnotes.ui.view.details.interfaces.NoteDetailsPresenter;
import com.corneliudascalu.mvpnotes.ui.view.details.interfaces.NoteDetailsView;

import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimeFormatterBuilder;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * @author Corneliu Dascalu <corneliu.dascalu@gmail.com>
 */
public class NoteDetailsDialogFragment extends InjectedDialogFragment implements NoteDetailsView {

    public static final String TAG = "noteDetailsTag";

    @InjectView(R.id.noteText)
    TextView noteText;

    @InjectView(R.id.noteDate)
    TextView noteDateText;

    @InjectView(R.id.deleteNoteButton)
    ImageButton deleteButton;

    @Inject
    NoteDetailsPresenter mPresenter;

    private DateTimeFormatter mFormatter;

    public static NoteDetailsDialogFragment newInstance(Note note) {
        Bundle args = new Bundle();
        args.putParcelable(Note.EXTRA_NOTE, note);
        NoteDetailsDialogFragment fragment = new NoteDetailsDialogFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            setData(getArguments());
        }

        DateTimeFormatterBuilder builder = new DateTimeFormatterBuilder();
        mFormatter = builder
                .appendYear(4, 4).appendLiteral("-")
                .appendMonthOfYear(2).appendLiteral("-")
                .appendDayOfMonth(2).appendLiteral(" at ")
                .appendHourOfDay(2).appendLiteral(":")
                .appendMinuteOfHour(2)
                .toFormatter();
    }

    private void setData(Bundle arguments) {
        if (arguments != null) {
            Note note = arguments.getParcelable(Note.EXTRA_NOTE);
            mPresenter.setData(note);
        }
    }

    @Override
    protected List<Object> getModules() {
        return Arrays.<Object>asList(new NoteDetailsModule(this));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.note_details, container, false);
        ButterKnife.inject(this, view);

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.deleteNote();
            }
        });

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter.viewReady();
    }

    @Override
    public void setNote(Note note) {
        getDialog().setTitle(note.title);
        noteText.setText(note.text);
        noteDateText.setText(note.createdDate.toString(mFormatter));
    }

    @Override
    public void close() {
        dismiss();
    }

    @Override
    public void showError(String error) {
        Toast.makeText(getActivity(), error, Toast.LENGTH_SHORT).show();
    }
}
