package com.gmail.tarasov1998.demoapplication.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Address {


    @SerializedName("geo")
    @Expose
    private Geo geo;

    public Geo getGeo() {
        return geo;
    }

    public void setGeo(Geo geo) {
        this.geo = geo;
    }
}
