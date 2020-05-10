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

    Button ww, vg, ht, kn, sr;
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


        ww = findViewById(R.id.btn_ww);
        ww.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wwDialog();
            }
        });
        vg = findViewById(R.id.btn_vilager);
        vg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vgDialog();
            }
        });
        ht = findViewById(R.id.btn_hunter);
        ht.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                htDialog();
            }
        });
        kn = findViewById(R.id.btn_guard);
        kn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                knDialog();
            }
        });
        sr = findViewById(R.id.btn_seer);
        sr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                srDialog();
            }
        });
    }

    void wwDialog() {
        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.ww_dialog, null);
        AlertDialog alertDialog = new AlertDialog.Builder(this).setView(view).create();
        alertDialog.show();

    }

    void vgDialog() {
        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.vg_dialog, null);
        AlertDialog alertDialog = new AlertDialog.Builder(this).setView(view).create();
        alertDialog.show();

    }

    void srDialog() {
        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.sr_dialog, null);
        AlertDialog alertDialog = new AlertDialog.Builder(this).setView(view).create();
        alertDialog.show();

    }

    void knDialog() {
        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.kn_dialog, null);
        AlertDialog alertDialog = new AlertDialog.Builder(this).setView(view).create();
        alertDialog.show();

    }

    void htDialog() {
        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.ht_dialog, null);
        AlertDialog alertDialog = new AlertDialog.Builder(this).setView(view).create();
        alertDialog.show();

    }
}
