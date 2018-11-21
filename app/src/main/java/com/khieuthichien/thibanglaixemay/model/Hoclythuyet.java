package com.khieuthichien.thibanglaixemay.model;

public class Hoclythuyet {
    private int anhhoclythuyet;
    private String tieudehoclythuyet;
    private String socauhoclythuyet;

    public Hoclythuyet(int anhhoclythuyet, String tieudehoclythuyet, String socauhoclythuyet) {
        this.anhhoclythuyet = anhhoclythuyet;
        this.tieudehoclythuyet = tieudehoclythuyet;
        this.socauhoclythuyet = socauhoclythuyet;
    }

    public Hoclythuyet() {
    }

    public int getAnhhoclythuyet() {
        return anhhoclythuyet;
    }

    public void setAnhhoclythuyet(int anhhoclythuyet) {
        this.anhhoclythuyet = anhhoclythuyet;
    }

    public String getTieudehoclythuyet() {
        return tieudehoclythuyet;
    }

    public void setTieudehoclythuyet(String tieudehoclythuyet) {
        this.tieudehoclythuyet = tieudehoclythuyet;
    }

    public String getSocauhoclythuyet() {
        return socauhoclythuyet;
    }

    public void setSocauhoclythuyet(String socauhoclythuyet) {
        this.socauhoclythuyet = socauhoclythuyet;
    }
}
