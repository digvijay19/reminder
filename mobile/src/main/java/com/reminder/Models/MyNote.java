package com.reminder.Models;

public class MyNote {

    private String text;

    public MyNote(String text) {
        this.text = text;
    }

    public String content() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
