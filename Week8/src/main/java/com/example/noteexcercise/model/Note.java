package com.example.noteexcercise.model;

import java.io.Serializable;

public class Note implements Serializable {

    static final long serialVersionUID = 42L;
    private String headlines;
    private String body;
    private int imageId;
    private boolean liked;

    public Note(String headlines, String body, int imageId) {
        this.headlines = headlines;
        this.body = body;
        this.imageId = imageId;
        this.liked = false;
    }

    public Note(String headlines, String body) {
        this.headlines = headlines;
        this.body = body;
    }

    public String getHeadlines() {
        return headlines;
    }

    public String getBody() {
        return body;
    }

    public boolean isLiked() {
        return liked;
    }

    public void toggledLiked() {
        this.liked = !liked;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
