package com.android.orlandosmits.contactapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.ToggleButton;


public class DetailActivity extends AppCompatActivity {

    // Volleyhandler for handling our Requests
    VolleyHandler volleyHandler;

    // Basic string elements
    String url = "http://192.168.1.179/api/";
    String username = "80b8a9620291a47fec92fa34484f5b";
    String putUrl = url + username + "/lights/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // Instantiate a VolleyHandler
        volleyHandler = new VolleyHandler(getApplicationContext());

        // Get the Hue object from the MainActivity
        Bundle extras = getIntent().getExtras();
        final Hue hue = (Hue) extras.get("Hue");

        // Create elements for usage in our Requests
        // Get the Hue ID
        final String id = hue.id;

        // Get the On state from the Hue
        Boolean on = hue.on;

        // Get the brightness from the hue
        final int bri = hue.brightness;

        // Get the saturation from the hue
        final int sat = hue.saturation;

        // Get the Hue from the hue
        final int actualHue = hue.hue;

        // Add togglebutton to this class
        ToggleButton tBtn = (ToggleButton) findViewById(R.id.hueDetailToggle);

        // Set checked state to the On state from the Hue
        tBtn.setChecked(on);

        // Give the user the option to turn the Hue on or off
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

        // Add Brightness SeekBar to this class
        SeekBar briSeekBar = (SeekBar) findViewById(R.id.brightnessSeekBar);

        // Set the progress to the brightness level from the Hue
        briSeekBar.setProgress(bri);

        // Give the user the option to set the Brightness of the Hue
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
                volleyHandler.setBrightness(putUrl + id + "/state/", progress );
            }
        });

        // Add Saturation Seekbar to this class
        SeekBar satSeekBar = (SeekBar) findViewById(R.id.saturationSeekBar);

        // Set the progress to the Saturation from the Hue
        satSeekBar.setProgress(sat);

        // Give the user the option to set the Saturation of the Hue
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
                volleyHandler.setSaturation(putUrl + id + "/state/", progress );
            }
        });

        // Add Hue SeekBar to this class
        SeekBar hueSeekBar = (SeekBar) findViewById(R.id.hueSeekBar);

        // Set the progress to the Hue from the Hue
        hueSeekBar.setProgress(actualHue);

        // Give the user the option to set the Hue of the Hue
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
                volleyHandler.setHue(putUrl + id + "/state/", progress);
            }
        });



    }
}
