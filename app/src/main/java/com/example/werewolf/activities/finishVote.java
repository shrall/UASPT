package com.example.werewolf.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.werewolf.R;
import com.example.werewolf.model.Players;
import com.example.werewolf.model.PlayersArray;
import com.example.werewolf.model.startPlayers;
import com.example.werewolf.model.startPlayersArray;

import java.util.Iterator;

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
    CardView CV;
    ImageView votedPlayerImg, bgimg;
    Button button;
    int dead = 0, most = 0, cancel = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish_vote);
        CV = findViewById(R.id.cardView2);
        bgimg = findViewById(R.id.player_imgadd1);
        votedPlayerImg = findViewById(R.id.player_imgprompt);
        votedPlayer = findViewById(R.id.tvplayername);
        guide1 = findViewById(R.id.tvguide1);
        guide1.setVisibility(View.INVISIBLE);
        guide2 = findViewById(R.id.tvguide2);
        button = findViewById(R.id.btn_reveal);

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
                cancel++;
            }
        }
        if (two == three || two == four || two == five | two == six || two == seven || two == eight) {
            if (two == most) {
                cancel++;
            }
        }
        if (three == four || three == five | three == six || three == seven || three == eight) {
            if (three == most) {
                cancel++;
            }
        }
        if (four == five | four == six || four == seven || four == eight) {
            if (four == most) {
                cancel++;
            }
        }
        if (five == six || five == seven || five == eight) {
            if (five == most) {
                cancel++;
            }
        }
        if (six == seven || six == eight) {
            if (six == most) {
                cancel++;
            }
        }
        if (seven == eight) {
            if (seven == most) {
                cancel++;
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


        if (cancel > 0) {
            guide2.setVisibility(View.INVISIBLE);
            votedPlayer.setVisibility(View.INVISIBLE);
            votedPlayerImg.setVisibility(View.INVISIBLE);
            guide1.setVisibility(View.VISIBLE);
            bgimg.setVisibility(View.INVISIBLE);
            CV.setVisibility(View.INVISIBLE);
            button.setText("Next");
            guide1.setText("Voting was tied. \n No one died.");
            guide2.setText("");
        } else {
            votedPlayerImg.setImageURI(startPlayersArray.theData.get(dead).getSimg());
            votedPlayer.setText(startPlayersArray.theData.get(dead).getSname());
            guide2.setText("Any last words?");
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
                    iter.remove();
                    break;
                }
            }
            Iterator<String> iter2 = startPlayersArray.werewolves.iterator();
            while (iter2.hasNext()) {
                String user = iter2.next();
                if (user.equals(startPlayersArray.theData.get(dead).getSname())) {
                    iter2.remove();
                }
            }
        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                most = 0;
                cancel = 0;
                dead = 0;
                one = 0;
                two = 0;
                three = 0;
                four = 0;
                five = 0;
                six = 0;
                seven = 0;
                eight = 0;
//                Toast.makeText(finishVote.this, ""+most+cancel+dead+one+two+three+four+five+six+seven+eight, Toast.LENGTH_SHORT).show();
                if (startPlayersArray.werewolves.size() == 0) {
                    Intent intent = new Intent(finishVote.this, villagerWin.class);
                    startActivity(intent);
                } else if (startPlayersArray.werewolves.size() > startPlayersArray.theData.size() - startPlayersArray.werewolves.size()) {
                    Intent intent = new Intent(finishVote.this, werewolfWin.class);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(finishVote.this, gameStart.class);
                    startActivity(intent);
                }
            }
        });


    }

    @Override
    public void onBackPressed() {

    }
}

