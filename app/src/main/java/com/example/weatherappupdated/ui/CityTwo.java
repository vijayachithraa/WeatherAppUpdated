package com.example.weatherappupdated.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.weatherappupdated.R;
import com.example.weatherappupdated.modelD.Weather;
import com.example.weatherappupdated.modelD.WeatherInfo;
import com.example.weatherappupdated.serviceLayer.GetServiceData;
import com.example.weatherappupdated.serviceLayer.RetrofitClientInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class CityTwo extends Fragment {
    View view;
    WeatherInfo weatherInfo;
    TextView place;
    TextView temperature;



    public CityTwo() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_city_two, container, false);


        GetServiceData getServiceData = RetrofitClientInstance.getRetrofitInstance().create(GetServiceData.class);
        Call<WeatherInfo> call = getServiceData.getInfo("chennai");
        call.enqueue(new Callback<WeatherInfo>() {
            @Override
            public void onResponse(Call<WeatherInfo> call, Response<WeatherInfo> response) {
                // progressDialog.dismiss();
                weatherInfo = response.body();

                place = view.findViewById(R.id.city2);

                place.setText(weatherInfo.getName());
//                weather.setText(weatherInfo.getName());
//                weather.setText(weatherInfo.getId());
            }

            @Override
            public void onFailure(Call<WeatherInfo> call, Throwable t) {

            }

        });
        return view;

    }
}
