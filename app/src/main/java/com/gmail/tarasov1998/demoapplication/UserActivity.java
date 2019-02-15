package com.gmail.tarasov1998.demoapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserActivity extends AppCompatActivity {
    private String userName;
    private String userEmail;
    private String userPhone;
    private String userWebsite;

    @BindView(R.id.user_name)
    TextView name;
    @BindView(R.id.phone)
    TextView phone;
    @BindView(R.id.e_mail)
    TextView email;
    @BindView(R.id.webView)
    WebView webView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if (extras != null) {
            userName = extras.getString("name");
           /* userEmail = extras.getString("email");
            userPhone = extras.getString("phone");
            userWebsite = extras.getString("website");*/
        }

        name.setText(userName);
        phone.setText(userPhone);
        email.setText(userEmail);


        webView.setWebViewClient(new WebViewClient());
        Uri data = null;
        webView.loadUrl(data.toString());
    }
}
