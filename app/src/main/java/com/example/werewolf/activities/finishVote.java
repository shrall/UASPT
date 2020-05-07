package com.example.werewolf.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.werewolf.R;

import static com.example.werewolf.model.startPlayersArray.eight;
import static com.example.werewolf.model.startPlayersArray.five;
import static com.example.werewolf.model.startPlayersArray.four;
import static com.example.werewolf.model.startPlayersArray.one;
import static com.example.werewolf.model.startPlayersArray.seven;
import static com.example.werewolf.model.startPlayersArray.six;
import static com.example.werewolf.model.startPlayersArray.three;
import static com.example.werewolf.model.startPlayersArray.two;

public class finishVote extends AppCompatActivity {

    TextView votedPlayer, guide1, guide2;
    ImageView votedPlayerImg;
    Button button;
    int dead = 0, most = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish_vote);
        votedPlayerImg = findViewById(R.id.player_imgprompt);
        votedPlayer = findViewById(R.id.tvplayername);
        guide1 = findViewById(R.id.tvguide1);
        guide2 = findViewById(R.id.tvguide2);
        button = findViewById(R.id.btn_reveal);

        if (one > two && one > three && one > four && one > five && one > six && one > seven && one > eight) {
            dead = 0;
        } else if (two > one && two > three && two > four && two > five && two > six && two > seven && two > eight) {
            dead = 1;
        } else if (three > two && three > one && three > four && three > five && three > six && three > seven && three > eight) {
            dead = 2;
        } else if (four > two && four > three && four > one && four > five && four > six && four > seven && four > eight) {
            dead = 3;
        } else if (five > two && five > three && five > four && five > one && five > six && five > seven && five > eight) {
            dead = 4;
        } else if (six > two && six > three && six > four && six > five && six > one && six > seven && six > eight) {
            dead = 5;
        } else if (seven > two && seven > three && seven > four && seven > five && seven > six && seven > one && seven > eight) {
            dead = 6;
        } else if (eight > two && eight > three && eight > four && eight > five && eight > six && eight > seven && eight > one) {
            dead = 7;
        }


    }
}
