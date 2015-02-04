package com.reminder.Listeners;

import android.content.ClipData;
import android.view.View;

import com.reminder.ModelView.NoteHolder;
import com.reminder.Models.MyNote;

public class NoteLongClickListener implements View.OnLongClickListener {
    @Override
    public boolean onLongClick(View view) {
        NoteHolder holder = (NoteHolder) view.getTag();
        MyNote currentItem = holder.myNote;
        String text = currentItem.content();
        ClipData data = ClipData.newPlainText("DragData", text);
        View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
        view.startDrag(data, shadowBuilder, view, 0);
        return true;
    }
}

