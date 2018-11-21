package com.khieuthichien.thibanglaixemay.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.github.lzyzsd.circleprogress.ArcProgress;
import com.khieuthichien.thibanglaixemay.R;


public class ThisathachActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ImageView imgback;
    private ArcProgress arcProgress1;
    private ArcProgress arcProgress2;
    private ArcProgress arcProgress3;
    private ArcProgress arcProgress4;
    private ArcProgress arcProgress5;
    private ArcProgress arcProgress6;
    private ArcProgress arcProgress7;
    private ArcProgress arcProgress8;
    private ArcProgress arcProgresschuy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thisathach);

        toolbar = findViewById(R.id.toolbar);
        imgback = findViewById(R.id.imgback);

        imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ThisathachActivity.this, MenuActivity.class));
                finish();
            }
        });

        arcProgress1 = findViewById(R.id.arc_progress1);
        arcProgress2 = findViewById(R.id.arc_progress2);
        arcProgress3 = findViewById(R.id.arc_progress3);
        arcProgress4 = findViewById(R.id.arc_progress4);
        arcProgress5 = findViewById(R.id.arc_progress5);
        arcProgress6 = findViewById(R.id.arc_progress6);
        arcProgress7 = findViewById(R.id.arc_progress7);
        arcProgress8 = findViewById(R.id.arc_progress8);
        arcProgresschuy = findViewById(R.id.arc_progresschuy);

        arcProgress1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ThisathachActivity.this, TSHdeso1Activity.class));
            }
        });

    }

}
