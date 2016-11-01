package com.android.orlandosmits.contactapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.github.tbouron.shakedetector.library.ShakeDetector;


public class DetailActivity extends AppCompatActivity {

    // Volleyhandler for handling our Requests
    VolleyHandler volleyHandler;
    ShakeDetector shakeDetector;

    String url = "http://145.48.205.33/api/";
    String username = "iYrmsQq1wu5FxF9CPqpJCnm1GpPVylKBWDUsNDhB";

    // Basic string elements
//    String url = "http://192.168.1.179/api/";
//    String username = "80b8a9620291a47fec92fa34484f5b";
    String putUrl = url + username + "/lights/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ShakeDetector.create(this, new ShakeDetector.OnShakeListener() {
            @Override
            public void OnShake() {
                Toast.makeText(getApplicationContext(), "Device Shaken!", Toast.LENGTH_SHORT).show();
            }
        });

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

        // Add ToggleButton to this class
        // Allows the user to turn a hue-light on/off
        ToggleButton huePowerBtn = (ToggleButton) findViewById(R.id.huePowerSwitch);

        // Set checked state to the On state from the Hue
        huePowerBtn.setChecked(on);

        // Give the user the option to turn the Hue on or off
        huePowerBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    volleyHandler.turnOn(putUrl + id + "/state/");
                } else {
                    volleyHandler.turnOff(putUrl + id + "/state/");

                }
            }
        });

        // Add ToggleButton to this class
        // Allows the user to turn an effect of a hue-light on/off
        ToggleButton hueEffectBtn = (ToggleButton) findViewById(R.id.hueColorLoopSwitch);

        hueEffectBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    volleyHandler.setEffect(putUrl + id + "/state/", true);
                } else {
                    volleyHandler.setEffect(putUrl + id + "/state/", false);
                }
            }
        });

        // Add ToggleButton to this class
        // Allows the user to turn an effect of a hue-light on/off
        ToggleButton hueAlertBtn = (ToggleButton) findViewById(R.id.hueAlertSwitch);

        hueAlertBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    volleyHandler.setAlert(putUrl + id + "/state/", true);
                } else {
                    volleyHandler.setAlert(putUrl + id + "/state/", false);
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
