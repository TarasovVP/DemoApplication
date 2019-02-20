package com.gmail.tarasov1998.demoapplication.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.gmail.tarasov1998.demoapplication.R;
import com.gmail.tarasov1998.demoapplication.model.User;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private List<User> listUsers;

    RecyclerView recyclerView;
    RecycleViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        Bundle extras = intent.getBundleExtra("bundle");
        if (extras != null) {
           listUsers = (ArrayList<User>) extras.getSerializable("listUsers");        }

        recyclerView = findViewById(R.id.recycle_view);
        adapter = new RecycleViewAdapter(getApplicationContext(), listUsers);
        final GridLayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 1, GridLayoutManager.HORIZONTAL, false);
        layoutManager.setOrientation(GridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }
}



