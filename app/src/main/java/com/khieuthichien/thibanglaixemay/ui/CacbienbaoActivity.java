package com.khieuthichien.thibanglaixemay.ui;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.khieuthichien.thibanglaixemay.R;
import com.khieuthichien.thibanglaixemay.adapter.CacbienbaoAdapter2;

public class CacbienbaoActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ImageView imgback;
    private TabLayout tablayout;
    private ViewPager viewpager;
    private CacbienbaoAdapter2 adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cacbienbao);

        toolbar = findViewById(R.id.toolbar);
        imgback = findViewById(R.id.imgback);

        imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CacbienbaoActivity.this, MenuActivity.class));
                finish();
            }
        });

        tablayout = findViewById(R.id.tablayout);
        viewpager = findViewById(R.id.viewpager);

        adapter = new CacbienbaoAdapter2(getSupportFragmentManager());
        viewpager.setAdapter(adapter);

        tablayout.setupWithViewPager(viewpager);

        Toast.makeText(this, "Yêu cầu mạng cho lần load ảnh đầu tiên về app", Toast.LENGTH_SHORT).show();
    }
}
