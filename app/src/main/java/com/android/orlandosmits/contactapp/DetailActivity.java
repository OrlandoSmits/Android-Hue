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
    String url = "http://192.168.1.179/api/";
    String username = "80b8a9620291a47fec92fa34484f5b";
    String putUrl = url + username + "/lights/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        volleyHandler = new VolleyHandler(getApplicationContext());

        Bundle extras = getIntent().getExtras();
        final Hue hue = (Hue) extras.get("Hue");
        final String id = hue.id;
        Boolean on = hue.on;
        final int bri = hue.brightness;
        final int sat = hue.saturation;
        final int actualHue = hue.hue;
        Log.i("brightness", String.valueOf(bri));


        ToggleButton tBtn = (ToggleButton) findViewById(R.id.hueDetailToggle);
        tBtn.setChecked(on);
        tBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    volleyHandler.turnOn(putUrl + id + "/state/");
                } else {
                    volleyHandler.turnOff(putUrl + id + "/state/");

                }
            }
        });

        SeekBar briSeekBar = (SeekBar) findViewById(R.id.brightnessSeekBar);
        briSeekBar.setProgress(bri);

        briSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
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

        SeekBar satSeekBar = (SeekBar) findViewById(R.id.saturationSeekBar);
        satSeekBar.setProgress(sat);

        satSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                int progress = seekBar.getProgress();
                volleyHandler.setSaturation("http://192.168.1.179/api/80b8a9620291a47fec92fa34484f5b/lights/" + id + "/state/", progress );
            }
        });

        SeekBar hueSeekBar = (SeekBar) findViewById(R.id.hueSeekBar);
        hueSeekBar.setProgress(actualHue);

        hueSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                int progress = seekBar.getProgress();
                volleyHandler.setHue("http://192.168.1.179/api/80b8a9620291a47fec92fa34484f5b/lights/" + id + "/state/", progress);
            }
        });



    }
}
