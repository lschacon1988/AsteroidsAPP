package com.luischacon.asteroidsinfo;



import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import com.luischacon.asteroidsinfo.db.DbManager;
import com.luischacon.asteroidsinfo.db.entities.NasaApiResponse;
import com.luischacon.asteroidsinfo.db.entities.NearEarthObject;
import com.luischacon.asteroidsinfo.fetch.FetchApi;
import com.luischacon.asteroidsinfo.interfaces.NasaAPIservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListAsteroids extends AppCompatActivity {

    RecyclerView list_asteroids;

    //SQLiteOpenHelper helper = new SQLiteOpenHelper(this);
    DbManager db = new DbManager(this);

    ArrayList<NearEarthObject> listAsteroids;

    FetchApi fetchApi = new FetchApi(ListAsteroids.this,"https://api.nasa.gov/","2023/04/28","2023/04/28","zDZJz45TCLWHeTsLuFVjl5rWTmkqJ8x680UwmGB7");
    int userId;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_asteroids);

        Intent intent = getIntent();
        userId = intent.getIntExtra("USER_ID", -1);
        System.out.println("LISTA DE ASTEROIDES d" + db.listarAsteroids(userId));
        fetchApi.getAsteroids(userId);

        //METODOS PARA IMPLEMENTAR RecyclerView FALLA

//        list_asteroids = findViewById(R.id.list_asteroids);
//        list_asteroids.setLayoutManager(new LinearLayoutManager(this));
//       ListaAsteroidsAdapter listAdapter= new ListaAsteroidsAdapter(helper.listarAsteroids(userId));
//        list_asteroids.setAdapter(listAdapter);

    }


}