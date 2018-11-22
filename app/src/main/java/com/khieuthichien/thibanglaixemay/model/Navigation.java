package com.khieuthichien.thibanglaixemay.model;

public class Navigation {

    private String title;
    private boolean color;

    public Navigation(String title){
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isColor() {
        return color;
    }

    public void setColor(boolean color) {
        this.color = color;
    }
}

