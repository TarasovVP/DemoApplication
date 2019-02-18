package com.gmail.tarasov1998.demoapplication.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Company {
    @SerializedName("catchPhrase")
    @Expose
    private String catchPhrase;

    public String getCatchPhrase() {
        return catchPhrase;
    }

    public void setCatchPhrase(String catchPhrase) {
        this.catchPhrase = catchPhrase;
    }
}
