package com.corneliudascalu.mvpnotes.tests;

import android.app.Application;
import android.test.ActivityInstrumentationTestCase2;
import com.corneliudascalu.mvpnotes.AppModule;
import com.corneliudascalu.mvpnotes.MVPNotesApp;
import com.corneliudascalu.mvpnotes.R;
import com.corneliudascalu.mvpnotes.common.ObjectGraphCreator;
import com.corneliudascalu.mvpnotes.common.ObjectGraphHolder;
import com.corneliudascalu.mvpnotes.ui.view.main.NotesActivity;
import com.google.android.apps.common.testing.ui.espresso.ViewInteraction;
import dagger.ObjectGraph;

import static com.google.android.apps.common.testing.ui.espresso.Espresso.onView;
import static com.google.android.apps.common.testing.ui.espresso.action.ViewActions.click;
import static com.google.android.apps.common.testing.ui.espresso.action.ViewActions.typeText;
import static com.google.android.apps.common.testing.ui.espresso.assertion.ViewAssertions.matches;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withId;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withText;

/**
 * @author Corneliu Dascalu <corneliu.dascalu@osf-global.com>
 */
public class MainInstrumentationTest extends ActivityInstrumentationTestCase2<NotesActivity> {
    private NotesActivity notesActivity;

    public MainInstrumentationTest() {
        super(NotesActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        ObjectGraphHolder.forceObjectGraphCreator(new ObjectGraphCreator() {
            @Override
            public ObjectGraph create(Application application) {
                return ObjectGraph.create(new AppModule((MVPNotesApp) application), new MockNoteInteractorModule());
            }
        });

        notesActivity = getActivity();
    }

    public void testSimpleExistence() {
        onView(withId(R.id.submitNoteButton)).check(matches(withText(R.string.create)));
    }

    public void testSubmitNote() {

        ViewInteraction viewInteraction = onView(withId(R.id.noteText));
        viewInteraction.perform(click());
        viewInteraction.perform(typeText("test note"));
        onView(withId(R.id.submitNoteButton)).perform(click());

    }
}
