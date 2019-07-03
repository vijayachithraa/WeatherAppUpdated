package com.example.weatherappupdated.modelD;

import android.app.Notification;

import com.google.gson.annotations.SerializedName;

public class Wind {

    @SerializedName("speed")
    private Double speed;

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public void setDeg(Integer deg) {
        this.deg = deg;
    }

    public Double getSpeed() {
        return speed;
    }

    public Integer getDeg() {
        return deg;
    }

    @SerializedName("deg")
    private Integer deg;
}




