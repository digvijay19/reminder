package com.reminder.ModelView;

import android.view.View;
import android.widget.TextView;

import com.reminder.Models.MyNote;
import com.reminder.R;

public class NoteHolder {
    private TextView textView;
    public MyNote myNote;

    public NoteHolder(View view, final MyNote myNote) {
        this.myNote = myNote;

        textView = (TextView) view.findViewById(R.id.note_text);
        textView.setText(myNote.content());
    }
}
