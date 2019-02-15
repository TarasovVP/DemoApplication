package com.gmail.tarasov1998.demoapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;


import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    RecycleViewAdapter adapter;

     List<String> namesUsers;
     List<String> emailsUsers;
     List<String> catchPhrasesUsers;
     List<Integer> avatarsUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UserModel userModel = new UserModel();
        namesUsers = new ArrayList<>();
        emailsUsers = new ArrayList<>();
        catchPhrasesUsers = new ArrayList<>();
        avatarsUsers = new ArrayList<>();

        for (int i = 0; i < 7; i++) {
            userModel.setName("dsffsfd");
            userModel.setEmail("dfsdfdsff");
            userModel.setCatchPhrase("sfsdfsdfsdf");
            userModel.setAvatar(R.drawable.ic_launcher_background);
        }

        setData(userModel);

        recyclerView = (RecyclerView)findViewById(R.id.recycle_view);
        adapter = new RecycleViewAdapter(this, namesUsers, emailsUsers, catchPhrasesUsers, avatarsUsers);
        final GridLayoutManager layoutManager = new GridLayoutManager(this, 1, GridLayoutManager.HORIZONTAL, false);
        layoutManager.setOrientation(GridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);




    }
    public void setData(UserModel userModel){
        for (int i = 0; i < 7; i++) {
            namesUsers.add(userModel.getName(i));
            emailsUsers.add(userModel.getEmail(i));
            catchPhrasesUsers.add(userModel.getCatchPhrase(i));
            avatarsUsers.add(userModel.getAvatar(i));
    }

    }
}
