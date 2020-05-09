package com.example.werewolf.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;


import com.example.werewolf.R;

public class rolesPage extends AppCompatActivity {

    Button ww;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roles_page);

        //back Toolbar Button
        toolbar = findViewById(R.id.rolesToolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(rolesPage.this, mainmenu.class);
                startActivity(intent);
            }
        });


//        ww = findViewById(R.id.btn_ww);
//        ww.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                wwDialog();
//            }
//        });
    }

//    void wwDialog(){
//        LayoutInflater inflater = LayoutInflater.from(this);
//        View view = inflater.inflate(R.layout.ww_dialog, null);
//        AlertDialog alertDialog = new AlertDialog.Builder(this).setView(view).create();
//        alertDialog.show();
//
//    }
}
