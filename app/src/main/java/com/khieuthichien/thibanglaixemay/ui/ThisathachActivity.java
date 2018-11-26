package com.khieuthichien.thibanglaixemay.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.github.lzyzsd.circleprogress.ArcProgress;
import com.khieuthichien.thibanglaixemay.QuytacthiActivity;
import com.khieuthichien.thibanglaixemay.R;
import com.khieuthichien.thibanglaixemay.adapter.ThisathachAdapter;
import com.khieuthichien.thibanglaixemay.model.Thisathach;

import java.util.ArrayList;
import java.util.List;


public class ThisathachActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ImageView imgback;
    private RecyclerView recycler;

    private List<Thisathach> thisathachList;
    private ThisathachAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thisathach);

        toolbar = findViewById(R.id.toolbar);
        imgback = findViewById(R.id.imgback);
        recycler = findViewById(R.id.recycler);

        thisathachList = new ArrayList<>();

        imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), QuytacthiActivity.class));
                finish();
            }
        });

        thisathachList.add(new Thisathach("Đề 1", R.drawable.ic_keyboard_arrow_right_black_24dp));
        thisathachList.add(new Thisathach("Đề 2", R.drawable.ic_keyboard_arrow_right_black_24dp));
        thisathachList.add(new Thisathach("Đề 3", R.drawable.ic_keyboard_arrow_right_black_24dp));
        thisathachList.add(new Thisathach("Đề 4", R.drawable.ic_keyboard_arrow_right_black_24dp));
        thisathachList.add(new Thisathach("Đề 5", R.drawable.ic_keyboard_arrow_right_black_24dp));
        thisathachList.add(new Thisathach("Đề 6", R.drawable.ic_keyboard_arrow_right_black_24dp));
        thisathachList.add(new Thisathach("Đề 7", R.drawable.ic_keyboard_arrow_right_black_24dp));
        thisathachList.add(new Thisathach("Đề 8", R.drawable.ic_keyboard_arrow_right_black_24dp));

        adapter = new ThisathachAdapter(thisathachList, this);
        recycler.setAdapter(adapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(layoutManager);


    }

}
