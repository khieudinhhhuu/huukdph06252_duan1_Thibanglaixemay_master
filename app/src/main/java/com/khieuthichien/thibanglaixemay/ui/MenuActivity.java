package com.khieuthichien.thibanglaixemay.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.facebook.share.model.ShareHashtag;
import com.facebook.share.model.ShareLinkContent;
import com.khieuthichien.thibanglaixemay.R;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class MenuActivity extends AppCompatActivity {

    private ImageView imgthisathach;
    private ImageView imghoclythuyet;
    private ImageView imgcacbienbao;
    private ImageView imgmeoghinho;
    private ImageView imgchiaseungdung;
    private ImageView imggioithieu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        imgthisathach = findViewById(R.id.imgthisathach);
        imghoclythuyet = findViewById(R.id.imghoclythuyet);
        imgcacbienbao = findViewById(R.id.imgcacbienbao);
        imgmeoghinho = findViewById(R.id.imgmeoghinho);
        imgchiaseungdung = findViewById(R.id.imgchiaseungdung);
        imggioithieu = findViewById(R.id.imggioithieu);

        imgthisathach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, ThisathachActivity.class));
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

                ShareLinkContent content = new ShareLinkContent.Builder()
                        .setContentUrl(Uri.parse("https://developers.facebook.com"))
                        .build();

                ShareLinkContent.Builder content1 = new ShareLinkContent.Builder()
                        .setContentUrl(Uri.parse("https://developers.facebook.com"))
                        .setShareHashtag(new ShareHashtag.Builder()
                                .setHashtag("#ConnectTheWorld")
                                .build());



                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                Uri screenshotUri = Uri.parse("android.resource://comexample.sairamkrishna.myapplication/*");

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
}
