package com.reminder.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import com.reminder.Fragments.NoteFragment;
import com.reminder.Models.MyNote;

import java.util.ArrayList;

public class NotesFragmentPagerAdapter extends FragmentPagerAdapter {

    private FragmentManager fragmentManager;
    private final ArrayList<MyNote> notes;
    private final ViewPager pager;

    public NotesFragmentPagerAdapter(FragmentManager fragmentManager, ArrayList<MyNote> notes, ViewPager pager) {
        super(fragmentManager);
        this.fragmentManager = fragmentManager;
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
            }
        };
        return new NoteFragment().setContent(note).setDeleteListener(deleteListener);
    }

    @Override
    public int getItemPosition(Object object) {
        return PagerAdapter.POSITION_NONE;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
        android.support.v4.app.FragmentTransaction trans = fragmentManager.beginTransaction();
        trans.remove((Fragment)object);
        trans.commit();
    }

    @Override
    public int getCount() {
        return this.notes.size();
    }
}
