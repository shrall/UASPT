package com.example.werewolf.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
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

import static com.example.werewolf.model.startPlayersArray.eight;
import static com.example.werewolf.model.startPlayersArray.five;
import static com.example.werewolf.model.startPlayersArray.four;
import static com.example.werewolf.model.startPlayersArray.one;
import static com.example.werewolf.model.startPlayersArray.seven;
import static com.example.werewolf.model.startPlayersArray.six;
import static com.example.werewolf.model.startPlayersArray.three;
import static com.example.werewolf.model.startPlayersArray.two;

public class finishTurn extends AppCompatActivity {
    Button next;
    int one = 0, two = 0, three = 0, four = 0, five = 0, six = 0, seven = 0, eight = 0, dead = 0, most = 0, cancel = 0;
    public static MediaPlayer daystart,daybgm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish_turn);
        gameStart.nightbgm.stop();
        gameStart.nightbgm.setLooping(false);
        daystart = MediaPlayer.create(finishTurn.this,R.raw.daystart);
        daybgm = MediaPlayer.create(finishTurn.this,R.raw.daybgm);
        daybgm.start();
        daybgm.setLooping(true);
        daystart.start();
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

        if (one > most) {
            most = one;
            if (two > most) {
                most = two;
                if (three > most) {
                    most = three;
                    if (four > most) {
                        most = four;
                        if (five > most) {
                            most = five;
                            if (six > most) {
                                most = six;
                                if (seven > most) {
                                    most = seven;
                                    if (eight > most) {
                                        most = eight;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } else if (two > most) {
            most = two;
            if (three > most) {
                most = three;
                if (four > most) {
                    most = four;
                    if (five > most) {
                        most = five;
                        if (six > most) {
                            most = six;
                            if (seven > most) {
                                most = seven;
                                if (eight > most) {
                                    most = eight;
                                }
                            }
                        }
                    }
                }
            }
        } else if (three > most) {
            most = three;
            if (four > most) {
                most = four;
                if (five > most) {
                    most = five;
                    if (six > most) {
                        most = six;
                        if (seven > most) {
                            most = seven;
                            if (eight > most) {
                                most = eight;
                            }
                        }
                    }
                }
            }
        } else if (four > most) {
            most = four;
            if (five > most) {
                most = five;
                if (six > most) {
                    most = six;
                    if (seven > most) {
                        most = seven;
                        if (eight > most) {
                            most = eight;
                        }
                    }
                }
            }
        } else if (five > most) {
            most = five;
            if (six > most) {
                most = six;
                if (seven > most) {
                    most = seven;
                    if (eight > most) {
                        most = eight;
                    }
                }
            }
        } else if (six > most) {
            most = six;
            if (seven > most) {
                most = seven;
                if (eight > most) {
                    most = eight;
                }
            }
        } else if (seven > most) {
            most = seven;
            if (eight > most) {
                most = eight;
            }
        } else if (eight > most) {
            most = eight;
        }

        if (one == two || one == three || one == four || one == five | one == six || one == seven || one == eight) {
            if (one == most) {
                dead = 0;
            }
        }
        if (two == three || two == four || two == five | two == six || two == seven || two == eight) {
            if (two == most) {
                dead = 1;
            }
        }
        if (three == four || three == five | three == six || three == seven || three == eight) {
            if (three == most) {
                dead = 2;
            }
        }
        if (four == five | four == six || four == seven || four == eight) {
            if (four == most) {
                dead = 3;
            }
        }
        if (five == six || five == seven || five == eight) {
            if (five == most) {
                dead = 4;
            }
        }
        if (six == seven || six == eight) {
            if (six == most) {
                dead = 5;
            }
        }
        if (seven == eight) {
            if (seven == most) {
                dead = 6;
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
            Iterator<Players> iter1 = PlayersArray.theData.iterator();
            while (iter1.hasNext()) {
                Players user = iter1.next();
                if (user.pname.equals(startPlayersArray.theData.get(dead).getSname())) {
                    iter1.remove();
                    break;
                }
            }
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
                Iterator<Players> iter1 = PlayersArray.theData.iterator();
                while (iter1.hasNext()) {
                    Players user = iter1.next();
                    if (user.pname.equals(startPlayersArray.huntedPlayer.get(i))) {
                        iter1.remove();
                    }
                }
                Iterator<String> iter2 = startPlayersArray.werewolves.iterator();
                while (iter2.hasNext()) {
                    String user = iter2.next();
                    if (user.equals(startPlayersArray.huntedPlayer.get(i))) {
                        iter2.remove();
                    }
                }
            }
        }
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                one = 0;
                two = 0;
                three = 0;
                four = 0;
                five = 0;
                six = 0;
                seven = 0;
                eight = 0;
                dead = 0;
                startPlayersArray.killedPlayer.clear();
                startPlayersArray.guardedPlayer.clear();
                startPlayersArray.huntedPlayer.clear();
                Intent intent = new Intent(finishTurn.this, killedPrompt.class);
                startActivity(intent);
            }
        });
    }
    @Override
    public void onBackPressed() {

    }
}
