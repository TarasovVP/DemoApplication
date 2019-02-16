package com.gmail.tarasov1998.demoapplication.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.gmail.tarasov1998.demoapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserActivity extends AppCompatActivity implements View.OnClickListener {
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
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if (extras != null) {
            userName = extras.getString("userName");
            userEmail = extras.getString("email");
            userPhone = extras.getString("phone");
            userWebsite = extras.getString("website");
        }

        name.setText(userName);
        phone.setText(userPhone);
        email.setText(userEmail);


        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(userWebsite);
    }

    @Override
    public void onClick(View v) {

    }
}
