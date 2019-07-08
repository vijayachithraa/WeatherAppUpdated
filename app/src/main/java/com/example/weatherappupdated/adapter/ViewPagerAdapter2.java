package com.example.weatherappupdated.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.weatherappupdated.R;
import com.example.weatherappupdated.modelD.WeatherInfo;

import java.util.List;

public class ViewPagerAdapter2 extends PagerAdapter {

    private Context mContext;
    private List<WeatherInfo> mWeatherList;


    public ViewPagerAdapter2(Context mContext, List<WeatherInfo> mWeatherList) {
        this.mContext = mContext;
        this.mWeatherList = mWeatherList;
    }

    @Override
    public int getCount() {
        return mWeatherList.size();
    }

    @Override

    public void destroyItem(ViewGroup container,int position, Object object){
        container.removeView((View) object);

    }
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }


    @Override
    public int getItemPosition(@NonNull Object object) {
        return super.getItemPosition(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.activity_without_fragment_city, container, false);

        TextView city = view.findViewById(R.id.city);
        TextView temperature = view.findViewById(R.id.temperature);
        TextView coord = view.findViewById(R.id.coord);
        TextView humidity = view.findViewById(R.id.humidity_text);
        TextView pressure = view.findViewById(R.id.pressure_text);

        city.setText(mWeatherList.get(position).getName());
        temperature.setText(String.valueOf(mWeatherList.get(position).getMain().getTemp()));
        coord.setText((String.valueOf(mWeatherList.get(position).getCoord())));
        pressure.setText(String.valueOf(mWeatherList.get(position).getMain().getPressure()));
        humidity.setText(String.valueOf(mWeatherList.get(position).getMain().getHumidity()));
        container.addView(view);

        return view;


    }
}
