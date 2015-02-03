package com.reminder;

import android.app.Application;

import com.reminder.Models.MyNote;

import java.util.ArrayList;

public class ReminderApp extends Application{
    private ArrayList<MyNote> notes = new ArrayList<>();

//    temporary static data added for testing as there is no data base
    {
        notes.add(new MyNote("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."));
        notes.add(new MyNote("Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut."));
        notes.add(new MyNote("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."));
        notes.add(new MyNote("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."));
    }

    public ArrayList<MyNote> getNotes() {
        return notes;
    }
}
