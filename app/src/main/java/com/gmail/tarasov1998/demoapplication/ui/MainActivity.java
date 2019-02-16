package com.gmail.tarasov1998.demoapplication.ui;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.gmail.tarasov1998.demoapplication.R;
import com.gmail.tarasov1998.demoapplication.data.JsonParser;
import com.gmail.tarasov1998.demoapplication.model.UserModel;
import com.gmail.tarasov1998.demoapplication.network.Network;


public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecycleViewAdapter adapter;

    UserModel userModel = new UserModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        JSONUserTask jsonUserTask = new JSONUserTask();
        jsonUserTask.execute();

    }

    @SuppressLint("StaticFieldLeak")
    private class JSONUserTask extends AsyncTask<String, Void, UserModel> {


        @Override
        protected UserModel doInBackground(String... params) {
            String users = ((new Network()).getUsers());
            try {
                if (users == null) {
                    return null;
                } else {
                    userModel = JsonParser.getUser(users);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return userModel;
        }

        @Override
        protected void onPostExecute(final UserModel userModel) {
            super.onPostExecute(userModel);

            if (userModel == null) {
                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
            } else {
                if (userModel.getCount() == 0) {
                    Toast.makeText(getApplicationContext(), "Error2", Toast.LENGTH_LONG).show();
                } else {
                    recyclerView = findViewById(R.id.recycle_view);
                    adapter = new RecycleViewAdapter(getApplicationContext(), userModel);
                    final GridLayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 1, GridLayoutManager.HORIZONTAL, false);
                    layoutManager.setOrientation(GridLayoutManager.VERTICAL);
                    recyclerView.setLayoutManager(layoutManager);
                    recyclerView.setAdapter(adapter);
                }
            }
        }
    }
}
