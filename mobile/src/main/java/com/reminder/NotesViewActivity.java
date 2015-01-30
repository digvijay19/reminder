package com.reminder;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.reminder.Adapters.NotesAdapter;
import com.reminder.Models.MyNote;

import java.util.ArrayList;

public class NotesViewActivity extends ActionBarActivity {

    private NotesAdapter notesAdapter;
    ArrayList<MyNote> notes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder);

        notes = ((ReminderApp) getApplicationContext()).getNotes();
        ListView notesList = (ListView) findViewById(R.id.notes);
        notesAdapter = new NotesAdapter(notes, NotesViewActivity.this);
        notesList.setAdapter(notesAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        notesAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_reminder, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_add_note) {
            notesAdapter.createEmptyNote();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
