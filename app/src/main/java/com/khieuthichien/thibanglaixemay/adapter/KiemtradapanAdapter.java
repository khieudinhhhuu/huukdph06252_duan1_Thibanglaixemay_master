package com.khieuthichien.thibanglaixemay.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.khieuthichien.thibanglaixemay.R;
import com.khieuthichien.thibanglaixemay.model.QuestionTSH;

import java.util.ArrayList;

public class KiemtradapanAdapter extends BaseAdapter {

    ArrayList listData;
    LayoutInflater inflater;

    public KiemtradapanAdapter(ArrayList listData, Context context) {
        this.listData = listData;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        QuestionTSH questionTSH = (QuestionTSH) getItem(position);
        ViewHolder holder;
        if (convertView == null){
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.item_danhsach_dapan, parent, false);
            holder.tvNumAns = convertView.findViewById(R.id.tvNumAns);
            holder.tvAnswer = convertView.findViewById(R.id.tvAnswer);

            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        int i = position + 1;
        holder.tvNumAns.setText("Câu " + i + ": ");
        holder.tvAnswer.setText(questionTSH.getTraloi());

        return convertView;
    }

    private static class ViewHolder{

        TextView tvNumAns;
        TextView tvAnswer;

    }

}
