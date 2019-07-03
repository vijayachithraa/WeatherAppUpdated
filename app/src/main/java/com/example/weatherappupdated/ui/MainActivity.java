package com.example.weatherappupdated.ui;

import android.app.ProgressDialog;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.weatherappupdated.R;
import com.example.weatherappupdated.adapter.ViewPagerAdapter;
import com.example.weatherappupdated.modelD.WeatherInfo;
import com.example.weatherappupdated.serviceLayer.GetServiceData;
import com.example.weatherappupdated.serviceLayer.RetrofitClientInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ProgressDialog progressDialog;
    WeatherInfo weatherInfo = new WeatherInfo();
    TextView weather;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));
       getweather();

    }


    public void getweather(){
//        progressDialog = new ProgressDialog(MainActivity.this);
//        progressDialog.setMessage("Loading....");
//        progressDialog.show();
        GetServiceData getServiceData= RetrofitClientInstance.getRetrofitInstance().create(GetServiceData.class);
        Call <WeatherInfo> call= getServiceData.getInfo("chennai");
        call.enqueue(new Callback<WeatherInfo>() {
            @Override
            public void onResponse(Call<WeatherInfo> call, Response<WeatherInfo>response) {
               // progressDialog.dismiss();
                weatherInfo= response.body();
//                weather.setText(weatherInfo.getName());
//                weather.setText(weatherInfo.getId());
                //ddgit push -u origin masterv
            }

            @Override
            public void onFailure(Call <WeatherInfo> call, Throwable t) {




            }
        });


    }
}


