package com.example.werewolf.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.werewolf.R;
import com.example.werewolf.model.startPlayersArray;

import java.util.concurrent.TimeUnit;

public class gameDiscussion extends AppCompatActivity {
    TextView text1;
    Button button;
    CountDownTimer cdTimer;

    private static final String FORMAT = "%02d:%02d";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_discussion);
        text1 = findViewById(R.id.tvguide3);
        button = findViewById(R.id.btn_next);

        cdTimer = new CountDownTimer(30000, 1000) { // adjust the milli seconds here

            public void onTick(long millisUntilFinished) {

                text1.setText(""+String.format(FORMAT,
                        TimeUnit.MILLISECONDS.toMinutes( millisUntilFinished),
                        TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))));
            }

            public void onFinish() {
                Intent intent = new Intent(gameDiscussion.this, gameVoting.class);
                startPlayersArray.index = 0;
                startActivity(intent);
                cdTimer.cancel();
                finish();
            }
        }.start();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(gameDiscussion.this, gameVoting.class);
                startPlayersArray.index = 0;
                startActivity(intent);
                cdTimer.cancel();
                finish();
            }
        });
    }
    @Override
    public void onBackPressed() {

    }
}
