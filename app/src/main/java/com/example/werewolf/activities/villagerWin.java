package com.example.werewolf.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.werewolf.R;
import com.example.werewolf.model.PlayersArray;
import com.example.werewolf.model.startPlayersArray;

public class villagerWin extends AppCompatActivity {

    TextView congrats;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_villager_win);
        congrats = findViewById(R.id.tvguide);
        btn = findViewById(R.id.btn_reveal);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startPlayersArray.theData.clear();
                PlayersArray.theData.clear();
                startPlayersArray.index = 0;
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
