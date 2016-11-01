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

    VolleyHandler volleyHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        volleyHandler = new VolleyHandler(getApplicationContext());

        Bundle extras = getIntent().getExtras();
        final Hue hue = (Hue) extras.get("Hue");
        final String id = hue.id;
        Boolean on = hue.on;
        Integer bri = hue.brightness;
        Log.i("brightness", bri.toString());


        ToggleButton tBtn = (ToggleButton) findViewById(R.id.hueDetailToggle);
        tBtn.setChecked(on);

        SeekBar briSeekbar = (SeekBar) findViewById(R.id.hueBriSeekbar);
        briSeekbar.setProgress(bri);

        Button button = (Button) findViewById(R.id.hueDetailOff);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                volleyHandler.turnOff("http://192.168.1.179/api/80b8a9620291a47fec92fa34484f5b/lights/" + id + "/state/");
            }
        });


    }
}
