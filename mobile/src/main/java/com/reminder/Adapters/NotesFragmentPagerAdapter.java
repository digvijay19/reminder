package com.reminder.Adapters;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.reminder.Fragments.NoteFragment;
import com.reminder.Models.MyNote;

import java.util.ArrayList;

public class NotesFragmentPagerAdapter extends FragmentPagerAdapter {

    private Context context;
    private final ArrayList<MyNote> notes;
    private final ViewPager pager;

    public NotesFragmentPagerAdapter(Context context, FragmentManager fragmentManager, ArrayList<MyNote> notes, ViewPager pager) {
        super(fragmentManager);
        this.context = context;
        this.notes = notes;
        this.pager = pager;
    }

    @Override
    public Fragment getItem(final int index) {
        final MyNote note = this.notes.get(index);
        View.OnClickListener deleteListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notes.remove(pager.getCurrentItem());
                notifyDataSetChanged();
                if(notes.isEmpty())
                    ((Activity)context).finish();
            }
        };
        return new NoteFragment().setContent(note).setDeleteListener(deleteListener).setContext(context);
    }

    @Override
    public int getItemPosition(Object object) {
        return PagerAdapter.POSITION_NONE;
    }

    @Override
    public int getCount() {
        return this.notes.size();
    }
}
