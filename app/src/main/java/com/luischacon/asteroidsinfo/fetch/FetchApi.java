package com.luischacon.asteroidsinfo.fetch;

import android.content.Context;
import android.database.Cursor;
import android.widget.Toast;

import com.luischacon.asteroidsinfo.db.DbManager;
import com.luischacon.asteroidsinfo.db.entities.NasaApiResponse;
import com.luischacon.asteroidsinfo.db.entities.NearEarthObject;
import com.luischacon.asteroidsinfo.interfaces.NasaAPIservice;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FetchApi {

    private String baseUrl;
    private String startDate;

    private String endDate;
    private String apiKey;
    private DbManager db;
    private Context context;

    public FetchApi(Context context, String baseUrl, String startDate, String endDate, String apiKey) {
        this.baseUrl = baseUrl;
        this.startDate = startDate;
        this.endDate = endDate;
        this.apiKey = apiKey;
        this.db = db;
        this.context = context;
    }


    public void getAsteroids(int userId) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        NasaAPIservice nasaAPIservice = retrofit.create(NasaAPIservice.class);
        Call<NasaApiResponse> call = nasaAPIservice.getAsteroidData(startDate, endDate, apiKey);

        call.enqueue(new Callback<NasaApiResponse>() {
            @Override
            public void onResponse(Call<NasaApiResponse> call, Response<NasaApiResponse> response) {

                System.out.println(response.code());
                if (response.isSuccessful()) {
                    NasaApiResponse nasaApiResponse = (NasaApiResponse) response.body();

                    Map<String, List<NearEarthObject>> nearEarthObjects = nasaApiResponse.getNearEarthObjects();

                    for (List<NearEarthObject> nearEarthObjectList : (nearEarthObjects).values()) {
                        for (NearEarthObject nearEarthObject : nearEarthObjectList) {

                            NearEarthObject temp = new NearEarthObject();
                            temp.setName(nearEarthObject.getName());
                            temp.setEstimatedDiameterM(nearEarthObject.getEstimated_diameter());
                            temp.setAbsoluteMagnitudeH(nearEarthObject.getAbsoluteMagnitudeH());
                            temp.setPotentiallyHazardousAsteroid(nearEarthObject.isPotentiallyHazardousAsteroid());
                            temp.setFirstObservationDate(nearEarthObject.getFirstObservationDate());
                            temp.setLastObservationDate(nearEarthObject.getLastObservationDate());

                            try {
                                Cursor existeAsteroid = db.consultarAsteroid(temp.getName(), userId);

                                if (existeAsteroid.getCount() == 0) {
                                    db.open();
                                    db.insertAsteroit(temp, userId);
                                    Toast.makeText(context, "Registro exitoso", Toast.LENGTH_SHORT).show();
                                }

                            } catch (Exception err) {
                                Toast.makeText(context, "Error al almacenar datos", Toast.LENGTH_LONG).show();
                            }
                        }
                    }
                } else {
                    Toast.makeText(context, "Error al obtener los datos", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {

                Toast.makeText(context, "Error de conexión", Toast.LENGTH_LONG).show();
            }
        });
}}
