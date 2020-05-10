package com.example.werewolf.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.werewolf.R;
import com.example.werewolf.model.Players;
import com.example.werewolf.model.PlayersArray;

import java.util.ArrayList;

public class selectRoles extends AppCompatActivity {

    Button btn_plusww, btn_plusvg, btn_plussr, btn_plusht, btn_pluskn, btn_minww, btn_minvg, btn_minsr, btn_minht, btn_minkn, btn_confirm_roles;
    Toolbar toolbar;
    TextView wwcounter, vgcounter, srcounter, htcounter, kncounter;
    static int ww;
    static int vg;
    static int sr;
    static int ht;
    static int kn;
    ArrayList<Players> thePlayers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_roles);

        thePlayers = PlayersArray.theData;

        btn_plusww = findViewById(R.id.btn_plusww);
        btn_plusvg = findViewById(R.id.btn_plusvg);
        btn_plussr = findViewById(R.id.btn_plusseer);
        btn_plusht = findViewById(R.id.btn_plushunter);
        btn_pluskn = findViewById(R.id.btn_plusknight);

        btn_minww = findViewById(R.id.btn_minww);
        btn_minvg = findViewById(R.id.btn_minvg);
        btn_minsr = findViewById(R.id.btn_minseer);
        btn_minht = findViewById(R.id.btn_minhunter);
        btn_minkn = findViewById(R.id.btn_minknight);

        btn_confirm_roles = findViewById(R.id.btn_reveal);

        wwcounter = findViewById(R.id.wwcounter);
        vgcounter = findViewById(R.id.vgcounter);
        htcounter = findViewById(R.id.htcounter);
        srcounter = findViewById(R.id.srcounter);
        kncounter = findViewById(R.id.kncounter);

        toolbar = findViewById(R.id.rolesToolbar);

        if (thePlayers.size() == 3) {
            ww = 1;
            vg = 1;
            sr = 1;
            setCounter();
        } else if (thePlayers.size() == 4) {
            ww = 1;
            vg = 1;
            sr = 1;
            kn = 1;
            setCounter();
        } else if (thePlayers.size() == 5) {
            ww = 2;
            vg = 1;
            sr = 1;
            kn = 1;
            setCounter();
        } else if (thePlayers.size() == 6) {
            ww = 2;
            vg = 1;
            sr = 1;
            kn = 1;
            ht = 1;
            setCounter();
        } else if (thePlayers.size() == 7) {
            ww = 2;
            vg = 2;
            sr = 1;
            kn = 1;
            ht = 1;
            setCounter();
        } else if (thePlayers.size() == 8) {
            ww = 2;
            vg = 3;
            sr = 1;
            kn = 1;
            ht = 1;
            setCounter();
        }

        btn_plusww.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (thePlayers.size() == ww + vg + sr + kn + ht) {
                    Toast.makeText(selectRoles.this, "Role exceeds the number of player!", Toast.LENGTH_SHORT).show();
                } else if (ww>=4){
                    Toast.makeText(selectRoles.this, "Maximum 4 Werewolves!", Toast.LENGTH_SHORT).show();
                }
                else {
                    ww++;
                    setCounter();
                }
            }
        });
        btn_plussr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (thePlayers.size() == ww + vg + sr + kn + ht) {
                    Toast.makeText(selectRoles.this, "Role exceeds the number of player!", Toast.LENGTH_SHORT).show();
                } else {
                    sr++;
                    setCounter();
                }
            }
        });
        btn_plusvg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (thePlayers.size() == ww + vg + sr + kn + ht) {
                    Toast.makeText(selectRoles.this, "Role exceeds the number of player!", Toast.LENGTH_SHORT).show();
                } else {
                    vg++;
                    setCounter();
                }
            }
        });
        btn_plusht.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (thePlayers.size() == ww + vg + sr + kn + ht) {
                    Toast.makeText(selectRoles.this, "Role exceeds the number of player!", Toast.LENGTH_SHORT).show();
                } else {
                    ht++;
                    setCounter();
                }
            }
        });
        btn_pluskn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (thePlayers.size() == ww + vg + sr + kn + ht) {
                    Toast.makeText(selectRoles.this, "Role exceeds the number of player!", Toast.LENGTH_SHORT).show();
                } else {
                    kn++;
                    setCounter();
                }
            }
        });
        btn_minht.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ht==0) {
                } else {
                    ht--;
                    setCounter();
                }
            }
        });
        btn_minww.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ww==1) {
                    Toast.makeText(selectRoles.this, "Minimum 1 Werewolf is required", Toast.LENGTH_SHORT).show();
                } else {
                    ww--;
                    setCounter();
                }
            }
        });
        btn_minkn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (kn==0) {
                } else {
                    kn--;
                    setCounter();
                }
            }
        });
        btn_minvg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (vg==0) {
                } else {
                    vg--;
                    setCounter();
                }
            }
        });
        btn_minsr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sr==1) {
                    Toast.makeText(selectRoles.this, "Minimum 1 Seer is required", Toast.LENGTH_SHORT).show();
                } else {
                    sr--;
                    setCounter();
                }
            }
        });

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(selectRoles.this, playersPage.class);
                startActivity(intent);
            }
        });

        btn_confirm_roles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (thePlayers.size() == ww + vg + sr + kn + ht){
                    Intent intent = new Intent(selectRoles.this, gameStart.class);
                    startActivity(intent);
                }
            }
        });
    }

    public void setCounter() {
        wwcounter.setText(String.valueOf(ww));
        vgcounter.setText(String.valueOf(vg));
        htcounter.setText(String.valueOf(ht));
        kncounter.setText(String.valueOf(kn));
        srcounter.setText(String.valueOf(sr));
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(selectRoles.this, playersPage.class);
        startActivity(intent);
    }
}
