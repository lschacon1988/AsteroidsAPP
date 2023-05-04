package com.luischacon.asteroidsinfo.interfaces;

import com.luischacon.asteroidsinfo.db.entities.NasaApiResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NasaAPIservice {
    @GET("neo/rest/v1/feed?start_date=2023-04-28&end_date=2023-05-1&api_key=zDZJz45TCLWHeTsLuFVjl5rWTmkqJ8x680UwmGB7")
    Call<NasaApiResponse> getAsteroidData(
            @Query("start_date") String startDate,
            @Query("end_date") String endDate,
            @Query("api_key") String apiKey);
}
