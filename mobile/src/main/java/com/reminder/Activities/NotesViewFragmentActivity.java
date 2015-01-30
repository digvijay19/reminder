package com.reminder.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.reminder.Adapters.NotesFragmentPagerAdapter;
import com.reminder.Models.MyNote;
import com.reminder.R;
import com.reminder.ReminderApp;

import java.util.ArrayList;

public class NotesViewFragmentActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notes_view_layout);
        ArrayList<MyNote> notes = ((ReminderApp) getApplicationContext()).getNotes();

        Intent intent = getIntent();
        int position = intent.getIntExtra("position", 0);

        ViewPager viewPager = (ViewPager) findViewById(R.id.notes_view_pager);
        final NotesFragmentPagerAdapter notesFragmentPagerAdapter = new NotesFragmentPagerAdapter(getSupportFragmentManager(), notes, viewPager);
        viewPager.setAdapter(notesFragmentPagerAdapter);
        viewPager.setCurrentItem(position);
    }
}