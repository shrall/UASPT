package com.example.werewolf.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.werewolf.R;
import com.example.werewolf.adapter.playersAdapter;
import com.example.werewolf.model.Players;
import com.example.werewolf.model.PlayersArray;
import com.example.werewolf.model.startPlayersArray;

import java.util.ArrayList;

public class villagerWin extends AppCompatActivity {

    TextView congrats;
    Button btn;
    ArrayList<Players> thePlayers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_villager_win);
        finishTurn.daystart.start();
        finishTurn.daybgm.start();
        finishTurn.daybgm.setLooping(true);
        gameStart.nightbgm.stop();
        gameStart.nightbgm.setLooping(false);
        thePlayers = PlayersArray.theData;
        RecyclerView myrv = findViewById(R.id.myrv);
        playersAdapter myAdapter = new playersAdapter(this, thePlayers);
        myrv.setLayoutManager(new GridLayoutManager(this, 3));
        myrv.setAdapter(myAdapter);
        congrats = findViewById(R.id.tvguide);
        btn = findViewById(R.id.btn_reveal);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startPlayersArray.theData.clear();
                PlayersArray.theData.clear();
                startPlayersArray.killed.clear();
                startPlayersArray.werewolves.clear();
                startPlayersArray.huntered.clear();
                startPlayersArray.index = 0;
                startPlayersArray.declareRole = 0;
                finishTurn.daybgm.stop();
                finishTurn.daybgm.setLooping(false);
                Intent intent = new Intent(villagerWin.this, mainmenu.class);
                startActivity(intent);
                finish();
            }
        });
    }
    @Override
    public void onBackPressed() {
    }
}
