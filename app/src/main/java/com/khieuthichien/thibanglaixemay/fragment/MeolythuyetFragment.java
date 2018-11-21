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

public class MeolythuyetFragment extends Fragment{

    private ExpandableRelativeLayout expandableLayout1, expandableLayout2, expandableLayout3;

    private Button expandableButton1;
    private Button expandableButton2;
    private Button expandableButton3;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_meolythuyet, container, false);

        expandableButton1 = view.findViewById(R.id.expandableButton1);
        expandableButton2 = view.findViewById(R.id.expandableButton2);
        expandableButton3 = view.findViewById(R.id.expandableButton3);

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

        return view;

    }

}
