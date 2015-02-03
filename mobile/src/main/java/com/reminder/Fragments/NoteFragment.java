package com.reminder.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;

import com.reminder.Models.MyNote;
import com.reminder.R;

public class NoteFragment extends Fragment {

    private MyNote note;
    private View.OnClickListener deleteListener;
    private Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.edit_note, container, false);
        final EditText editText = (EditText) view.findViewById(R.id.note_text_edit);
        editText.setText(note.content());
        final Button saveButton = (Button) view.findViewById(R.id.save_note_changes);
        Button deleteButton = (Button) view.findViewById(R.id.delete_note);

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_out_right);
                animation.setDuration(500);
                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        try {
                            FragmentTransaction ft = ((FragmentActivity) context).getSupportFragmentManager().beginTransaction();
                            ft.remove(NoteFragment.this);
                            ft.commit();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        deleteListener.onClick(v);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                view.startAnimation(animation);
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                note.setText(editText.getText().toString());
                saveButton.setVisibility(View.GONE);
            }
        });

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                saveButton.setVisibility(View.GONE);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                saveButton.setVisibility(View.VISIBLE);
            }
        });

        return view;
    }

    public NoteFragment setContent(MyNote n) {
        note = n;
        return this;
    }

    public NoteFragment setDeleteListener(View.OnClickListener deleteListener) {
        this.deleteListener = deleteListener;
        return this;
    }

    public NoteFragment setContext(Context context) {
        this.context = context;
        return this;
    }

}
