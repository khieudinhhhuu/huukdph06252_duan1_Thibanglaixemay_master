package com.khieuthichien.thibanglaixemay.ui;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.widget.Toast;

import com.khieuthichien.thibanglaixemay.R;
import com.khieuthichien.thibanglaixemay.database.DatabaseHelper;

import java.io.IOException;
import java.security.MessageDigest;
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
        } catch (IOException e) {
            e.printStackTrace();
        }

        printHashKey(MainActivity.this);

    }

    public static void printHashKey(Context context) {
        try {
            final PackageInfo info = context.getPackageManager().getPackageInfo(context.getPackageName(), PackageManager.GET_SIGNATURES);
            for (android.content.pm.Signature signature : info.signatures) {
                final MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                final String hashKey = new String(Base64.encode(md.digest(), 0));
                Log.i("AppLog", "key:" + hashKey + "=");
            }
        } catch (Exception e) {
            Log.e("AppLog", "error:", e);
        }
    }




}
