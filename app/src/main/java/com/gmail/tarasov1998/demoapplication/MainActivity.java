package com.gmail.tarasov1998.demoapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    //RecycleViewAdapter adapter;

    private List<String> namesUsers;
    private List<String> emailsUsers;
    private List<String> catchPhrasesUsers;
    private List<Integer> avatarsUsers;
    private LayoutInflater mInflater;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //adapter = new RecycleViewAdapter(getBaseContext(), namesUsers, emailsUsers, catchPhrasesUsers, avatarsUsers);

    }
}
