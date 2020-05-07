package com.example.werewolf.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.werewolf.R;
import com.example.werewolf.model.startPlayersArray;

public class killedPrompt extends AppCompatActivity {

    TextView names;
    String name;
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_killed_prompt);
        names = findViewById(R.id.tvguide3);
        next = findViewById(R.id.btn_next);
        name = "No one died!";

        for (int i = 0; i < startPlayersArray.killed.size(); i++) {
            if (i == 0) {
                name = startPlayersArray.killed.get(i);
            } else {
                name += "\n" + startPlayersArray.killed.get(i);
            }
        }
        names.setText(name);
        startPlayersArray.killed.clear();

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(killedPrompt.this, gameDiscussion.class);
                startActivity(intent);
            }
        });
    }
}
