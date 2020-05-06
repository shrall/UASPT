package com.example.werewolf.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.werewolf.R;
import com.example.werewolf.model.Players;
import com.example.werewolf.model.PlayersArray;
import com.example.werewolf.model.startPlayers;
import com.example.werewolf.model.startPlayersArray;

import java.util.ArrayList;
import java.util.Iterator;

public class finishTurn extends AppCompatActivity {
    Button next;
    int one = 0, two = 0, three = 0, four = 0, five = 0, six = 0, seven = 0, eight = 0, dead = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish_turn);
        next = findViewById(R.id.btn_next);

        if (startPlayersArray.guardedPlayer.size() != 0) {
            for (int i = 0; i < startPlayersArray.guardedPlayer.size(); i++) {
                Iterator<String> iter = startPlayersArray.killedPlayer.iterator();
                while (iter.hasNext()) {
                    String user = iter.next();
                    if (user.equals(startPlayersArray.guardedPlayer.get(i))) {
                        iter.remove();
                    }
                }
                Iterator<String> iter1 = startPlayersArray.huntedPlayer.iterator();
                while (iter1.hasNext()) {
                    String user = iter1.next();
                    if (user.equals(startPlayersArray.guardedPlayer.get(i))) {
                        iter1.remove();
                    }
                }

            }
        }
        for (int i = 0; i < startPlayersArray.killedPlayer.size(); i++) {
            for (int j = 0; j < startPlayersArray.theData.size(); j++) {
                if (startPlayersArray.killedPlayer.get(i).equals(startPlayersArray.theData.get(j).getSname())) {
                    if (j == 0) {
                        one++;
                    } else if (j == 1) {
                        two++;
                    } else if (j == 2) {
                        three++;
                    } else if (j == 3) {
                        four++;
                    } else if (j == 4) {
                        five++;
                    } else if (j == 5) {
                        six++;
                    } else if (j == 6) {
                        seven++;
                    } else if (j == 7) {
                        eight++;
                    }
                }
            }
        }
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

        if (startPlayersArray.killedPlayer.size() != 0) {
                Iterator<startPlayers> iter = startPlayersArray.theData.iterator();
                while (iter.hasNext()) {
                    startPlayers user = iter.next();
                    if (user.equals(startPlayersArray.theData.get(dead))) {
                        startPlayersArray.killed.add(user.sname);
                        iter.remove();
                        break;
                    }
                }

        }
        if (startPlayersArray.huntedPlayer.size() != 0) {
            for (int i = 0; i < startPlayersArray.huntedPlayer.size(); i++) {
                Iterator<startPlayers> iter = startPlayersArray.theData.iterator();
                while (iter.hasNext()) {
                    startPlayers user = iter.next();
                    if (user.sname.equals(startPlayersArray.huntedPlayer.get(i))) {
                        startPlayersArray.killed.add(user.sname);
                        iter.remove();
                    }
                }
            }
        }
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                one = 0; two = 0; three = 0; four = 0; five = 0; six = 0; seven = 0; eight = 0; dead = 0;
                startPlayersArray.killedPlayer.clear();
                startPlayersArray.guardedPlayer.clear();
                startPlayersArray.huntedPlayer.clear();

//                Toast.makeText(finishTurn.this, String.valueOf(startPlayersArray.theData.size())+ one + two + three
//                        +four+five+six+seven+eight+ startPlayersArray.killed.size()+ startPlayersArray.killedPlayer.size()+
//                        startPlayersArray.huntedPlayer.size()+ startPlayersArray.guardedPlayer.size(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(finishTurn.this, killedPrompt.class);
                startActivity(intent);
            }
        });
    }
}
