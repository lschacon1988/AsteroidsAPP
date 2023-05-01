package com.luischacon.asteroidsinfo.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class SQLiteOpenHelper extends android.database.sqlite.SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "asteroids.db";

    private static final String CREATE_TABLE_USERS = "CREATE TABLE " +
            "users (_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "username TEXT not null unique, password TEXT not null," +
            "first_name TEXT not null,last_name TEXT not null," +
            "email TEXT unique, timeStamp INTEGER )";

    private static final String CREATE_TABLE_ASTEROIDS = "CREATE TABLE " +
            "asteroids (_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "user_id INTEGER, " +
            "name TEXT, " +
            "diameter REAL, " +
            "distance REAL, " +
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

    // METODO PARA ABRIR LA BASE DE DB
    public  void open(){
        this.getWritableDatabase();
    }
    //METODO PARA CERRAR
    public void cerra(){this.close();}

    public void insertUser(String first_name,String last_name,String email , String username, String password ){
        ContentValues value = new ContentValues();
        value.put("first_name", first_name);
        value.put("last_name", last_name);
        value.put("username", username);
        value.put("email", email);
        value.put("password",password);
        this.getWritableDatabase().insert("users",null,value);

    }
}
