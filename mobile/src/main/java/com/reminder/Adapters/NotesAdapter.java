package com.reminder.Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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
        if(convertView == null) {
            convertView = this.inflater.inflate(R.layout.note, parent, false);
            noteHolder = new NoteHolder(convertView, this.notes.get(position));
            convertView.setTag(noteHolder);
        }
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, NotesViewFragmentActivity.class);
                intent.putExtra("position", position);
                context.startActivity(intent);
            }
        });
        return convertView;
    }

    public void createEmptyNote() {
        notes.add(new MyNote(""));
        notifyDataSetChanged();
    }
}
