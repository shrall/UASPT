package com.example.werewolf.model;

import java.util.ArrayList;

public class startPlayersArray {

    public static ArrayList<startPlayers> theData = new ArrayList<>();
    public static ArrayList<String> killedPlayer = new ArrayList<>();
    public static ArrayList<String> huntedPlayer = new ArrayList<>();
    public static ArrayList<String> guardedPlayer = new ArrayList<>();
    //buat ngasih tau siapa aja wwnya ke ww lain
    public static ArrayList<String> werewolves = new ArrayList<>();;
    //buat tau udh hunt atau belum
    public static ArrayList<String> huntered = new ArrayList<>();
    //buat ngasih tau siapa aja yg dibunuh
    public static ArrayList<String> killed = new ArrayList<>();
    public static Integer index = 0;
    public static String seered = "";
    public static String seeredplayer = "";
}
