package com.android.orlandosmits.contactapp;

import android.graphics.Bitmap;

/**
 * Created by Orlando Smits on 6-9-2016.
 */
public class User {
    public String mGender;
    public String mFirstName;
    public String mLastName;
    public String mEmail;
    public String mImage;

    public String getmGender() {
        return mGender;
    }

    public String getmFirstName() {

        String cap = mFirstName.substring(0, 1).toUpperCase() + mFirstName.substring(1);
        return cap;
    }

    public String getmLastName() {
        String cap = mLastName.substring(0, 1).toUpperCase() + mLastName.substring(1);
        return cap;
    }

    public String getFullName() {
        return this.getmFirstName() + " " + this.getmLastName();
    }

    public String getmEmail() {
        return mEmail;
    }

    public String getmImage() {
        return mImage;
    }
}
