package com.khieuthichien.thibanglaixemay.ui;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.khieuthichien.thibanglaixemay.R;

public class TSHdeso1Activity extends AppCompatActivity {

    private Toolbar toolbar;
    private ImageView imgback;
    private CountDownTimer countDownTimer;
    private TextView tvtimer;

    private boolean showRusult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tshdeso1);

        tvtimer = findViewById(R.id.tvtimer);

        toolbar = findViewById(R.id.toolbar);

        imgback = findViewById(R.id.imgback);
        imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TSHdeso1Activity.this, ThisathachActivity.class));
                finish();
            }
        });

    }




}
