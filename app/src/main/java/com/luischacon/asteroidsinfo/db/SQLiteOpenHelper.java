package com.luischacon.asteroidsinfo.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.luischacon.asteroidsinfo.db.entities.NearEarthObject;

import java.util.ArrayList;

public class SQLiteOpenHelper extends android.database.sqlite.SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 5;
    private static final String DATABASE_NAME = "asteroids.db";

    private static final String CREATE_TABLE_USERS = "CREATE TABLE " +
            "users (_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "username TEXT not null unique," +
            " password TEXT not null," +
            "first_name TEXT not null," +
            "last_name TEXT not null," +
            "email TEXT unique, " +
            "timeStamp INTEGER )";

    private static final String CREATE_TABLE_ASTEROIDS = "CREATE TABLE asteroids (" +
            "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "name TEXT, " +
            "absolute_magnitude_h REAL," +
            "estimated_diameter_m REAL, " +
            "is_potentially_hazardous_asteroid INTEGER, " +
            "first_observation_date TEXT," +
            " last_observation_date TEXT," +
            "user_id INTEGER, " +
            "FOREIGN KEY(user_id) REFERENCES users(_id))";

    public SQLiteOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_USERS);
        db.execSQL(CREATE_TABLE_ASTEROIDS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS users");
        db.execSQL("DROP TABLE IF EXISTS asteroids");
        onCreate(db);
    }




}
