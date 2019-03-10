package com.gmail.tarasov1998.demoapplication.api;

import com.gmail.tarasov1998.demoapplication.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


public interface ApiService {

    @GET("/users")
    Call<List<User>> getAllUsers();

}
