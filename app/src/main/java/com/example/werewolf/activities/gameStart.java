package com.example.werewolf.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.werewolf.R;
import com.example.werewolf.model.Players;
import com.example.werewolf.model.PlayersArray;
import com.example.werewolf.model.startPlayers;
import com.example.werewolf.model.startPlayersArray;

import java.util.ArrayList;

public class gameStart extends AppCompatActivity {
    int ww, vg, kn, sr, ht, roleselect;
    String playername, playerrole;
    Uri playerimg;
    Players p;
    Button tb;
    ArrayList<startPlayers> dePlayers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_start);
        tb = findViewById(R.id.btn_reveal);
        startPlayersArray.index = 0;
        ww = selectRoles.ww;
        sr = selectRoles.sr;
        ht = selectRoles.ht;
        vg = selectRoles.vg;
        kn = selectRoles.kn;
        if (startPlayersArray.declareRole == 0) {
            for (int i = 0; i < PlayersArray.theData.size(); i++) {
                p = PlayersArray.theData.get(i);
                playername = p.getPname();
                playerimg = p.getPimg();
                roleselect = (int) getRandomIntegerBetweenRange(1, 3);
                if (roleselect == 1) {
                    if (ww >= 1) {
                        playerrole = "ww";
                        ww--;
                    } else if (vg >= 1) {
                        playerrole = "vg";
                        vg--;
                    } else if (sr >= 1) {
                        playerrole = "sr";
                        sr--;
                    } else if (kn >= 1) {
                        playerrole = "kn";
                        kn--;
                    } else if (ht >= 1) {
                        playerrole = "ht";
                        ht--;
                    }
                } else if (roleselect == 2) {
                    if (sr >= 1) {
                        playerrole = "sr";
                        sr--;
                    } else if (ht >= 1) {
                        playerrole = "ht";
                        ht--;
                    } else if (ww >= 1) {
                        playerrole = "ww";
                        ww--;
                    } else if (kn >= 1) {
                        playerrole = "kn";
                        kn--;
                    } else if (vg >= 1) {
                        playerrole = "vg";
                        vg--;
                    }
                } else if (roleselect == 3) {
                    if (vg >= 1) {
                        playerrole = "vg";
                        vg--;
                    } else if (ht >= 1) {
                        playerrole = "ht";
                        ht--;
                    } else if (kn >= 1) {
                        playerrole = "kn";
                        kn--;
                    } else if (sr >= 1) {
                        playerrole = "sr";
                        sr--;
                    } else if (ww >= 1) {
                        playerrole = "ww";
                        ww--;
                    }
                }
                startPlayersArray.theData.add(new startPlayers(playername, playerrole, playerimg));
            }
            startPlayersArray.declareRole++;
        }
        dePlayers = startPlayersArray.theData;


        if (startPlayersArray.declareRole == 1) {
            for (int i = 0; i < dePlayers.size(); i++) {
                if (dePlayers.get(i).getSrole().equals("ww")) {
                    startPlayersArray.werewolves.add(dePlayers.get(i).getSname());
                } else {

                }
            }
            startPlayersArray.declareRole++;
        }

        tb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if (startPlayersArray.declareRole == 2) {
                Intent intent = new Intent(gameStart.this, playerPrompt.class);
                startActivity(intent);
//                Toast.makeText(gameStart.this, String.valueOf(startPlayersArray.theData.size())
//                        + startPlayersArray.killed.size() + startPlayersArray.killedPlayer.size() +
//                        startPlayersArray.huntedPlayer.size() + startPlayersArray.guardedPlayer.size() +
//                        startPlayersArray.index + startPlayersArray.werewolves.size(), Toast.LENGTH_LONG).show();
//                }
//                else {
//                    Toast.makeText(gameStart.this, String.valueOf(startPlayersArray.theData.size())
//                            + startPlayersArray.killed.size() + startPlayersArray.killedPlayer.size() +
//                            startPlayersArray.huntedPlayer.size() + startPlayersArray.guardedPlayer.size() +
//                            startPlayersArray.index + startPlayersArray.werewolves.size(), Toast.LENGTH_SHORT).show();
//                }
            }
        });

    }


    public static double getRandomIntegerBetweenRange(double min, double max) {
        double x = (int) (Math.random() * ((max - min) + 1)) + min;
        return x;
    }
    @Override
    public void onBackPressed() {

    }
}
