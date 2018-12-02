package com.khieuthichien.thibanglaixemay.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.khieuthichien.thibanglaixemay.R;
import com.khieuthichien.thibanglaixemay.database.DatabaseHelper;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), MenuActivity.class));

                finish();
            }
        }, 2000);


        DatabaseHelper db = new DatabaseHelper(this);
//        db.deleteDataBase();
//        Toast.makeText(this, "Xóa thành công", Toast.LENGTH_SHORT).show();
        try {
            db.createDataBase();
            Toast.makeText(this, "Cap nhat thanh cong", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
