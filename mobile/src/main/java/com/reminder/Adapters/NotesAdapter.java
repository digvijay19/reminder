package com.reminder.Adapters;

import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.reminder.Activities.NotesViewFragmentActivity;
import com.reminder.ModelView.NoteHolder;
import com.reminder.Models.MyNote;
import com.reminder.R;

import java.util.ArrayList;

public class NotesAdapter extends BaseAdapter {
    private final LayoutInflater inflater;
    private final Context context;
    private ArrayList<MyNote> notes;

    public NotesAdapter(ArrayList<MyNote> notes, Context context) {
        this.context = context;
        this.notes = notes;
        this.inflater = ((Activity)context).getLayoutInflater();
    }

    @Override
    public int getCount() {
        return notes.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        NoteHolder noteHolder;
        if(convertView == null)
            convertView = this.inflater.inflate(R.layout.note, parent, false);
        noteHolder = new NoteHolder(convertView, this.notes.get(position));
        convertView.setTag(noteHolder);
        convertView.setOnClickListener(new NoteClickListener());
        convertView.setOnLongClickListener(new LongClickOfNoteListener());
        convertView.setOnDragListener(new NoteDragListener());
        return convertView;
    }

    public void createEmptyNote() {
        notes.add(new MyNote("", notes.size()));
        notifyDataSetChanged();
    }

    private final class LongClickOfNoteListener implements View.OnLongClickListener {
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

    class NoteDragListener implements View.OnDragListener {
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
                    notifyDataSetChanged();
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

    private class NoteClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            NoteHolder holder = (NoteHolder) v.getTag();
            Intent intent = new Intent(context, NotesViewFragmentActivity.class);
            intent.putExtra("position", holder.getPosition());
            context.startActivity(intent);
        }
    }
}
