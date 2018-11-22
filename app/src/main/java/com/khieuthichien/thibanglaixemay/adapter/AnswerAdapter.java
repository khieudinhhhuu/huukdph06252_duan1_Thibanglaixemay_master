package com.khieuthichien.thibanglaixemay.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.khieuthichien.thibanglaixemay.R;
import com.khieuthichien.thibanglaixemay.model.Answer;

import java.util.List;

public class AnswerAdapter extends ArrayAdapter<Answer> {

    private List<Answer> answerList;
    private Drawable drawable;

    public AnswerAdapter(Context context, int resource, List<Answer> objects) {
        super(context, resource, objects);
        this.answerList = objects;
    }

    public AnswerAdapter(Context context, int resource, List<Answer> objects, Drawable drawable) {
        super(context, resource, objects);
        this.answerList = objects;
        this.drawable = drawable;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = LayoutInflater.from(getContext()).inflate(R.layout.item_listview_hoclythuyet,parent,false);

        Button btnchondapan = view.findViewById(R.id.btnchondapan);
        TextView tvcacdapanluachon = view.findViewById(R.id.tvcacdapanluachon);

        // set view
        final Answer row = getMyArray().get(position);
        tvcacdapanluachon.setText(row.getText());

        // Doi mau button binh thuong
        btnchondapan.setBackgroundResource(row.isBit()?R.color.colorPrimary2:R.color.white);
//        // Thay bang dau tich
//        if (row.isBit())
//            btn.setBackground(drawable);
//        else
//            btn.setBackgroundResource(R.color.white);
        // hien thi dap an dung cua he thong
        if (row.isColorBackground()) view.setBackgroundResource(R.color.colorPrimary3);
        return view;
    }

    public List<Answer> getMyArray() {
        return answerList;
    }

}
