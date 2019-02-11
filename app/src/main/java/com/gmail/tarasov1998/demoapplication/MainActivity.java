package com.gmail.tarasov1998.demoapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    RecycleViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        adapter = new RecycleViewAdapter(getBaseContext(), userName, email, catchPhrase, avatars);

    }
}
