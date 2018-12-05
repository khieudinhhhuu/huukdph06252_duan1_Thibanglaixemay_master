package com.khieuthichien.thibanglaixemay.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.khieuthichien.thibanglaixemay.R;
import com.khieuthichien.thibanglaixemay.model.Cacbienbao;

import java.util.List;

public class CacbienbaoAdapter extends RecyclerView.Adapter<CacbienbaoAdapter.CacbienbaoHolder> {

    Context context;
    List<Cacbienbao> cacbienbaoList;

    public CacbienbaoAdapter(Context context, List<Cacbienbao> cacbienbaoList) {
        this.context = context;
        this.cacbienbaoList = cacbienbaoList;
    }

    @NonNull
    @Override
    public CacbienbaoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_cacbienbao, parent, false);
        return new CacbienbaoHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CacbienbaoHolder holder, int position) {
        final Cacbienbao cacbienbao = cacbienbaoList.get(position);
        holder.imganhcacbienbao.setImageResource(R.drawable.cacbienbao);

        Glide.with(context)
                .load(cacbienbao.getAnhcacbienbao())
                .into(holder.imganhcacbienbao);

        holder.tvtieudecacbienbao.setText(cacbienbao.getTieudecacbienbao());
        holder.tvgiaithichcacbienbao.setText(cacbienbao.getGiaithichcacbienbao());
    }

    @Override
    public int getItemCount() {
        if (cacbienbaoList == null){
            return 0;
        }
        return cacbienbaoList.size();
    }

    public class CacbienbaoHolder extends RecyclerView.ViewHolder {

        public final CardView cardview;
        public final ImageView imganhcacbienbao;
        public final TextView tvtieudecacbienbao;
        public final TextView tvgiaithichcacbienbao;

        public CacbienbaoHolder(View itemView) {
            super(itemView);

            cardview = itemView.findViewById(R.id.cardview);
            imganhcacbienbao = itemView.findViewById(R.id.imganhcacbienbao);
            tvtieudecacbienbao = itemView.findViewById(R.id.tvtieudecacbienbao);
            tvgiaithichcacbienbao = itemView.findViewById(R.id.tvgiaithichcacbienbao);

        }
    }
}
