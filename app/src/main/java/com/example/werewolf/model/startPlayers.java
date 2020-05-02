package com.example.werewolf.model;

import android.net.Uri;

public class startPlayers {

    public String sname;
    public String srole;
    public Uri simg;

    public startPlayers() {
    }

    public startPlayers(String sname, String srole, Uri simg) {
        this.sname = sname;
        this.srole = srole;
        this.simg = simg;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSrole() {
        return srole;
    }

    public void setSrole(String srole) {
        this.srole = srole;
    }

    public Uri getSimg() {
        return simg;
    }

    public void setSimg(Uri simg) {
        this.simg = simg;
    }
}
