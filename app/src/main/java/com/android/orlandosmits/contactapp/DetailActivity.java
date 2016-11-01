package com.android.orlandosmits.contactapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

       Bundle extras = getIntent().getExtras();
        Hue hue = (Hue) extras.get("Hue");

        String lastname = extras.getString("UserLastName");
        String email = extras.getString("UserEmail");
        String gender = extras.getString("UserGender");
        String image = extras.getString("UserImage");

        TextView tvName = (TextView) findViewById(R.id.tvPersonName);
        tvName.setText(hue.id);

        TextView tvEmail = (TextView) findViewById(R.id.tvPersonEmail);
        tvEmail.setText(email);

        ImageView thumbnail = (ImageView) findViewById(R.id.profilepicture);
        Picasso.with(getApplicationContext()).load(image).into(thumbnail);

    }
}
