package com.khieuthichien.thibanglaixemay.ui;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.khieuthichien.thibanglaixemay.R;
import com.khieuthichien.thibanglaixemay.model.Question;
import com.khieuthichien.thibanglaixemay.ui.GioithieuActivity;
import com.khieuthichien.thibanglaixemay.ui.MenuActivity;
import com.khieuthichien.thibanglaixemay.ui.ThisathachActivity;

import java.util.ArrayList;

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

        setTime();

//        countDownTimer = new CountDownTimer(750000, 1000) {
//            @Override
//            public void onTick(long millisUntilFinished) {
//                tvtimer.setText(millisUntilFinished / 1000 + ":");
//            }
//
//            @Override
//            public void onFinish() {
//                tvtimer.setText("over time");
//                Intent intent = new Intent(TSHdeso1Activity.this, ThisathachActivity.class);
//                startActivity(intent);
//            }
//        }.start();


    }

//    @Override
//    public void onBackPressed() {
//        countDownTimer.cancel();
//        finish();
//    }


    private void setTime(){
        AsyncTask<Void, String, Void> asyncTask = new AsyncTask<Void, String, Void>() {

            @Override
            protected Void doInBackground(Void... params) {
                for (int m=14;m>=0;m--){
                    for (int s=59;s>=0;s--){
                        if (!isShowRusult())
                            this.publishProgress((m<10?("0"+m):m) + ":" + (s<10?("0"+s):s));
                        else
                            return null;
                        SystemClock.sleep(1000);
                    }
                }
                return null;
            }

            @Override
            protected void onProgressUpdate(String... values) {
                super.onProgressUpdate(values);
                tvtimer.setText(values[0]);
                if (values[0].equals("00:00")) {

                    final AlertDialog.Builder alertDialog = new AlertDialog.Builder(TSHdeso1Activity.this)
                            .setTitle("Thông báo")
                            .setMessage("Hết giờ làm bài thi !")
                            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    startActivity(new Intent(TSHdeso1Activity.this, ThisathachActivity.class));
                                }
                            });
                    alertDialog.setCancelable(false);
                    alertDialog.show();
                }
            }

        };
        asyncTask.execute();
    }


    public boolean isShowRusult() {
        return showRusult;
    }




}
