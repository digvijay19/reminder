package com.reminder;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.reminder.Adapters.NotesAdapter;

import java.util.ArrayList;

public class Reminder extends ActionBarActivity {

    private NotesAdapter notesAdapter;
    private ListView notesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder);

        ArrayList<String> notes = new ArrayList<>();
        notes.add("This is my first note");
        notes.add("This is my second note");
        notes.add("This is my third note");
        notes.add("This is my 4th note and a very very very very very big note which cant fit in one line");

        notesList = (ListView) findViewById(R.id.notes);
        notesList.setVisibility(View.VISIBLE);
        notesAdapter = new NotesAdapter(notes, Reminder.this);
        notesList.setAdapter(notesAdapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_reminder, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_add_note) {
            notesAdapter.createEmptyNote();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
