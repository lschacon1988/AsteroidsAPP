package com.luischacon.asteroidsinfo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import com.google.gson.Gson;
import com.luischacon.asteroidsinfo.adaptaer.ListaAsteroidsAdapter;
import com.luischacon.asteroidsinfo.db.SQLiteOpenHelper;
import com.luischacon.asteroidsinfo.db.entities.Asteroid;
import com.luischacon.asteroidsinfo.db.entities.EstimatedDiameter;
import com.luischacon.asteroidsinfo.db.entities.NasaApiResponse;
import com.luischacon.asteroidsinfo.db.entities.NearEarthObject;
import com.luischacon.asteroidsinfo.interfaces.NasaAPIservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListAsteroidsActivity extends AppCompatActivity {

    RecyclerView list_asteroids;

    SQLiteOpenHelper helper = new SQLiteOpenHelper(this);

    ArrayList<Asteroid> listAsteroids;

    ListaAsteroidsAdapter listAdapter;
    String startDate= "2023/04/28";
    String apiKey = "zDZJz45TCLWHeTsLuFVjl5rWTmkqJ8x680UwmGB7";
    String endDate = "2023/04/28";
    int userId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_asteroids);

        list_asteroids = findViewById(R.id.list_asteroids);
        list_asteroids.setLayoutManager(new LinearLayoutManager(this));

//        listAdapter = new ListaAsteroidsAdapter(); //debo crear la consulta
//        list_asteroids.setAdapter(listAdapter);

        Intent intent = getIntent();
        userId = intent.getIntExtra("USER_ID", -1);

        getAsteroids(userId);







    }


    private void getAsteroids(int userId){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.nasa.gov/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        NasaAPIservice nasaAPIservice = retrofit.create(NasaAPIservice.class);
        Call<NasaApiResponse> call = nasaAPIservice.getAsteroidData(startDate,endDate,apiKey);

        call.enqueue(new Callback<NasaApiResponse>() {
            @Override
            public void onResponse(Call<NasaApiResponse> call, Response<NasaApiResponse>response) {


                if (response.isSuccessful()) {
                    NasaApiResponse nasaApiResponse = (NasaApiResponse) response.body();

                    Map<String, List<NearEarthObject>> nearEarthObjects = nasaApiResponse.getNearEarthObjects();

                    for (List<NearEarthObject> nearEarthObjectList : ( nearEarthObjects).values()) {
                        for (NearEarthObject nearEarthObject : nearEarthObjectList) {

                            NearEarthObject temp = new NearEarthObject();
                            temp.setName(nearEarthObject.getName());
                            temp.setEstimatedDiameterM(nearEarthObject.getEstimated_diameter());
                            temp.setAbsoluteMagnitudeH(nearEarthObject.getAbsoluteMagnitudeH());
                            temp.setPotentiallyHazardousAsteroid(nearEarthObject.isPotentiallyHazardousAsteroid());
                            temp.setFirstObservationDate(nearEarthObject.getFirstObservationDate());
                            temp.setLastObservationDate(nearEarthObject.getLastObservationDate());

                            try {
                                Cursor existeAsteroid = helper.consutarAsteroid(temp.getName());
                                if(existeAsteroid.getCount() == 0){
                                    helper.open();
                                    helper.insertAsteroit(temp,userId);
                                    Toast.makeText(ListAsteroidsActivity.this,"Registro exitoso", Toast.LENGTH_LONG).show();
                                }

                            }catch ( Exception err){
                                Toast.makeText(ListAsteroidsActivity.this,"Error al almacenar datos", Toast.LENGTH_LONG).show();
                            }
                        }
                    }
                }  else {
                    Toast.makeText(ListAsteroidsActivity.this, "Error al obtener los datos", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Toast.makeText(ListAsteroidsActivity.this, "Error de conexión", Toast.LENGTH_LONG).show();
            }
        });

    }
}