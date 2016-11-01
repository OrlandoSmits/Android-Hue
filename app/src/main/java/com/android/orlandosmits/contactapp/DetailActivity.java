package com.android.orlandosmits.contactapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

       Bundle extras = getIntent().getExtras();
        Hue hue = (Hue) extras.get("Hue");
        Boolean on = hue.on;
        Integer bri = hue.brightness;
        Log.i("brightness", bri.toString());


        String lastname = extras.getString("UserLastName");
        String email = extras.getString("UserEmail");
        String gender = extras.getString("UserGender");
        String image = extras.getString("UserImage");

        ToggleButton tBtn = (ToggleButton) findViewById(R.id.hueDetailToggle);
        tBtn.setChecked(on);

        SeekBar briSeekbar = (SeekBar) findViewById(R.id.hueBriSeekbar);
        briSeekbar.setProgress(bri);


    }
}
