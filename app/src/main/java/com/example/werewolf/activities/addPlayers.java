package com.example.werewolf.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
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
import com.google.android.material.textfield.TextInputLayout;

public class addPlayers extends AppCompatActivity implements TextWatcher {

    private ImageView imageView;
    TextInputLayout iName;
    FloatingActionButton  fabImg, fabOk;
    String name;
    Uri img;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_players);

        iName = findViewById(R.id.til_player_name);
        fabImg = findViewById(R.id.fab_add_image);
        fabOk = findViewById(R.id.fab_confirm_add);
        imageView = findViewById(R.id.player_imgadd);
        fabImg = findViewById(R.id.fab_add_image);



        iName.getEditText().addTextChangedListener(this);

        toolbar = findViewById(R.id.playersToolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(addPlayers.this, playersPage.class);
                startActivity(intent);
            }
        });
        fabOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Players players = new Players(name, img);
                PlayersArray.theData.add(players);
                Intent intent = new Intent(addPlayers.this, playersPage.class);
                startActivity(intent);
            }
        });

        fabImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectImage(addPlayers.this);
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
    public void onBackPressed(){
        Intent intent = new Intent(addPlayers.this, playersPage.class);
        startActivity(intent);

//        Toast.makeText(MainActivity.this, "Press back again to exit.", Toast.LENGTH_SHORT).show();
    }
}
