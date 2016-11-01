package com.android.orlandosmits.contactapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by Orlando Smits on 28-10-2016.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final String TAG = "DatabaseHandler";

    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "user.db";
    private static final String DB_TABLE_NAME = "users";

    private static final String COLOMN_ID = "_id";
    private static final String COLOMN_FIRSTNAME = "firstName";
    private static final String COLOMN_LASTNAME = "lastName";
    private static final String COLOMN_GENDER = "gender";
    private static final String COLOMN_EMAIL = "email";
    private static final String COLOMN_IMAGEURL = "imageUrl";

    ArrayList tempList = new ArrayList();

    public DatabaseHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_PERSON_TABLE = "CREATE TABLE " + DB_TABLE_NAME +
                "(" +
                COLOMN_ID + " INTEGER PRIMARY KEY," +
                COLOMN_FIRSTNAME + " TEXT," +
                COLOMN_LASTNAME + " TEXT," +
                COLOMN_GENDER + " TEXT," +
                COLOMN_EMAIL + " TEXT," +
                COLOMN_IMAGEURL + " TEXT" +
                ")";
        db.execSQL(CREATE_PERSON_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DB_TABLE_NAME);
        onCreate(db);
    }

    public void addUser(User user) {
        ContentValues values = new ContentValues();
        values.put(COLOMN_FIRSTNAME, user.getmFirstName());
        values.put(COLOMN_LASTNAME, user.getmLastName());
        values.put(COLOMN_EMAIL, user.getmEmail());
        values.put(COLOMN_GENDER, user.getmGender());
        values.put(COLOMN_IMAGEURL, user.getmImage());

        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(DB_TABLE_NAME, null, values);
        db.close();
    }

    public void removeUser(User user){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + DB_TABLE_NAME + " WHERE " + COLOMN_FIRSTNAME + " = '" + user.mFirstName + "' AND " + COLOMN_LASTNAME + " = '" + user.mLastName +"'; ");

    }
    public void removeDb(){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS " + DB_TABLE_NAME);
        onCreate(db);

    }


    public ArrayList<User> getUsers() {
        SQLiteDatabase db = getReadableDatabase();
        ArrayList<User> list = new ArrayList<>();

        String query = "SELECT * FROM " + DB_TABLE_NAME;
        Cursor c = db.rawQuery(query, null);
        c.moveToFirst();
        db.close();

        if (c.moveToFirst()) {


            while (!c.isAfterLast()) {
                User u = new User();
                u.mFirstName = c.getString(c.getColumnIndex(COLOMN_FIRSTNAME));
                u.mLastName = c.getString(c.getColumnIndex(COLOMN_LASTNAME));
                u.mGender = c.getString(c.getColumnIndex(COLOMN_GENDER));
                u.mEmail = c.getString(c.getColumnIndex(COLOMN_EMAIL));
                u.mImage = c.getString(c.getColumnIndex(COLOMN_IMAGEURL));

                list.add(u);
                c.moveToNext();
            }
        }

        return list;
    }

}
