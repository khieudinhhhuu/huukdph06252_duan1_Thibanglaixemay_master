package com.khieuthichien.thibanglaixemay.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.khieuthichien.thibanglaixemay.R;
import com.khieuthichien.thibanglaixemay.ui.MenuActivity;
import com.khieuthichien.thibanglaixemay.ui.ThisathachActivity;

public class QuytacthiActivity extends AppCompatActivity {

    private Button contestWelcomeBtnStart;
    private Toolbar toolbar;
    private ImageView imgback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quytacthi);

        toolbar = findViewById(R.id.toolbar);
        imgback = findViewById(R.id.imgback);

        imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MenuActivity.class));
                finish();
            }
        });

        contestWelcomeBtnStart = findViewById(R.id.contest_welcome_btnStart);

        contestWelcomeBtnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ThisathachActivity.class));
            }
        });

    }
}
