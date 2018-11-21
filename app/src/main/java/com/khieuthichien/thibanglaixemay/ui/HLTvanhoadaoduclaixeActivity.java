package com.khieuthichien.thibanglaixemay.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.khieuthichien.thibanglaixemay.R;

public class HLTvanhoadaoduclaixeActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ImageView imgback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hltvanhoadaoduclaixe);

        toolbar = findViewById(R.id.toolbar);
        imgback = findViewById(R.id.imgback);

        imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HLTvanhoadaoduclaixeActivity.this, HoclythuyetActivity.class));
                finish();
            }
        });

    }
}
