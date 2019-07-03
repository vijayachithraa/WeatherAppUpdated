package com.example.weatherappupdated.serviceLayer;

import com.example.weatherappupdated.modelD.WeatherInfo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface GetServiceData {

    @Headers({"X-RapidAPI-Key: b9a5b58ef3msh4c673aa296f5128p16d422jsnca79c1476ad4",})

    @GET("/weather")
    Call<WeatherInfo> getInfo(@Query("q")String q);

}


