package com.khieuthichien.thibanglaixemay.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.khieuthichien.thibanglaixemay.R;
import com.khieuthichien.thibanglaixemay.adapter.HoclythuyetAdapter;
import com.khieuthichien.thibanglaixemay.model.Hoclythuyet;

import java.util.ArrayList;
import java.util.List;

public class HoclythuyetActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ImageView imgback;
    private RecyclerView recyclerview;

    private List<Hoclythuyet> hoclythuyetList;
    private HoclythuyetAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoclythuyet);

        toolbar = findViewById(R.id.toolbar);
        imgback = findViewById(R.id.imgback);
        recyclerview = findViewById(R.id.recyclerview);

        imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HoclythuyetActivity.this, MenuActivity.class));
                finish();
            }
        });

        hoclythuyetList = new ArrayList<>();

        hoclythuyetList.add(new Hoclythuyet(R.drawable.khainiem, "Khái niệm và quy tắc", "(75 câu)"));
        hoclythuyetList.add(new Hoclythuyet(R.drawable.vanhoa, "Văn hóa và đạo đức lái xe", "(5 câu)"));
        hoclythuyetList.add(new Hoclythuyet(R.drawable.duongbo, "Hệ thống biển báo đường bộ", "(36 câu)"));
        hoclythuyetList.add(new Hoclythuyet(R.drawable.sahinh, "Sa hình", "(34 câu)"));

        adapter = new HoclythuyetAdapter(this, hoclythuyetList);
        recyclerview.setAdapter(adapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerview.setLayoutManager(layoutManager);

    }
}
