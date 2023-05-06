package com.luischacon.asteroidsinfo.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.luischacon.asteroidsinfo.db.entities.Asteroit;
import com.luischacon.asteroidsinfo.db.entities.NearEarthObject;

import java.util.ArrayList;

public class DbManager {

    private final SQLiteOpenHelper dbHelper;

    public DbManager(Context context) {
        dbHelper = new SQLiteOpenHelper(context);
    }

    // METODO PARA ABRIR LA BASE DE DB
    public void open() {
        dbHelper.getWritableDatabase();
    }

    //METODO PARA CERRAR
    public void cerra() {
        dbHelper.close();
    }

    public void insertUser(String username, String password, String first_name, String last_name, String email) {
        ContentValues value = new ContentValues();
        value.put("username", username);
        value.put("password", password);
        value.put("first_name", first_name);
        value.put("last_name", last_name);
        value.put("email", email);

        dbHelper.getWritableDatabase().insert("users", null, value);

    }

    public Cursor consultarUser(String email, String password) throws SQLException {
        Cursor mCursor = null;
        String[] columns = new String[]{"_id", "first_name", "last_name", "username", "email", "password"};

        mCursor = dbHelper.getReadableDatabase().query("users", columns, "email=? AND password=?", new String[]{email, password}, null, null, null);

        return mCursor;
    }

    //METODO PARA INSERTAR ASTEROIDE
    public void insertAsteroit(NearEarthObject nearEarthObject, int user_id) {
        ContentValues value = new ContentValues();
        value.put("name", nearEarthObject.getName());
        value.put("absolute_magnitude_h", nearEarthObject.getAbsoluteMagnitudeH());
        value.put("estimated_diameter_m", (Double) nearEarthObject.getEstimated_diameter().getMeters().get("estimated_diameter_max"));
        value.put("is_potentially_hazardous_asteroid", nearEarthObject.isPotentiallyHazardousAsteroid() ? 1 : 0);
        value.put("first_observation_date", nearEarthObject.getFirstObservationDate());
        value.put("last_observation_date", nearEarthObject.getLastObservationDate());
        value.put("user_id", user_id);

        dbHelper.getWritableDatabase().insert("asteroids", null, value);
    }

    public Cursor consultarAsteroid(String name, int user_id) { // valida pra no registra asteroides duplocaods a usuarios
        Cursor cursorAsteroid = null;

        cursorAsteroid = dbHelper.getReadableDatabase().rawQuery("SELECT * FROM asteroids WHERE user_id='" + user_id + "' AND name='" + name + "' ", null);

        return cursorAsteroid;
    }

    public ArrayList<Asteroit> listarAsteroids(int userId) {
        Cursor listAsteroidCursos = null;
        Asteroit asteroid = null;
        ArrayList<Asteroit> list = new ArrayList<>();

        listAsteroidCursos = dbHelper.getReadableDatabase().rawQuery("SELECT * FROM asteroids WHERE user_id = '" + userId + "'", null);

        if (listAsteroidCursos.moveToFirst()) {
            do {
                asteroid = new Asteroit();
                asteroid.set_id(listAsteroidCursos.getInt(0));
                asteroid.setName(listAsteroidCursos.getString(1));
                asteroid.setAbsolute_magnitude_h((float) listAsteroidCursos.getDouble(2));
                asteroid.setEstimated_diameter_m((float) listAsteroidCursos.getDouble(3));
                asteroid.setIs_potentially_hazardous_asteroid(listAsteroidCursos.getInt(4));
                asteroid.setFirst_observation_date(listAsteroidCursos.getString(5));
                asteroid.setLast_observation_date(listAsteroidCursos.getString(6));
                list.add(asteroid);


            } while (listAsteroidCursos.moveToNext());
        }

        listAsteroidCursos.close();

        return list;
    }


    public boolean isEmailExists(String email) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM users WHERE email=?", new String[]{email});
        boolean result = cursor.getCount() > 0;
        cursor.close();
        return result;
    }


}
