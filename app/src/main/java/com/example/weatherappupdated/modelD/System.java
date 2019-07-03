package com.example.weatherappupdated.modelD;

import com.google.gson.annotations.SerializedName;

public class System {

    @SerializedName("type")
    private Double type;
    @SerializedName("id")
    private Double id;
    @SerializedName("message")
    private Double message;
    @SerializedName("country")
    private String country;
    @SerializedName("sunsire")
    private Double sunrise;

    public void setType(Double type) {
        this.type = type;
    }

    public void setId(Double id) {
        this.id = id;
    }

    public void setMessage(Double message) {
        this.message = message;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setSunrise(Double sunrise) {
        this.sunrise = sunrise;
    }

    public void setSunset(Double sunset) {
        this.sunset = sunset;
    }

    public Double getType() {
        return type;
    }

    public Double getId() {
        return id;
    }

    public Double getMessage() {
        return message;
    }

    public String getCountry() {
        return country;
    }

    public Double getSunrise() {
        return sunrise;
    }

    public Double getSunset() {
        return sunset;
    }

    @SerializedName("sunset")
    private Double sunset;
}
