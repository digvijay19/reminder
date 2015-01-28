package com.reminder.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.reminder.R;
import com.reminder.Reminder;

import java.util.ArrayList;

public class NotesAdapter extends BaseAdapter{
    private final LayoutInflater inflater;
    private ArrayList<String> notes;

    public NotesAdapter(ArrayList<String> notes, Reminder reminder) {
        this.notes = notes;
        this.inflater = (LayoutInflater) reminder.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = this.inflater.inflate(R.layout.note, null);
        TextView textview = (TextView) view.findViewById(R.id.note_text);
        textview.setText(notes.get(position));
        return view;
    }

    public void createEmptyNote() {
        notes.add("");
        notifyDataSetChanged();
    }
}
