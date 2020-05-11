package com.example.werewolf.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.werewolf.R;

public class mainmenu extends AppCompatActivity {

    TextView textView;
    Button startBtn, rolesBtn, settingsBtn, exitBtn;
    public static MediaPlayer ring;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmenu);
        ring = MediaPlayer.create(mainmenu.this,R.raw.mainmenubgm);
        ring.start();
        ring.setLooping(true);

        textView = findViewById(R.id.title);
        textView.setShadowLayer(1, 1, 2, Color.rgb(134, 133,239));

        startBtn = findViewById(R.id.startbtn);
        rolesBtn = findViewById(R.id.rolesbtn);
        settingsBtn = findViewById(R.id.settingbtn);
        exitBtn = findViewById(R.id.exitbtn);

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mainmenu.this, playersPage.class);
                startActivity(intent);
            }
        });
        rolesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mainmenu.this, rolesPage.class);
                startActivity(intent);
            }
        });
        settingsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mainmenu.this, settingsPage.class);
                startActivity(intent);
            }
        });
        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ring.stop();
                ring.setLooping(false);
                Intent a = new Intent(Intent.ACTION_MAIN);
                a.addCategory(Intent.CATEGORY_HOME);
                a.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(a);
                finishAffinity();
                finish();
            }
        });
    }
}
