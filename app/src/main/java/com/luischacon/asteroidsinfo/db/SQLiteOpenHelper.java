package com.luischacon.asteroidsinfo.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

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

    // METODO PARA ABRIR LA BASE DE DB
    public void open() {
        this.getWritableDatabase();
    }

    //METODO PARA CERRAR
    public void cerra() {
        this.close();
    }

    public void insertUser(String username, String password, String first_name, String last_name, String email) {
        ContentValues value = new ContentValues();
        value.put("username", username);
        value.put("password", password);
        value.put("first_name", first_name);
        value.put("last_name", last_name);
        value.put("email", email);

        this.getWritableDatabase().insert("users", null, value);

    }

    public Cursor consultarUser(String email, String password) throws SQLException {
        Cursor mCursor = null;
        String[] columns = new String[]{"_id", "first_name", "last_name", "username", "email", "password"};

        mCursor = this.getReadableDatabase().query("users", columns, "email=? AND password=?", new String[]{email, password}, null, null, null);

        return mCursor;
    }

    //METODO PARA INSERTAR ASTEROIDE
   public void insertAsteroit(NearEarthObject nearEarthObject,int user_id){
       ContentValues value = new ContentValues();
       value.put("name",nearEarthObject.getName());
       value.put("absolute_magnitude_h",nearEarthObject.getAbsoluteMagnitudeH());
       value.put("estimated_diameter_m", (Double) nearEarthObject.getEstimated_diameter().getMeters().get("estimated_diameter_max"));
       value.put("is_potentially_hazardous_asteroid",nearEarthObject.isPotentiallyHazardousAsteroid()?1:0);
       value.put("first_observation_date", nearEarthObject.getFirstObservationDate());
       value.put("last_observation_date",nearEarthObject.getLastObservationDate());
       value.put("user_id",user_id);

       this.getWritableDatabase().insert("asteroids", null, value);
   }

   public Cursor consultarAsteroid(String name,int user_id){ // valida pra no registra asteroides duplocaods a usuarios
        Cursor cursorAsteroid = null;

        cursorAsteroid= this.getReadableDatabase().rawQuery("SELECT * FROM asteroids WHERE user_id='"+user_id+"' AND name='"+name+"' ",null);

        return cursorAsteroid;
   }

   public ArrayList<NearEarthObject> listarAsteroids(int userId){
        Cursor listAsteroidCursos = null;
        NearEarthObject asteroid = null;
        ArrayList<NearEarthObject> list = new ArrayList<>();

        listAsteroidCursos = this.getReadableDatabase().rawQuery("SELECT * FROM asteroids WHERE user_id = '"+userId+"'",null);

        if(listAsteroidCursos.moveToFirst()){
            do{
                asteroid = new NearEarthObject();
                asteroid.setId(listAsteroidCursos.getInt(0));
                asteroid.setName(listAsteroidCursos.getString(1));
                asteroid.setAbsoluteMagnitudeH(listAsteroidCursos.getDouble(2));
                asteroid.setEstimatedDiameterM( listAsteroidCursos.getDouble(3));
                asteroid.setPotentiallyHazardousAsteroid(listAsteroidCursos.getInt(4));
                asteroid.setFirstObservationDate(listAsteroidCursos.getString(5));
                asteroid.setLastObservationDate(listAsteroidCursos.getString(6));
                list.add(asteroid);


            }while (listAsteroidCursos.moveToNext());
        }

        listAsteroidCursos.close();

        return list;
   }


}
