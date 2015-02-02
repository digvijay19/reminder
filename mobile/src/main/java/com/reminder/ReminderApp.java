package com.reminder;

import android.app.Application;

import com.reminder.Models.MyNote;

import java.util.ArrayList;

public class ReminderApp extends Application{
    private ArrayList<MyNote> notes = new ArrayList<>();

//    temporary static data added for testing as there is no data base
    {
        notes.add(new MyNote("first note"));
        notes.add(new MyNote("first notefirst note"));
        notes.add(new MyNote("first notefirst notefirst note"));
        notes.add(new MyNote("first notefirst notefirst notefirst note"));
        notes.add(new MyNote("first notefirst notefirst notefirst notefirst note"));
        notes.add(new MyNote("first notefirst notefirst notefirst notefirst notefirst note"));
        notes.add(new MyNote("first notefirst notefirst notefirst notefirst notefirst notefirst note"));
        notes.add(new MyNote("first notefirst notefirst notefirst notefirst notefirst notefirst notefirst note"));
        notes.add(new MyNote("first notefirst notefirst notefirst notefirst notefirst notefirst notefirst notefirst note"));
        notes.add(new MyNote("first notefirst notefirst notefirst notefirst notefirst notefirst notefirst notefirst notefirst note"));
        notes.add(new MyNote("first notefirst notefirst notefirst notefirst notefirst notefirst notefirst notefirst notefirst notefirst note"));
        notes.add(new MyNote("first notefirst notefirst notefirst notefirst notefirst notefirst notefirst notefirst notefirst notefirst notefirst note"));
        notes.add(new MyNote("first notefirst notefirst notefirst notefirst notefirst notefirst notefirst notefirst notefirst notefirst notefirst notefirst note"));
        notes.add(new MyNote("first notefirst notefirst notefirst notefirst notefirst notefirst notefirst notefirst notefirst notefirst notefirst notefirst notefirst note"));
        notes.add(new MyNote("first notefirst notefirst notefirst notefirst notefirst notefirst notefirst notefirst notefirst notefirst notefirst notefirst notefirst notefirst note"));
        notes.add(new MyNote("first notefirst notefirst notefirst notefirst notefirst notefirst notefirst notefirst notefirst notefirst notefirst notefirst notefirst notefirst notefirst note"));
        notes.add(new MyNote("first notefirst notefirst notefirst notefirst notefirst notefirst notefirst notefirst notefirst notefirst notefirst notefirst notefirst notefirst notefirst notefirst note"));
        notes.add(new MyNote("first notefirst notefirst notefirst notefirst notefirst notefirst notefirst notefirst notefirst notefirst notefirst notefirst notefirst notefirst notefirst notefirst notefirst note"));
        notes.add(new MyNote("first notefirst notefirst notefirst notefirst notefirst notefirst notefirst notefirst notefirst notefirst notefirst notefirst notefirst notefirst notefirst notefirst notefirst notefirst note"));
        notes.add(new MyNote("first notefirst notefirst notefirst notefirst notefirst notefirst notefirst notefirst notefirst notefirst notefirst notefirst notefirst notefirst notefirst notefirst notefirst notefirst notefirst note"));
        notes.add(new MyNote("first notefirst notefirst notefirst notefirst notefirst notefirst notefirst notefirst notefirst notefirst notefirst notefirst notefirst notefirst notefirst notefirst notefirst notefirst notefirst notefirst note"));
        notes.add(new MyNote("This is my 4th note and a very very very very very big note which cant fit in one line This is my 4th note and a very very very very very big note which cant fit in one line note which cant fit in one line note which cant"));
    }

    public ArrayList<MyNote> getNotes() {
        return notes;
    }
}
