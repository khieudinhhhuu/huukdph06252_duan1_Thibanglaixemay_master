package com.khieuthichien.thibanglaixemay.fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.khieuthichien.thibanglaixemay.R;
import com.khieuthichien.thibanglaixemay.model.QuestionTSH;
import com.khieuthichien.thibanglaixemay.ui.TSHdethiActivity;

import java.util.ArrayList;

public class ThisathachSlidePageFragment extends Fragment {

    ArrayList<QuestionTSH> arr_Ques;
    public static final String ARG_PAGE = "page";
    public static final String ARG_CHECKANSWER = "checkAnswer";
    public int mPageNumber; //vi tri trang hien tai
    public int checkAns;    //biến kiểm tra

    TextView tvNum;
    TextView tvQuestion;
    ImageView imgIcon;
    private CheckBox cb1;
    private CheckBox cb2;
    private CheckBox cb3;
    private CheckBox cb4;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_thisathach_slide_page, container, false);

        tvNum = rootView.findViewById(R.id.tvNum);
        tvQuestion = rootView.findViewById(R.id.tvQuestion);
        imgIcon = rootView.findViewById(R.id.imgIcon);
        cb1 = rootView.findViewById(R.id.cb1);
        cb2 = rootView.findViewById(R.id.cb2);
        cb3 = rootView.findViewById(R.id.cb3);
        cb4 = rootView.findViewById(R.id.cb4);

        return rootView;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //lay data ben activity
        arr_Ques = new ArrayList<>();
        TSHdethiActivity TSHdethiActivity = (TSHdethiActivity) getActivity();
        arr_Ques = TSHdethiActivity.getData();

        //lay ve
        mPageNumber = getArguments().getInt(ARG_PAGE);
        checkAns = getArguments().getInt(ARG_CHECKANSWER);

    }

    public static ThisathachSlidePageFragment create(int pageNumber, int checkAnswer) {
        ThisathachSlidePageFragment fragment = new ThisathachSlidePageFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_PAGE, pageNumber);
        bundle.putInt(ARG_CHECKANSWER, checkAnswer);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        tvNum.setText("Câu " + (mPageNumber + 1) + "/19");
        tvQuestion.setText(arr_Ques.get(mPageNumber).getQuestion2());

        cb1.setText(arr_Ques.get(mPageNumber).getAnswer_a());
        cb2.setText(arr_Ques.get(mPageNumber).getAnswer_b());
        cb3.setText(arr_Ques.get(mPageNumber).getAnswer_c());
        cb4.setText(arr_Ques.get(mPageNumber).getAnswer_d());

        Glide.with(ThisathachSlidePageFragment.this)
                .load(arr_Ques.get(mPageNumber).getImage())
                .into(imgIcon);

        Log.e("anh", arr_Ques.get(mPageNumber).getImage());

        if (checkAns != 0){
            cb1.setClickable(false);
            cb2.setClickable(false);
            cb3.setClickable(false);
            cb4.setClickable(false);
            getCheckAns(arr_Ques.get(mPageNumber).getResult().toString());
        }

        cb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                arr_Ques.get(mPageNumber).setTraloi(getChoiceFromID1(isChecked));
            }
        });
        cb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                arr_Ques.get(mPageNumber).setTraloi(getChoiceFromID2(isChecked));
            }
        });
        cb3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                arr_Ques.get(mPageNumber).setTraloi(getChoiceFromID3(isChecked));
            }
        });
        cb4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                arr_Ques.get(mPageNumber).setTraloi(getChoiceFromID4(isChecked));
            }
        });


    }


    //Lấy giá trị (vị trí) checkbox chuyển thành đáp án A/B/C/D
    private String getChoiceFromID1(boolean ID) {
        if (ID == true) {
            return "A";
        }  else return "";
    }
    private String getChoiceFromID2(boolean ID) {
        if (ID == true) {
            return "B";
        } else return "";
    }
    private String getChoiceFromID3(boolean ID) {
        if (ID == true) {
            return "C";
        }  else return "";
    }
    private String getChoiceFromID4(boolean ID) {
        if (ID == true) {
            return "D";
        } else return "";
    }

    //Hàm kiểm tra câu đúng, nếu câu đúng thì đổi màu background checkbox tương ứng
    private void getCheckAns(String ans){
        if ( ans.equals("A") == true){
            cb1.setBackgroundColor(Color.YELLOW);
        }else if ( ans.equals("B") == true){
            cb2.setBackgroundColor(Color.YELLOW);
        }else if ( ans.equals("C") == true){
            cb3.setBackgroundColor(Color.YELLOW);
        }else if ( ans.equals("D") == true){
            cb4.setBackgroundColor(Color.YELLOW);
        }else if ( ans.equals("AB") == true){
            cb1.setBackgroundColor(Color.YELLOW);
            cb2.setBackgroundColor(Color.YELLOW);
        }else if ( ans.equals("AC") == true){
            cb1.setBackgroundColor(Color.YELLOW);
            cb3.setBackgroundColor(Color.YELLOW);
        }else if ( ans.equals("AD") == true){
            cb1.setBackgroundColor(Color.YELLOW);
            cb4.setBackgroundColor(Color.YELLOW);
        }else if ( ans.equals("BC") == true){
            cb2.setBackgroundColor(Color.YELLOW);
            cb3.setBackgroundColor(Color.YELLOW);
        }else if ( ans.equals("BD") == true){
            cb4.setBackgroundColor(Color.YELLOW);
            cb2.setBackgroundColor(Color.YELLOW);
        }else if ( ans.equals("CD") == true){
            cb3.setBackgroundColor(Color.YELLOW);
            cb4.setBackgroundColor(Color.YELLOW);
        }else ;
    }


}
