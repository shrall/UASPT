package com.example.werewolf.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.werewolf.R;
import com.example.werewolf.model.Players;
import com.example.werewolf.model.PlayersArray;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.Iterator;

public class deletePlayers extends AppCompatActivity implements TextWatcher {


    ArrayList<Players> thePlayers, s;
    static String EXTRA_PLAYERS = "extra";
    private Players p;
    private ImageView imageView;
    TextInputLayout iName;
    TextInputEditText tName;
    FloatingActionButton fabDel, fabImg, fabOk;
    String name, tempstring, temp, check;
    Uri img;
    Toolbar toolbar;
    int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_players);
        if (getIntent().getParcelableExtra(EXTRA_PLAYERS) != null) {
            p = getIntent().getParcelableExtra(EXTRA_PLAYERS);
        }


        iName = findViewById(R.id.til_player_name);
        fabDel = findViewById(R.id.fab_delete);
        fabImg = findViewById(R.id.fab_add_image);
        fabOk = findViewById(R.id.fab_confirm_add);
        imageView = findViewById(R.id.player_imgadd);
        fabImg = findViewById(R.id.fab_add_image);
        tName = findViewById(R.id.tiet_player);
        thePlayers = PlayersArray.theData;


        iName.getEditText().addTextChangedListener(this);
        check = p.getPname();
        s = PlayersArray.theData;
        tName.setText(p.getPname());
        imageView.setImageURI(p.getPimg());
        tempstring = p.getPname();
        img = p.getPimg();
        toolbar = findViewById(R.id.playersToolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(deletePlayers.this, playersPage.class);
                startActivity(intent);
            }
        });

        fabOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter = 0;
                if (s.size() == 0) {
                    if (name == null) {
                        Toast.makeText(deletePlayers.this, "Name cannot be empty!", Toast.LENGTH_SHORT).show();
                    } else {
                        Players players = new Players(name, img);
                        PlayersArray.theData.add(players);
                        Intent intent = new Intent(deletePlayers.this, playersPage.class);
                        startActivity(intent);
                    }
                } else {
                    for (int i = 0; i < s.size(); i++) {
                        temp = s.get(i).getPname();
                        if (!temp.equals(name) || check.equals(name)) {
                            counter++;
                            if (counter == s.size()) {
                                Iterator<Players> iter = PlayersArray.theData.iterator();
                                while (iter.hasNext()) {
                                    Players user = iter.next();
                                    if (user.pname.equals(tempstring)) {
                                        iter.remove();

                                    }
                                }
                                if (name == null) {
                                    Toast.makeText(deletePlayers.this, "Name cannot be empty!", Toast.LENGTH_SHORT).show();
                                } else {
                                    Players players = new Players(name, img);
                                    PlayersArray.theData.add(players);
                                    Intent intent = new Intent(deletePlayers.this, playersPage.class);
                                    startActivity(intent);
                                }

                            }
                        } else {
                            Toast.makeText(deletePlayers.this, "There's already a player with the same name!", Toast.LENGTH_SHORT).show();
                            break;
                        }
                    }
                }


            }
        });

        fabDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Iterator<Players> iter = PlayersArray.theData.iterator();
                while (iter.hasNext()) {
                    Players user = iter.next();
                    if (user.pname.equals(tempstring)) {
                        iter.remove();

                    }
                }
                Intent intent = new Intent(deletePlayers.this, playersPage.class);
                startActivity(intent);
            }
        });

        fabImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectImage(deletePlayers.this);
            }
        });
    }

    private void selectImage(Context context) {
        final CharSequence[] options = {"Choose from Gallery", "Cancel"};

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Choose your profile picture");

        builder.setItems(options, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int item) {

                if (options[item].equals("Choose from Gallery")) {
                    Intent pickPhoto = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(pickPhoto, 0);//one can be replaced with any action code

                } else if (options[item].equals("Cancel")) {
                    dialog.dismiss();
                }
            }
        });
        builder.show();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != RESULT_CANCELED) {
            switch (requestCode) {
                case 0:

                    if (resultCode == RESULT_OK && data != null) {
                        Uri selectedImage = data.getData();
                        img = selectedImage;
                        imageView.setImageURI(img);
                    }
                    break;
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_image_capture, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        name = iName.getEditText().getText().toString().trim();
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(deletePlayers.this, playersPage.class);
        startActivity(intent);

//        Toast.makeText(MainActivity.this, "Press back again to exit.", Toast.LENGTH_SHORT).show();
    }
}
