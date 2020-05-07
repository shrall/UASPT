package com.example.werewolf.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.werewolf.R;

import java.util.concurrent.TimeUnit;

public class gameDiscussion extends AppCompatActivity {
    TextView text1;
    Button button;

    private static final String FORMAT = "%02d:%02d";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_discussion);
        text1 = findViewById(R.id.tvguide3);
        button = findViewById(R.id.btn_next);

        new CountDownTimer(300000, 1000) { // adjust the milli seconds here

            public void onTick(long millisUntilFinished) {

                text1.setText("" + String.format(FORMAT, TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millisUntilFinished)), TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))));
            }

            public void onFinish() {
                Intent intent = new Intent(gameDiscussion.this, gameVoting.class);
                startActivity(intent);
            }
        }.start();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(gameDiscussion.this, gameStart.class);
                startActivity(intent);
            }
        });
    }
}
