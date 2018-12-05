package com.khieuthichien.thibanglaixemay.fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
    RadioGroup radioGroup;
    RadioButton radA, radB, radC, radD;
    ImageView imgIcon;

//    private CheckBox cb1;
//    private CheckBox cb2;
//    private CheckBox cb3;
//    private CheckBox cb4;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_thisathach_slide_page, container, false);

        tvNum = rootView.findViewById(R.id.tvNum);
        tvQuestion = rootView.findViewById(R.id.tvQuestion);
        imgIcon = rootView.findViewById(R.id.imgIcon);
        radioGroup = rootView.findViewById(R.id.radGroup);
        radA = rootView.findViewById(R.id.radA);
        radB = rootView.findViewById(R.id.radB);
        radC = rootView.findViewById(R.id.radC);
        radD = rootView.findViewById(R.id.radD);

//        cb1 = rootView.findViewById(R.id.cb1);
//        cb2 = rootView.findViewById(R.id.cb2);
//        cb3 = rootView.findViewById(R.id.cb3);
//        cb4 = rootView.findViewById(R.id.cb4);

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

        radA.setText(arr_Ques.get(mPageNumber).getAnswer_a());
        radB.setText(arr_Ques.get(mPageNumber).getAnswer_b());
        radC.setText(arr_Ques.get(mPageNumber).getAnswer_c());
        radD.setText(arr_Ques.get(mPageNumber).getAnswer_d());

        //imgIcon.setImageResource(R.drawable.img_1);
        Glide.with(getActivity())
                .load(arr_Ques.get(mPageNumber).getImage())
                .into(imgIcon);

        if (checkAns != 0) {
            radA.setClickable(false);
            radB.setClickable(false);
            radC.setClickable(false);
            radD.setClickable(false);
            getCheckAns(arr_Ques.get(mPageNumber).getResult().toString());
        }

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                getItem(mPageNumber).choiceID = checkedId;
                getItem(mPageNumber).setTraloi(getChoiceFromID(checkedId));
            }
        });

    }

    public QuestionTSH getItem(int position) {
        return arr_Ques.get(position);
    }

    //Lấy giá trị (vị trí) radiogroup chuyển thành đáp án A/B/C/D
    private String getChoiceFromID(int ID) {
        if (ID == R.id.radA) {
            return "A";
        } else if (ID == R.id.radB) {
            return "B";
        } else if (ID == R.id.radC) {
            return "C";
        } else if (ID == R.id.radD) {
            return "D";
        } else if (ID == R.id.radA && ID == R.id.radB) {
            return "AB";
        } else if (ID == R.id.radA && ID == R.id.radC) {
            return "AC";
        } else if (ID == R.id.radA && ID == R.id.radD) {
            return "AD";
        } else if (ID == R.id.radC && ID == R.id.radB) {
            return "BC";
        } else if (ID == R.id.radD && ID == R.id.radB) {
            return "BD";
        } else if (ID == R.id.radC && ID == R.id.radD) {
            return "CD";
        } else return "";
    }

    //Hàm kiểm tra câu đúng, nếu câu đúng thì đổi màu background radiobutton tương ứng
    private void getCheckAns(String ans) {
        if (ans.equals("A") == true) {
            radA.setBackgroundColor(Color.YELLOW);
        } else if (ans.equals("B") == true) {
            radB.setBackgroundColor(Color.YELLOW);
        } else if (ans.equals("C") == true) {
            radC.setBackgroundColor(Color.YELLOW);
        } else if (ans.equals("D") == true) {
            radD.setBackgroundColor(Color.YELLOW);
        } else if (ans.equals("AB") == true) {
            radA.setBackgroundColor(Color.YELLOW);
            radB.setBackgroundColor(Color.YELLOW);
        } else if (ans.equals("AC") == true) {
            radA.setBackgroundColor(Color.YELLOW);
            radC.setBackgroundColor(Color.YELLOW);
        } else if (ans.equals("AD") == true) {
            radA.setBackgroundColor(Color.YELLOW);
            radD.setBackgroundColor(Color.YELLOW);
        } else if (ans.equals("BC") == true) {
            radB.setBackgroundColor(Color.YELLOW);
            radC.setBackgroundColor(Color.YELLOW);
        } else if (ans.equals("BA") == true) {
            radA.setBackgroundColor(Color.YELLOW);
            radB.setBackgroundColor(Color.YELLOW);
        } else if (ans.equals("BD") == true) {
            radD.setBackgroundColor(Color.YELLOW);
            radB.setBackgroundColor(Color.YELLOW);
        } else if (ans.equals("CA") == true) {
            radA.setBackgroundColor(Color.YELLOW);
            radC.setBackgroundColor(Color.YELLOW);
        } else if (ans.equals("CB") == true) {
            radC.setBackgroundColor(Color.YELLOW);
            radB.setBackgroundColor(Color.YELLOW);
        } else if (ans.equals("CD") == true) {
            radC.setBackgroundColor(Color.YELLOW);
            radD.setBackgroundColor(Color.YELLOW);
        } else ;
    }


}
