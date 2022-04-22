package com.example.catsessions;

public class User {
    private int img;
    private String text;

    public User(int img, String text) {
        this.img = img;
        this.text = text;
    }

    public int getImg() {
        return img;
    }

    public String getText() {
        return text;
    }
}
