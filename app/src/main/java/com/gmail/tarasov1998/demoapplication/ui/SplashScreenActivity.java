package com.gmail.tarasov1998.demoapplication.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.gmail.tarasov1998.demoapplication.R;
import com.gmail.tarasov1998.demoapplication.api.ApiNetworkService;
import com.gmail.tarasov1998.demoapplication.model.User;

import java.io.Serializable;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplashScreenActivity extends AppCompatActivity {
    List<User> listUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                ApiNetworkService.getInstance()
                        .getJSONApi()
                        .getAllUsers()
                        .enqueue(new Callback<List<User>>() {
                            @Override
                            public void onResponse(@NonNull Call<List<User>> call, @NonNull Response<List<User>> response) {
                                listUsers = response.body();
                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                Bundle extras = new Bundle();
                                extras.putSerializable("listUsers", (Serializable) listUsers);
                                intent.putExtra("bundle", extras);
                                startActivity(intent);
                            }

                            @Override
                            public void onFailure(@NonNull Call<List<User>> call, @NonNull Throwable t) {
                                Toast.makeText(getBaseContext(), R.string.error, Toast.LENGTH_SHORT).show();
                            }

                        });
            }
        }, 3000);


    }

}





