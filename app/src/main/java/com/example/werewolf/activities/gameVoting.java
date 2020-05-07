package com.example.werewolf.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.werewolf.R;
import com.example.werewolf.adapter.playersAdapter;
import com.example.werewolf.model.Players;
import com.example.werewolf.model.PlayersArray;
import com.example.werewolf.model.startPlayersArray;
import com.example.werewolf.utils.itemClickSupport;

import java.util.ArrayList;

public class gameVoting extends AppCompatActivity {

    TextView actionedPlayer, votingPlayer;
    ImageView votingPlayerImg;
    ArrayList<Players> thePlayers;
    Button nextVote;
    int voteCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_voting);
        actionedPlayer = findViewById(R.id.playernameaction);
        votingPlayer = findViewById(R.id.playerrolename);
        votingPlayerImg = findViewById(R.id.player_imgprompt);
        nextVote = findViewById(R.id.confirmactionbtn);
        votingPlayer.setText(PlayersArray.theData.get(startPlayersArray.index).getPname());
        votingPlayerImg.setImageURI(PlayersArray.theData.get(startPlayersArray.index).getPimg());
        thePlayers = PlayersArray.theData;
        RecyclerView myrv = findViewById(R.id.rv_turn);
        playersAdapter myAdapter = new playersAdapter(this, thePlayers);
        myrv.setLayoutManager(new GridLayoutManager(this, 3));
        myrv.setAdapter(myAdapter);
        itemClickSupport.addTo(myrv).setOnItemClickListener(new itemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                actionedPlayer.setText(thePlayers.get(position).getPname());
                voteCounter = position;
            }
        });

        if (voteCounter == 0) {
            startPlayersArray.one++;
        } else if (voteCounter == 1) {
            startPlayersArray.two++;
        } else if (voteCounter == 2) {
            startPlayersArray.three++;
        } else if (voteCounter == 3) {
            startPlayersArray.four++;
        } else if (voteCounter == 4) {
            startPlayersArray.five++;
        } else if (voteCounter == 5) {
            startPlayersArray.six++;
        } else if (voteCounter == 6) {
            startPlayersArray.seven++;
        } else if (voteCounter == 7) {
            startPlayersArray.eight++;
        }

        nextVote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (startPlayersArray.index + 1 < startPlayersArray.theData.size()) {
                    startPlayersArray.index++;
                    Intent intent = new Intent(gameVoting.this, gameVoting.class);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(gameVoting.this, finishVote.class);
                    startActivity(intent);
                }
            }
        });


    }
}
