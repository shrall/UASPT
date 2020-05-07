package com.example.werewolf.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.werewolf.R;
import com.example.werewolf.adapter.playersAdapter;
import com.example.werewolf.model.Players;
import com.example.werewolf.model.PlayersArray;
import com.example.werewolf.utils.itemClickSupport;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class playersPage extends AppCompatActivity {

    ArrayList<Players> thePlayers;
    Toolbar toolbar;
    FloatingActionButton fab;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_players_page);

        //back toolbar button
        toolbar = findViewById(R.id.playersToolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(playersPage.this, mainmenu.class);
                startActivity(intent);
            }
        });
        //add player fab
        fab = findViewById(R.id.addPlayers);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(playersPage.this, addPlayers.class);
                startActivity(intent);
            }
        });



        //play button
        button = findViewById(R.id.btn_confirm_player);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (thePlayers.size()>=3 && thePlayers.size()<=8){
                    Intent intent = new Intent(playersPage.this, selectRoles.class);
                    startActivity(intent);
                } else if(thePlayers.size()<=3){
                    Toast.makeText(playersPage.this, "Minimum 3 Players are required to play!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(playersPage.this, "Maximum 8 Players!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        thePlayers = PlayersArray.theData;

        RecyclerView myrv = findViewById(R.id.rv_player);
        playersAdapter myAdapter = new playersAdapter(this, thePlayers);
        myrv.setLayoutManager(new GridLayoutManager(this,3));
        myrv.setAdapter(myAdapter);
        itemClickSupport.addTo(myrv).setOnItemClickListener(new itemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                Intent intent = new Intent(playersPage.this, deletePlayers.class);
                intent.putExtra(deletePlayers.EXTRA_PLAYERS, thePlayers.get(position));
                startActivity(intent);
            }
        });
    }
    @Override
    public void onBackPressed(){
        Intent intent = new Intent(playersPage.this, mainmenu.class);
        startActivity(intent);

//        Toast.makeText(MainActivity.this, "Press back again to exit.", Toast.LENGTH_SHORT).show();
    }
    
}
