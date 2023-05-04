package com.luischacon.asteroidsinfo;



import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import com.luischacon.asteroidsinfo.db.DbManager;
import com.luischacon.asteroidsinfo.db.entities.NearEarthObject;
import com.luischacon.asteroidsinfo.fetch.FetchApi;

import java.util.ArrayList;

public class ListAsteroidsActivity extends AppCompatActivity {

    RecyclerView list_asteroids;

    ArrayList<NearEarthObject> listAsteroids;

    FetchApi fetchApi = new FetchApi(ListAsteroidsActivity.this,"https://api.nasa.gov/","2023/04/28","2023/04/28","zDZJz45TCLWHeTsLuFVjl5rWTmkqJ8x680UwmGB7");
    int userId;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_asteroids);

        Intent intent = getIntent();
        userId = intent.getIntExtra("USER_ID", -1);

        fetchApi.getAsteroids(userId);

        //METODOS PARA IMPLEMENTAR RecyclerView FALLA

//        list_asteroids = findViewById(R.id.list_asteroids);
//        list_asteroids.setLayoutManager(new LinearLayoutManager(this));
//       ListaAsteroidsAdapter listAdapter= new ListaAsteroidsAdapter(helper.listarAsteroids(userId));
//        list_asteroids.setAdapter(listAdapter);

    }


}