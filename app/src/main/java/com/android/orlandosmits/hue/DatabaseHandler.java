package com.android.orlandosmits.hue;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

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
    public Cursor getBridges(){

        // Database Query
        String query = "SELECT * FROM Bridge;";

        // Create a new Cursor that runs the Query
        Cursor c = db.rawQuery(query, null);
        c.moveToFirst();

        // Close Database
        db.close();

        return c;
    }
}
