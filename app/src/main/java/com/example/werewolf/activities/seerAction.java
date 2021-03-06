package com.example.werewolf.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.werewolf.R;
import com.example.werewolf.model.startPlayersArray;

public class seerAction extends AppCompatActivity {

    TextView playername, playerrole;
    ImageView seeredroleimg;
    String pname,prole;
    Button confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seer_action);
        seeredroleimg = findViewById(R.id.ivplayerrole);
        playername = findViewById(R.id.playerseeredname);
        playerrole = findViewById(R.id.playerseeredrolename);
        confirm = findViewById(R.id.confirmactionbtn);
        pname = startPlayersArray.seeredplayer;
        prole = startPlayersArray.seered;
        playername.setText(pname);
        if (prole.equals("vg")) {
            playerrole.setText("Villager");
            seeredroleimg.setImageDrawable(getDrawable(R.drawable.villagerrole));
        } else if (prole.equals("ww")) {
            playerrole.setText("Werewolf");
            seeredroleimg.setImageDrawable(getDrawable(R.drawable.wolfrole));
        } else if (prole.equals("ht")) {
            playerrole.setText("Villager");
            seeredroleimg.setImageDrawable(getDrawable(R.drawable.villagerrole));
        } else if (prole.equals("sr")) {
            playerrole.setText("Villager");
            seeredroleimg.setImageDrawable(getDrawable(R.drawable.villagerrole));
        } else if (prole.equals("kn")) {
            playerrole.setText("Villager");
            seeredroleimg.setImageDrawable(getDrawable(R.drawable.villagerrole));
        }

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (startPlayersArray.index+1<startPlayersArray.theData.size()){
                    startPlayersArray.index++;
                    Intent intent = new Intent(seerAction.this, playerPrompt.class);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(seerAction.this, finishTurn.class);
                    startActivity(intent);
                }
            }
        });

    }
    @Override
    public void onBackPressed() {

    }
}
