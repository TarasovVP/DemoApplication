package com.gmail.tarasov1998.demoapplication.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebSettings;
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


    @SuppressLint("SetJavaScriptEnabled")
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
        }

        name.setText(userName);
        phone.setText(userPhone);
        email.setText(userEmail);

        phone.setOnClickListener(this);
        email.setOnClickListener(this);


        webView.setWebViewClient(new WebViewClient());
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        Uri data = Uri.parse(userWebsite);
        webView.loadUrl(data.toString());
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
}
