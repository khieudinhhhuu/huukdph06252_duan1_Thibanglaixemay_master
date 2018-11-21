package com.khieuthichien.thibanglaixemay.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.github.aakira.expandablelayout.ExpandableRelativeLayout;
import com.khieuthichien.thibanglaixemay.R;

public class MeothuchanhFragment extends Fragment{

    private Button expandableButton1;
    private Button expandableButton2;
    private Button expandableButton3;
    private Button expandableButton4;
    private Button expandableButton5;

    private ExpandableRelativeLayout expandableLayout1;
    private ExpandableRelativeLayout expandableLayout2;
    private ExpandableRelativeLayout expandableLayout3;
    private ExpandableRelativeLayout expandableLayout4;
    private ExpandableRelativeLayout expandableLayout5;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_meothuchanh, container, false);

        expandableButton1 = view.findViewById(R.id.expandableButton1);
        expandableButton2 = view.findViewById(R.id.expandableButton2);
        expandableButton3 = view.findViewById(R.id.expandableButton3);
        expandableButton4 = view.findViewById(R.id.expandableButton4);
        expandableButton5 = view.findViewById(R.id.expandableButton5);

        expandableButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expandableLayout1 = view.findViewById(R.id.expandableLayout1);
                expandableLayout1.toggle();
            }
        });

        expandableButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expandableLayout2 = view.findViewById(R.id.expandableLayout2);
                expandableLayout2.toggle();
            }
        });

        expandableButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expandableLayout3 = view.findViewById(R.id.expandableLayout3);
                expandableLayout3.toggle();
            }
        });

        expandableButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expandableLayout4 = view.findViewById(R.id.expandableLayout4);
                expandableLayout4.toggle();
            }
        });

        expandableButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expandableLayout5 = view.findViewById(R.id.expandableLayout5);
                expandableLayout5.toggle();
            }
        });

        return view;
    }
}
