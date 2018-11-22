package com.khieuthichien.thibanglaixemay.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.khieuthichien.thibanglaixemay.ui.HLThethongbienbaoduongboActivity;
import com.khieuthichien.thibanglaixemay.ui.HLTkhainiemvaquytacActivity;
import com.khieuthichien.thibanglaixemay.ui.HLTsahinhActivity;
import com.khieuthichien.thibanglaixemay.ui.HLTvanhoadaoduclaixeActivity;
import com.khieuthichien.thibanglaixemay.R;
import com.khieuthichien.thibanglaixemay.model.Hoclythuyet;

import java.util.List;

public class HoclythuyetAdapter extends RecyclerView.Adapter<HoclythuyetAdapter.HoclythuyetHolder> {

    Context context;
    List<Hoclythuyet> hoclythuyetList;

    public HoclythuyetAdapter(Context context, List<Hoclythuyet> hoclythuyetList) {
        this.context = context;
        this.hoclythuyetList = hoclythuyetList;
    }

    @NonNull
    @Override
    public HoclythuyetHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_hoclythuyet, parent, false);
        return new HoclythuyetHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final HoclythuyetHolder holder, int position) {
        final Hoclythuyet hoclythuyet = hoclythuyetList.get(position);
        holder.imganhhoclythuyet.setImageResource(hoclythuyet.getAnhhoclythuyet());
        holder.tvtieudehoclythuyet.setText(hoclythuyet.getTieudehoclythuyet());
        holder.tvsocauhoclythuyet.setText(hoclythuyet.getSocauhoclythuyet());

        holder.cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(holder.tvtieudehoclythuyet.getText().toString().equals("Khái niệm và quy tắc")){
                    Intent intent = new Intent(context, HLTkhainiemvaquytacActivity.class);
                    intent.putExtra("begin","0");
                    intent.putExtra("end","74");
                    context.startActivity(intent);
                }
                if(holder.tvtieudehoclythuyet.getText().toString().equals("Hệ thống biển báo đường bộ")){
                    Intent intent = new Intent(context, HLThethongbienbaoduongboActivity.class);
                    intent.putExtra("begin","75");
                    intent.putExtra("end","79");
                    context.startActivity(intent);
                }
                if(holder.tvtieudehoclythuyet.getText().toString().equals("Sa hình")){
                    Intent intent = new Intent(context, HLTsahinhActivity.class);
                    intent.putExtra("begin","80");
                    intent.putExtra("end","115");
                    context.startActivity(intent);
                }
                if(holder.tvtieudehoclythuyet.getText().toString().equals("Văn hóa và đạo đức lái xe")){
                    Intent intent = new Intent(context, HLTvanhoadaoduclaixeActivity.class);
                    intent.putExtra("begin","116");
                    intent.putExtra("end","149");
                    context.startActivity(intent);
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        if (hoclythuyetList == null){
            return 0;
        }
        return hoclythuyetList.size();
    }

    public class HoclythuyetHolder extends RecyclerView.ViewHolder {

        private CardView cardview;
        public final ImageView imganhhoclythuyet;
        public final TextView tvtieudehoclythuyet;
        public final TextView tvsocauhoclythuyet;

        public HoclythuyetHolder(View itemView) {
            super(itemView);

            cardview = itemView.findViewById(R.id.cardview);
            imganhhoclythuyet = itemView.findViewById(R.id.imganhhoclythuyet);
            tvtieudehoclythuyet = itemView.findViewById(R.id.tvtieudehoclythuyet);
            tvsocauhoclythuyet = itemView.findViewById(R.id.tvsocauhoclythuyet);

        }
    }
}
