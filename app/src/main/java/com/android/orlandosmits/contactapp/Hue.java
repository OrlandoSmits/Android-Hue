package com.android.orlandosmits.contactapp;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;

import com.android.volley.Request;

import java.io.Serializable;

/**
 * Created by Orlando Smits on 29-10-2016.
 */

public class Hue implements Parcelable {

    // Tag for logging-purposes
    private String TAG = this.getClass().getName();

    // Fields for an individual Hue
    public String id;
    public String name;

    public boolean on;

    public int brightness;
    public int hue;
    public int saturation;

    public String effect;



    private VolleyHandler volleyHandler;

    public Hue(Context context) {

        volleyHandler = new VolleyHandler(context);

        this.id = id;
        this.name = name;
        this.on = on;
        this.brightness = brightness;
        this.hue = hue;
        this.saturation = saturation;
        this.effect = effect;

    }

    protected Hue(Parcel in) {
        TAG = in.readString();
        id = in.readString();
        name = in.readString();
        on = in.readByte() != 0;
        brightness = in.readInt();
        hue = in.readInt();
        saturation = in.readInt();
        effect = in.readString();
    }

    public static final Creator<Hue> CREATOR = new Creator<Hue>() {
        @Override
        public Hue createFromParcel(Parcel in) {
            return new Hue(in);
        }

        @Override
        public Hue[] newArray(int size) {
            return new Hue[size];
        }
    };

    // Returns the id of an individual Hue
    public String getId() {
        return id;
    }

    // Returns the name of an individual Hue
    public String getName() {
        return name;
    }

    // Returns the on-state of an individual Hue
    public boolean getActiveState() {
        return on;
    }

    // Returns the brightness-state of an individual Hue
    public int getBrightness() {
        return brightness;
    }

    // Returns the hue-state of an individual Hue
    public int getHue() {
        return hue;
    }

    // Returns the saturation-state of an individual Hue
    public int getSaturation() {
        return hue;
    }

    // Returns the effect-state of an individual Hue
    public String getEffect() {
        return effect;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(TAG);
        dest.writeString(id);
        dest.writeString(name);
        dest.writeByte((byte) (on ? 1 : 0));
        dest.writeInt(brightness);
        dest.writeInt(hue);
        dest.writeInt(saturation);
        dest.writeString(effect);
    }
}
