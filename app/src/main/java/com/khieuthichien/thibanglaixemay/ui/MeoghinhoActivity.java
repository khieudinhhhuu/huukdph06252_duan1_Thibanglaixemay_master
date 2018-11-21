package com.khieuthichien.thibanglaixemay.ui;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.khieuthichien.thibanglaixemay.R;
import com.khieuthichien.thibanglaixemay.adapter.MeoghinhoAdapter;

public class MeoghinhoActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ImageView imgback;
    private TabLayout tablayout;
    private ViewPager viewpager;
    private MeoghinhoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meoghinho);

        toolbar = findViewById(R.id.toolbar);
        imgback = findViewById(R.id.imgback);

        tablayout = findViewById(R.id.tablayout);
        viewpager = findViewById(R.id.viewpager);

        adapter = new MeoghinhoAdapter(getSupportFragmentManager());
        viewpager.setAdapter(adapter);

        tablayout.setupWithViewPager(viewpager);

        imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MeoghinhoActivity.this, MenuActivity.class));
                finish();
            }
        });



    }
}
