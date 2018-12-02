package com.khieuthichien.thibanglaixemay.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.SQLException;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.khieuthichien.thibanglaixemay.R;
import com.khieuthichien.thibanglaixemay.adapter.KiemtradapanAdapter;
import com.khieuthichien.thibanglaixemay.dao.ThisathachDAO;
import com.khieuthichien.thibanglaixemay.database.DatabaseHelper;
import com.khieuthichien.thibanglaixemay.fragment.ThisathachSlidePageFragment;
import com.khieuthichien.thibanglaixemay.model.QuestionTSH;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class TSHdethiActivity extends FragmentActivity {

    private static final int NUM_PAGES = 19;
    private ViewPager mPager;
    private PagerAdapter mPagerAdapter;

    public int checkAns = 0;

    //csdl
    ThisathachDAO thisathachDAO;
    ArrayList<QuestionTSH> arr_Ques;

    CounterClass timer;

    String subject;
    int num_exam;
    String test="";

    private TextView tvKiemTra;
    private TextView tvTimer;
    private TextView tvXemDiem;
    private ImageView imgback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tshdethi);

        mPager = findViewById(R.id.pager);

        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);
        mPager.setPageTransformer(true, new ZoomOutPageTransformer());

        Intent intent = getIntent();
        subject = intent.getStringExtra("subject");
        num_exam = intent.getIntExtra("num_exam", 0);
        test= intent.getStringExtra("test");

        thisathachDAO = new ThisathachDAO(this);
        arr_Ques = new ArrayList<QuestionTSH>();

        arr_Ques = thisathachDAO.getQuestion(num_exam, subject);

        timer = new CounterClass(15 * 60 * 1000, 1000);

        tvKiemTra = findViewById(R.id.tvKiemTra);
        tvTimer = findViewById(R.id.tvTimer);
        tvXemDiem = findViewById(R.id.tvScore);
        imgback = findViewById(R.id.imgback);

        imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogExit();
            }
        });

        tvTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        timer.start();

        tvKiemTra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckAnswer();
            }
        });

        tvXemDiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent = new Intent(TSHdethiActivity.this, KetquaActivity.class);
                intent.putExtra("arr_Ques", arr_Ques);
                startActivity(intent);
            }
        });

    }


    public ArrayList<QuestionTSH> getData() {
        return arr_Ques;
    }

    @Override
    public void onBackPressed() {
        if (mPager.getCurrentItem() == 0) {
            dialogExit();
        } else {
            // Otherwise, select the previous step.
            //mPager.setCurrentItem(mPager.getCurrentItem() - 1);
            dialogExit();
        }
    }

    public void dialogExit(){
        final AlertDialog.Builder builder=new AlertDialog.Builder(TSHdethiActivity.this);
        builder.setIcon(R.drawable.ic_error_outline_black_24dp);
        builder.setTitle("Thông báo");
        builder.setMessage("Bạn đang làm bài thi \nBạn có muốn thoát hay không?");
        builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                timer.cancel();
                finish();
            }
        });
        builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        builder.show();
    }


    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return new ThisathachSlidePageFragment().create(position, checkAns);
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }


    public class ZoomOutPageTransformer implements ViewPager.PageTransformer {
        private static final float MIN_SCALE = 0.85f;
        private static final float MIN_ALPHA = 0.5f;

        public void transformPage(View view, float position) {
            int pageWidth = view.getWidth();
            int pageHeight = view.getHeight();

            if (position < -1) { // [-Infinity,-1)
                // This page is way off-screen to the left.
                view.setAlpha(0f);

            } else if (position <= 1) { // [-1,1]
                // Modify the default slide transition to shrink the page as well
                float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
                float vertMargin = pageHeight * (1 - scaleFactor) / 2;
                float horzMargin = pageWidth * (1 - scaleFactor) / 2;
                if (position < 0) {
                    view.setTranslationX(horzMargin - vertMargin / 2);
                } else {
                    view.setTranslationX(-horzMargin + vertMargin / 2);
                }

                // Scale the page down (between MIN_SCALE and 1)
                view.setScaleX(scaleFactor);
                view.setScaleY(scaleFactor);

                // Fade the page relative to its size.
                view.setAlpha(MIN_ALPHA +
                        (scaleFactor - MIN_SCALE) /
                                (1 - MIN_SCALE) * (1 - MIN_ALPHA));

            } else { // (1,+Infinity]
                // This page is way off-screen to the right.
                view.setAlpha(0f);
            }
        }
    }

    public void CheckAnswer() {

        AlertDialog.Builder builder = new AlertDialog.Builder(TSHdethiActivity.this);
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View dialogView = inflater.inflate(R.layout.dialog_kiemtra_dapan, null);
        builder.setView(dialogView);
        builder.setTitle("Danh sách câu trả lời!");
        final Dialog dialog = builder.show();

        KiemtradapanAdapter kiemtradapanAdapter = new KiemtradapanAdapter(arr_Ques, this);

        GridView gvQuestion;
        Button btnCancle;
        Button btnFinish;

        gvQuestion = dialogView.findViewById(R.id.gvQuestion);
        btnCancle = dialogView.findViewById(R.id.btnCancle);
        btnFinish = dialogView.findViewById(R.id.btnFinish);

        gvQuestion.setAdapter(kiemtradapanAdapter);

        gvQuestion.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mPager.setCurrentItem(position);
                dialog.dismiss();
            }
        });

        btnCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.cancel();
                result();
                dialog.dismiss();
            }
        });

        dialog.show();

    }

    public void result() {
        checkAns = 1;
        if (mPager.getCurrentItem() >= 5){
            mPager.setCurrentItem(mPager.getCurrentItem() -4);
        }else if (mPager.getCurrentItem() <= 5){
            mPager.setCurrentItem(mPager.getCurrentItem() +4);
        }
        tvXemDiem.setVisibility(View.VISIBLE);
        tvKiemTra.setVisibility(View.GONE);
    }


    public class CounterClass extends CountDownTimer {

        //millisInFuture: muốn 60giay thì lấy 60*1000
        //countDownInterval: bước nảy từng giây một: 1000
        public CounterClass(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            String countTime = String.format("%02d:%02d", TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished), TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(
                    TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)));
            tvTimer.setText(countTime); //SetText cho textview hiện thị thời gian.
        }

        @Override
        public void onFinish() {
            tvTimer.setText("00:00");  //SetText cho textview hiện thị thời gian.
            timer.cancel();
            result();
        }
    }


}
