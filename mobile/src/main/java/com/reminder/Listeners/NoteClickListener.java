package com.reminder.Listeners;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.reminder.Activities.NotesViewFragmentActivity;
import com.reminder.ModelView.NoteHolder;

public class NoteClickListener implements View.OnClickListener {
    private Context context;

    public NoteClickListener(Context context) {
        this.context = context;
    }

    @Override
    public void onClick(View v) {
        NoteHolder holder = (NoteHolder) v.getTag();
        Intent intent = new Intent(context, NotesViewFragmentActivity.class);
        intent.putExtra("position", holder.getPosition());
        context.startActivity(intent);
    }
}
