package com.khieuthichien.thibanglaixemay.model;

public class Thisathach {
    private String tencacdethi;
    private int anhcacdethi;

    public Thisathach(String tencacdethi, int anhcacdethi) {
        this.tencacdethi = tencacdethi;
        this.anhcacdethi = anhcacdethi;
    }

    public Thisathach() {
    }

    public String getTencacdethi() {
        return tencacdethi;
    }

    public void setTencacdethi(String tencacdethi) {
        this.tencacdethi = tencacdethi;
    }

    public int getAnhcacdethi() {
        return anhcacdethi;
    }

    public void setAnhcacdethi(int anhcacdethi) {
        this.anhcacdethi = anhcacdethi;
    }
}
