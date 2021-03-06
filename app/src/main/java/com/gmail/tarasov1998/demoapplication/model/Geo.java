package com.gmail.tarasov1998.demoapplication.model;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Geo implements Serializable {
    @SerializedName("lat")
    private Double lat ;
    @SerializedName("lng")
    private Double lng ;

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }
}
