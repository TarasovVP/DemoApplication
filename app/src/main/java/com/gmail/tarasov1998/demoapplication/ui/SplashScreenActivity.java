package com.gmail.tarasov1998.demoapplication.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.gmail.tarasov1998.demoapplication.R;
import com.gmail.tarasov1998.demoapplication.RealmUser.RealmUser;
import com.gmail.tarasov1998.demoapplication.api.ApiNetworkService;
import com.gmail.tarasov1998.demoapplication.model.Address;
import com.gmail.tarasov1998.demoapplication.model.Company;
import com.gmail.tarasov1998.demoapplication.model.Geo;
import com.gmail.tarasov1998.demoapplication.model.User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.gmail.tarasov1998.demoapplication.MainApplication.isNetworkAvailable;

public class SplashScreenActivity extends AppCompatActivity {
    List<User> listUsers;
    Intent intent;
    Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {

                intent = new Intent(getApplicationContext(), MainActivity.class);
                extras = new Bundle();

                if (isNetworkAvailable(getApplicationContext())) {
                    ApiNetworkService.getService().getAllUsers()
                            .enqueue(new Callback<List<User>>() {
                                @Override
                                public void onResponse(@NonNull Call<List<User>> call, @NonNull Response<List<User>> response) {

                                    listUsers = response.body();
                                    writeToDB(listUsers);
                                    extras.putSerializable("listUsers", (Serializable) listUsers);
                                    intent.putExtra("bundle", extras);
                                    startActivity(intent);
                                    finish();
                                }

                                @Override
                                public void onFailure(@NonNull Call<List<User>> call, @NonNull Throwable t) {
                                    Toast.makeText(getBaseContext(), R.string.error, Toast.LENGTH_SHORT).show();
                                }
                            });
                } else{
                    listUsers = readAllFromDB(listUsers);
                    extras.putSerializable("listUsers", (Serializable) listUsers);
                    intent.putExtra("bundle", extras);
                    startActivity(intent);
                    finish();
                }

            }
        }, 3000);


    }
    private RealmUser findInDb(Realm realm, int id) {
        return realm.where(RealmUser.class).equalTo("id", id).findFirst();
    }

    private List<User> writeToDB(List<User> listUsers) {
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(transactionRealm -> {
            for (int i = 0; i < listUsers.size(); i++) {
                User userResponse = listUsers.get(i);
                RealmUser userRealm = findInDb(transactionRealm, userResponse.getId());
                if (userRealm == null) {
                    userRealm = transactionRealm.createObject(RealmUser.class, userResponse.getId());
                }
                userRealm.setEmail(userResponse.getEmail());
                userRealm.setName(userResponse.getName());
                userRealm.setUserPhone(userResponse.getPhone());
                userRealm.setUserWebsite(userResponse.getWebsite());
                userRealm.setCatchPhrases(userResponse.getCompany().getCatchPhrase());
                userRealm.setCity(userResponse.getAddress().getCity());
                userRealm.setStreet(userResponse.getAddress().getStreet());
                userRealm.setSuite(userResponse.getAddress().getSuite());
                userRealm.setLat(userResponse.getAddress().getGeo().getLat());
                userRealm.setLng(userResponse.getAddress().getGeo().getLng());
            }
        });
        realm.close();
        return listUsers;

    }

    private List<User> findAllInDB(Realm realm) {
        List<RealmUser> realmUser = realm.where(RealmUser.class).findAll();
        List<User> list = new ArrayList<>();
        for (int i = 0; i < realmUser.size(); i++) {
            User user = new User();
            Company company = new Company();
            Address address = new Address();
            Geo geo = new Geo();
            user.setId(realmUser.get(i).getId());
            user.setName(realmUser.get(i).getName());
            user.setEmail(realmUser.get(i).getEmail());
            user.setWebsite(realmUser.get(i).getUserWebsite());
            company.setCatchPhrase(realmUser.get(i).getCatchPhrases());
            user.setCompany(company);
            geo.setLat(realmUser.get(i).getLat());
            geo.setLng(realmUser.get(i).getLng());
            address.setGeo(geo);
            address.setCity(realmUser.get(i).getCity());
            address.setStreet(realmUser.get(i).getStreet());
            address.setSuite(realmUser.get(i).getSuite());
            user.setAddress(address);
            list.add(user);
        }
        return list;
    }

    private List<User> readAllFromDB(List<User> issueResponses) {
        return findAllInDB(Realm.getDefaultInstance());
    }

}





