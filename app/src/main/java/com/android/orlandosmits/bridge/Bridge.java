package com.android.orlandosmits.bridge;

import java.io.Serializable;

/**
 * Created by Orlando Smits on 4-11-2016.
 */

public class Bridge implements Serializable {

    // Tag for logging-purposes
    private String TAG = this.getClass().getName();

    // Fields for individual Brige
    public int id;
    public String name;

    public String ipadress;
    public String username;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getIpadress() {
        return ipadress;
    }

    public String getUsername() {
        return username;
    }
}
