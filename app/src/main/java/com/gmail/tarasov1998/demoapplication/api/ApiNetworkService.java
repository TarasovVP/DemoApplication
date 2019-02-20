package com.gmail.tarasov1998.demoapplication.api;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiNetworkService {

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com";

    private static ApiNetworkService mInstance;

    private Retrofit mRetrofit;
    private OkHttpClient client;

    private ApiNetworkService() {

        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(getClient())
                .build();
    }

    private OkHttpClient getClient() {

        if (client == null) {
            client = new OkHttpClient
                    .Builder()
                    .readTimeout(60, TimeUnit.SECONDS)
                    .connectTimeout(60, TimeUnit.SECONDS)
                    .writeTimeout(60, TimeUnit.SECONDS)
                    .retryOnConnectionFailure(true)
                    .build();
        }
        return client;
    }

    public static ApiNetworkService getInstance() {
        if (mInstance == null) {
            mInstance = new ApiNetworkService();
        }
        return mInstance;
    }

    public ApiService getJSONApi() {
        return mRetrofit.create(ApiService.class);
    }
}
