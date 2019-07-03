package com.example.weatherappupdated.modelD;

import com.google.gson.annotations.SerializedName;

public class Clouds {
    @SerializedName("all")
    private Integer all;

    public Integer getAll() {
        return all;
    }
    public void setAll(Integer all) {
        this.all = all;
    }

    public Clouds(Integer all) {
        this.all = all;

    }
}
