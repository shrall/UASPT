package com.example.werewolf.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.werewolf.R;
import com.example.werewolf.model.startPlayers;
import com.example.werewolf.model.startPlayersArray;

public class playerPrompt extends AppCompatActivity {

    TextView playerName;
    ImageView playerImage;
    String playername, playerrole;
    Uri playerimg;
    startPlayers p;
    Button btreveal;
    Integer index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_prompt);
        index = startPlayersArray.index;
        p = startPlayersArray.theData.get(index);
        btreveal = findViewById(R.id.btn_reveal);

        playerName = findViewById(R.id.tvplayername);
        playerImage = findViewById(R.id.player_imgprompt);

        playerName.setText(p.getSname());
        playerImage.setImageURI(p.getSimg());

        btreveal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(playerPrompt.this, playerTurn.class);
                startActivity(intent);
            }
        });



    }
}
