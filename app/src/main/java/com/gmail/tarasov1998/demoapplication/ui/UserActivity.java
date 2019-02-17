package com.gmail.tarasov1998.demoapplication.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.gmail.tarasov1998.demoapplication.R;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserActivity extends AppCompatActivity implements View.OnClickListener, OnMapReadyCallback {
    private String userName, userEmail, userPhone, userWebsite;
    private Double lat, lng;

    @BindView(R.id.user_name)
    TextView name;
    @BindView(R.id.phone)
    TextView phone;
    @BindView(R.id.e_mail)
    TextView email;
    @BindView(R.id.webView)
    WebView webView;

    SupportMapFragment mapFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if (extras != null) {
            userName = extras.getString("userName");
            userEmail =  "Email: " + extras.getString("email");
            userPhone =  "Phone: " + extras.getString("phone");
            userWebsite = extras.getString("website");
            lat = extras.getDouble("lat");
            lng = extras.getDouble("lng");

        }

        name.setText(userName);
        phone.setText(userPhone);
        email.setText(userEmail);

        phone.setOnClickListener(this);
        email.setOnClickListener(this);


        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(userWebsite);

        mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(this);
        }

    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.e_mail:
                intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:" + userEmail));
                startActivity(Intent.createChooser(intent, "Send feedback"));
                break;
            case R.id.phone:
                intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + userPhone));
                startActivity(intent);
                break;

        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(lat, lng))
                .title("Marker"));

    }
}
