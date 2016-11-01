package com.android.orlandosmits.contactapp;

import com.android.volley.Request;

import java.io.Serializable;

/**
 * Created by Orlando Smits on 29-10-2016.
 */

public class Hue implements Serializable {
    public String id;
    public boolean on;
    public int brightness;
    public int heu;
    public String effect;
    public String name;

//    private VolleyHandler vh;
//
//    public void turnOn(String url) {
//        vh.doRequest(url, "{\"on\":true}", Request.Method.PUT);
//        on = true;
//    }
//
//    public void turnOff(String url) {
//        vh.doRequest(url, "{\"on\":false}", Request.Method.PUT);
//        on = false;
//    }
}
