package com.android.orlandosmits.contactapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
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
        final Integer bri = hue.brightness;
        Log.i("brightness", bri.toString());


        ToggleButton tBtn = (ToggleButton) findViewById(R.id.hueDetailToggle);
        tBtn.setChecked(on);
        tBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    volleyHandler.turnOn("http://192.168.1.179/api/80b8a9620291a47fec92fa34484f5b/lights/" + id + "/state/");
                } else {
                    volleyHandler.turnOff("http://192.168.1.179/api/80b8a9620291a47fec92fa34484f5b/lights/" + id + "/state/");

                }
            }
        });

        SeekBar briSeekbar = (SeekBar) findViewById(R.id.hueBriSeekbar);
        briSeekbar.setProgress(bri);

        briSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                int progress = seekBar.getProgress();
                volleyHandler.setBrightness("http://192.168.1.179/api/80b8a9620291a47fec92fa34484f5b/lights/" + id + "/state/", progress );
            }
        });

        Button button = (Button) findViewById(R.id.hueDetailOff);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                volleyHandler.turnOff("http://192.168.1.179/api/80b8a9620291a47fec92fa34484f5b/lights/" + id + "/state/");
            }
        });


    }
}
