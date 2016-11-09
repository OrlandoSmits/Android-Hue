package com.android.orlandosmits.handler;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.android.orlandosmits.bridge.Bridge;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;

/**
 * @Author Orlando Smits
 */

public class DatabaseHandler extends SQLiteAssetHelper {

    // Database Name
    private static final String DB_NAME = "hueDB.db";

    // Database Version
    private static final int DB_VERSION = 1;

    // Get a Readable Database instance called db
    SQLiteDatabase db = getReadableDatabase();

    public DatabaseHandler(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }

    // Getters for the Database
    // Get the bridges from the Database
    public ArrayList<Bridge> getBridges(ArrayList<Bridge> ar){

        // Database Query
        String query = "SELECT * FROM Bridge;";

        // Create a new Cursor that runs the Query
        Cursor c = db.rawQuery(query, null);
        c.moveToFirst();

        while(c.moveToNext()){
            Bridge bridge = new Bridge();
            bridge.name = c.getString(c.getColumnIndex("name"));
            bridge.ipadress = c.getString(c.getColumnIndex("ipadress"));
            bridge.username = c.getString(c.getColumnIndex("username"));

            ar.add(bridge);
        }
        // Close Database
        db.close();

        return ar ;
    }
}
