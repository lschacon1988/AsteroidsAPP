package com.luischacon.asteroidsinfo;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import com.luischacon.asteroidsinfo.adaptaer.ListaAsteroidsAdapter;
import com.luischacon.asteroidsinfo.db.DbManager;
import com.luischacon.asteroidsinfo.db.entities.Asteroit;
import com.luischacon.asteroidsinfo.db.entities.NearEarthObject;
import com.luischacon.asteroidsinfo.fetch.FetchApi;

import java.util.ArrayList;

public class ListAsteroidsActivity extends AppCompatActivity {

    RecyclerView list_asteroid;

    ArrayList<Asteroit> listAsteroids;
    DbManager db = new DbManager(ListAsteroidsActivity.this);

    FetchApi fetchApi = new FetchApi(ListAsteroidsActivity.this, "https://api.nasa.gov/", "2023/04/28", "2023/04/28", "zDZJz45TCLWHeTsLuFVjl5rWTmkqJ8x680UwmGB7");
    int userId;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_asteroids);


        Intent intent = getIntent();
        userId = intent.getIntExtra("USER_ID", -1);

        //fetchApi.getAsteroids(userId);


        list_asteroid = findViewById(R.id.list_asteroids);
        list_asteroid.setLayoutManager(new GridLayoutManager(this,2));
//        ListaAsteroidsAdapter listAdapter = new ListaAsteroidsAdapter(db.listarAsteroids(userId));
//        list_asteroid.setAdapter(listAdapter);


        listAsteroids = db.listarAsteroids(userId);

        // Si no hay datos en la base de datos, obtén los datos de la API
        if (listAsteroids.isEmpty()) {
            fetchApi.getAsteroids(userId);
        } else {
            ListaAsteroidsAdapter listAdapter = new ListaAsteroidsAdapter(listAsteroids);
            list_asteroid.setAdapter(listAdapter);
        }

    }


}