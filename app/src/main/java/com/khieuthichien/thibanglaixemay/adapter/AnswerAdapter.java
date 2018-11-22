package com.khieuthichien.thibanglaixemay.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.khieuthichien.thibanglaixemay.R;
import com.khieuthichien.thibanglaixemay.model.Answer;

import java.util.ArrayList;
import java.util.List;

public class AnswerAdapter extends ArrayAdapter<Answer> {

    private ArrayList<Answer> myArray;
    private Drawable drawable;

    public AnswerAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Answer> objects, Drawable drawable) {
        super(context, resource, objects);
        this.myArray = objects;
        this.drawable = drawable;
    }

    public AnswerAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Answer> objects) {
        super(context, resource, objects);
        this.myArray = objects;
    }



    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View view = inflater.inflate(R.layout.item_hlt_learn,parent,false);
        CheckBox cbchon = view.findViewById(R.id.cbchon);
        TextView tvlearnNoidung = view.findViewById(R.id.tvlearnNoidung);
        // set view
        final Answer row = getMyArray().get(position);
        tvlearnNoidung.setText(row.getText());
        // Doi mau button binh thuong
        cbchon.setBackgroundResource(row.isBit()?R.color.colorAccent:R.color.white);
//        // Thay bang dau tich
//        if (row.isBit())
//            btn.setBackground(drawable);
//        else
//            btn.setBackgroundResource(R.color.white);
        // hien thi dap an dung cua he thong
        if (row.isColorBackground()) view.setBackgroundResource(R.color.colorPrimaryDark);
        return view;
    }

    public ArrayList<Answer> getMyArray() {
        return myArray;
    }

}
