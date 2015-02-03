package com.reminder.Models;

public class MyNote {

    private String text;
    private int position;

    public MyNote(String text, int position) {
        this.text = text;
        this.position = position;
    }

    public String content() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getPosition() {
        return position;
    }
}
