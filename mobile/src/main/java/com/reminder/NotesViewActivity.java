package com.reminder;

import android.content.ClipData;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.DragEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.reminder.Adapters.NotesAdapter;
import com.reminder.ModelView.NoteHolder;
import com.reminder.Models.MyNote;

import java.util.ArrayList;
import java.util.List;

public class NotesViewActivity extends ActionBarActivity {

    private NotesAdapter notesAdapter;
    ArrayList<MyNote> notes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder);

        notes = ((ReminderApp) getApplicationContext()).getNotes();
        GridView notesGrids = (GridView) findViewById(R.id.notes);
        notesAdapter = new NotesAdapter(notes, NotesViewActivity.this);
        notesGrids.setAdapter(notesAdapter);

        setDrag();
    }

    private void setDrag() {
        GridView grid = (GridView) findViewById(R.id.notes);
        grid.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                GridView parent = (GridView) v;
                int x = (int) event.getX();
                int y = (int) event.getY();

                int position = parent.pointToPosition(x, y);
                if (position > AdapterView.INVALID_POSITION) {

                    for (int i = 0; i < parent.getChildCount(); i++) {
                        View curr = parent.getChildAt(i);
                        curr.setOnDragListener(new View.OnDragListener() {

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
                                        List<MyNote> items = notesAdapter.getNotes();
                                        MyNote targetItem = ((NoteHolder) v.getTag()).myNote;
                                        int index = items.indexOf(targetItem);
                                        items.remove(dropItem);
                                        items.add(index, dropItem);
                                        notesAdapter.notifyDataSetChanged();
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
                        });
                    }

                    int relativePosition = position - parent.getFirstVisiblePosition();
                    View target = parent.getChildAt(relativePosition);
                    NoteHolder holder = (NoteHolder) target.getTag();
                    MyNote currentItem = holder.myNote;
                    String text = currentItem.content();
                    ClipData data = ClipData.newPlainText("DragData", text);
                    target.startDrag(data, new View.DragShadowBuilder(target), target, 0);
                }
                return false;
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        notesAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_reminder, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_add_note) {
            notesAdapter.createEmptyNote();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
