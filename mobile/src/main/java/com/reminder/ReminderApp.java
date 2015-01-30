package com.reminder;

import android.app.Application;

import com.reminder.Models.MyNote;

import java.util.ArrayList;

public class ReminderApp extends Application{
    private ArrayList<MyNote> notes = new ArrayList<>();

//    temporary static data added for testing as there is no data base
    {
        notes.add(new MyNote("This is my first note"));
        notes.add(new MyNote("This is my second note"));
        notes.add(new MyNote("This is my third note"));
        notes.add(new MyNote("This is my 4th note and a very very very very very big note which cant fit in one line"));
    }

    public ArrayList<MyNote> getNotes() {
        return notes;
    }
}
