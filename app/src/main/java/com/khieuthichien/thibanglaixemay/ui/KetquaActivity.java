package com.khieuthichien.thibanglaixemay.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.khieuthichien.thibanglaixemay.R;
import com.khieuthichien.thibanglaixemay.model.QuestionTSH;

import java.util.ArrayList;

public class KetquaActivity extends AppCompatActivity {

    ArrayList<QuestionTSH> questionTSHArrayList = new ArrayList<>();

    int numNoAns=0;
    int numTrue=0;
    int numFalse=0;

    private TextView tvCaudung;
    private TextView tvCausai;
    private TextView tvCauchuatraloi;
    private TextView tvTongdiem;
    private TextView tvKetquacuoicung;
    private Button btnThilai;
    private Button btnThoat;
    private Button btnLuuketqua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ketqua);

        begin();

        Intent intent = getIntent();
        questionTSHArrayList = (ArrayList<QuestionTSH>) intent.getExtras().getSerializable("arr_Ques");

        checkResult();
        tvCauchuatraloi.setText(""+numNoAns);
        tvCausai.setText(""+numFalse);
        tvCaudung.setText(""+numTrue);
        tvTongdiem.setText(""+numTrue*1+"/20");

        if( numTrue*1 >= 16){
            tvKetquacuoicung.setText("Đạt");
        }else{
            tvKetquacuoicung.setText("Trượt");
        }


        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(KetquaActivity.this);
                builder.setIcon(R.drawable.ic_error_outline_black_24dp);
                builder.setTitle("Thông báo");
                builder.setMessage("Bạn có muốn thoát hay không");
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });

                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //to do
                    }
                });

                builder.show();

            }
        });

    }

    private void begin() {
        tvCaudung = findViewById(R.id.tvCaudung);
        tvCausai = findViewById(R.id.tvCausai);
        tvCauchuatraloi = findViewById(R.id.tvCauchuatraloi);
        tvTongdiem = findViewById(R.id.tvTongdiem);
        tvKetquacuoicung = findViewById(R.id.tvKetquacuoicung);
        btnThilai = findViewById(R.id.btnThilai);
        btnThoat = findViewById(R.id.btnThoat);
        btnLuuketqua = findViewById(R.id.btnLuuketqua);
    }

    //Phương thức Check kết quả
    public void checkResult(){
        for (int i = 0; i < questionTSHArrayList.size(); i++) {
            if (questionTSHArrayList.get(i).getTraloi().equals("") == true){
                numNoAns++;
            }else if (questionTSHArrayList.get(i).getResult().equals(questionTSHArrayList.get(i).getTraloi()) == true){
                numTrue++;
            }else {
                numFalse++;
            }
        }
    }




}
