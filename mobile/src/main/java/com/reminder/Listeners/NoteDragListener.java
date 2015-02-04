package com.reminder.Listeners;

import android.view.DragEvent;
import android.view.View;
import android.widget.BaseAdapter;

import com.reminder.ModelView.NoteHolder;
import com.reminder.Models.MyNote;

import java.util.ArrayList;

public class NoteDragListener implements View.OnDragListener {
    private ArrayList<MyNote> notes;
    private BaseAdapter adapter;

    public NoteDragListener(ArrayList<MyNote> notes, BaseAdapter adapter) {
        this.notes = notes;
        this.adapter = adapter;
    }

    @Override
    public boolean onDrag(View v, DragEvent event) {
        boolean result = true;
        int action = event.getAction();
        switch (action) {
            case DragEvent.ACTION_DRAG_STARTED:
                break;
            case DragEvent.ACTION_DRAG_LOCATION:
                v.setVisibility(View.GONE);
                break;
            case DragEvent.ACTION_DRAG_ENTERED:
                break;
            case DragEvent.ACTION_DRAG_EXITED:
                v.setVisibility(View.VISIBLE);
                break;
            case DragEvent.ACTION_DROP:
                View dropped = (View) event.getLocalState();
                MyNote dropItem = ((NoteHolder) dropped.getTag()).myNote;
                MyNote targetItem = ((NoteHolder) v.getTag()).myNote;
                int index = notes.indexOf(targetItem);
                notes.remove(dropItem);
                notes.add(index, dropItem);
                adapter.notifyDataSetChanged();
                break;
            case DragEvent.ACTION_DRAG_ENDED:
                v.setVisibility(View.VISIBLE);
                break;
            default:
                result = false;
                break;
        }
        return result;
    }
}
