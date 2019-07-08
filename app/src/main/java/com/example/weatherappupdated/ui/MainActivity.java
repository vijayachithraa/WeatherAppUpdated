package com.example.weatherappupdated.ui;

import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.weatherappupdated.R;
import com.example.weatherappupdated.adapter.ViewPagerAdapter2;
import com.example.weatherappupdated.modelD.WeatherInfo;
import com.example.weatherappupdated.serviceLayer.GetServiceData;
import com.example.weatherappupdated.serviceLayer.RetrofitClientInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private List<WeatherInfo> weatherinfo = new ArrayList<>();
     ArrayList<String> mcity = new ArrayList<>();
    ViewPager viewPager;

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.view_pager);
        mcity();
        weatherinfo(mcity);

    }

    private void weatherinfo(final ArrayList<String> mcity) {
        for(String cityName:mcity){
            GetServiceData getServiceData =RetrofitClientInstance.getRetrofitInstance().create(GetServiceData.class);
            Call<WeatherInfo> call =getServiceData.getInfo(cityName);
            call.enqueue(new Callback<WeatherInfo>() {
                @Override
                public void onResponse(Call<WeatherInfo> call, Response<WeatherInfo> response) {

                    if(response!=null){

                        WeatherInfo info=response.body();
                        weatherinfo.add(info);
                    }

                    if(mcity.size()== weatherinfo.size()){
                        viewPager.setAdapter(new ViewPagerAdapter2(MainActivity.this,weatherinfo));
                }


                }

                @Override
                public void onFailure(Call<WeatherInfo> call, Throwable t) {

                    Log.e(TAG, "onFailure: "+t.getLocalizedMessage() );

                }
            });
        }
    }

    private void mcity() {
        mcity.add("Chennai");
        mcity.add("Mumbai");
        mcity.add("Bangalore");
        mcity.add("Hyderabad");
    }
}


