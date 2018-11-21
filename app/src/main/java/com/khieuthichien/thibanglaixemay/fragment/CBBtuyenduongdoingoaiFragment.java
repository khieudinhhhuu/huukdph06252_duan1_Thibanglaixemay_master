package com.khieuthichien.thibanglaixemay.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.khieuthichien.thibanglaixemay.R;
import com.khieuthichien.thibanglaixemay.adapter.CacbienbaoAdapter;
import com.khieuthichien.thibanglaixemay.model.Cacbienbao;

import java.util.ArrayList;
import java.util.List;

public class CBBtuyenduongdoingoaiFragment extends Fragment {

    private RecyclerView recyclerview;
    private List<Cacbienbao> cacbienbaoList;
    private CacbienbaoAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cbbtuyenduongdoingoai, container, false);

        recyclerview = view.findViewById(R.id.recyclerview);

        cacbienbaoList = new ArrayList<>();

        cacbienbaoList.add(new Cacbienbao("https://imgur.com/UoxQ3Wb.png", "Tuyến đường xuyên Á", "Tuyến đường xuyên Á qua quốc lộ 1"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/4FYfk0s.png", "Bến xe buýt", "Các bến xe buýt"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/A4QCIck.png", "Chỉ dẫn địa giới", ""));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/VJj9wXK.png", "Gọi điện khẩn cấp", ""));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/1yF4EV4.png", "Khu vực cấm theo giờ", ""));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/SGJv41H.png", "Nơi nghỉ mát", ""));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/m3LNCM6.png", "Giao thông công cộng", "Chỉ các biển của phương tiện công cộng"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/Sz46CNC.png", "Chỉ dẫn địa giới", "Địa phận các tỉnh"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/dVWXBEY.png", "Chỉ dẫn địa giới", "Địa phận các tỉnh"));

        adapter = new CacbienbaoAdapter(getContext(), cacbienbaoList);
        recyclerview.setAdapter(adapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerview.setLayoutManager(layoutManager);

        return view;
    }
}
