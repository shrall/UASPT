package com.example.werewolf.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
    ArrayList<Players>  thePlayers;
    Button nextVote;

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
            }
        });






    }
}
