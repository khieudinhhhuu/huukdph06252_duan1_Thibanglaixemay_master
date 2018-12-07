package com.khieuthichien.thibanglaixemay.ui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.view.View;
import android.widget.ImageView;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.facebook.share.model.ShareLinkContent;
import com.khieuthichien.thibanglaixemay.R;


import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Arrays;

public class MenuActivity extends AppCompatActivity {

    private ImageView imgthisathach;
    private ImageView imghoclythuyet;
    private ImageView imgcacbienbao;
    private ImageView imgmeoghinho;
    private ImageView imgchiaseungdung;
    private ImageView imggioithieu;
    private CallbackManager callbackManager;
    private LoginButton loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);

        //logger.logPurchase(BigDecimal.valueOf(4.32), Currency.getInstance("USD"));

        callbackManager = CallbackManager.Factory.create();

        loginButton = findViewById(R.id.login_button);
        loginButton.setReadPermissions("email");
        // If using in a fragment
        //loginButton.setFragment(this);

        // Callback registration
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                // App code
            }

            @Override
            public void onCancel() {
                // App code
            }

            @Override
            public void onError(FacebookException exception) {
                // App code
            }
        });

        LoginManager.getInstance().registerCallback(callbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        // App code
                    }

                    @Override
                    public void onCancel() {
                        // App code
                    }

                    @Override
                    public void onError(FacebookException exception) {
                        // App code
                    }
                });

        AccessToken accessToken = AccessToken.getCurrentAccessToken();
        boolean isLoggedIn = accessToken != null && !accessToken.isExpired();
        LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("public_profile"));


        imgthisathach = findViewById(R.id.imgthisathach);
        imghoclythuyet = findViewById(R.id.imghoclythuyet);
        imgcacbienbao = findViewById(R.id.imgcacbienbao);
        imgmeoghinho = findViewById(R.id.imgmeoghinho);
        imgchiaseungdung = findViewById(R.id.imgchiaseungdung);
        imggioithieu = findViewById(R.id.imggioithieu);

        imgthisathach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, QuytacthiActivity.class));
            }
        });

        imghoclythuyet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, HoclythuyetActivity.class));
            }
        });

        imggioithieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, GioithieuActivity.class));
            }
        });

        imgmeoghinho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, MeoghinhoActivity.class));
            }
        });

        imgcacbienbao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, CacbienbaoActivity.class));
            }
        });

        imgchiaseungdung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                Uri screenshotUri = Uri.parse("android.resource://comexample.sairamkrishna.myapplication/https://play.google.com/store/apps/details?id=com.vietdevpro.onthigiaypheplaixe.xemay");

                try {
                    InputStream stream = getContentResolver().openInputStream(screenshotUri);
                }
                catch (FileNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                sharingIntent.setType("image/jpeg");
                sharingIntent.putExtra(Intent.EXTRA_STREAM, screenshotUri);
                startActivity(Intent.createChooser(sharingIntent, "Chia sẻ ứng dụng"));

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }


}
