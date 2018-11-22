package com.khieuthichien.thibanglaixemay.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.khieuthichien.thibanglaixemay.R;

import java.util.ArrayList;
import java.util.List;

public class HLTkhainiemvaquytacActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ImageView imgback;
    private TextView question;
    private ImageView imageQuestion;
    private ListView lvkhainiemvaquytac;
    private ImageButton btnBack;
    private ImageButton btnCheck;
    private ImageButton btnNext;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hltkhainiemvaquytac);



        toolbar = findViewById(R.id.toolbar);
        imgback = findViewById(R.id.imgback);

        imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HLTkhainiemvaquytacActivity.this, HoclythuyetActivity.class));
                finish();
            }
        });

        question = findViewById(R.id.question);
        imageQuestion = findViewById(R.id.image_question);
        lvkhainiemvaquytac = findViewById(R.id.lvkhainiemvaquytac);
        btnBack = findViewById(R.id.btnBack);
        btnCheck = findViewById(R.id.btnCheck);
        btnNext = findViewById(R.id.btnNext);


    }
}
