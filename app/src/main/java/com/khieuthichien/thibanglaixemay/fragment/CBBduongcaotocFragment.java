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

public class CBBduongcaotocFragment extends Fragment {

    private RecyclerView recyclerview;
    private List<Cacbienbao> cacbienbaoList;
    private CacbienbaoAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cbbduongcaotoc, container, false);

        recyclerview = view.findViewById(R.id.recyclerview);

        cacbienbaoList = new ArrayList<>();

        cacbienbaoList.add(new Cacbienbao("https://imgur.com/2yHQPwr.png", "Biển chỉ dẫn đường cao tốc", "Hướng đi Hà Nội, quốc lộ 1 và quốc lộ 6"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/5IYydGm.png", "Biển chỉ dẫn đường cao tốc", "Hướng đi Hà Nội, quốc lộ 1 và Hòa Lạc"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/6pzP9YP.png", "Biển chỉ dẫn đường cao tốc", "Biển báo khoảng cách đến đường cao tốc"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/6pzP9YP.png", "Biển chỉ dẫn đường cao tốc", "Biển báo khoảng cách đến đường cao tốc"));

        adapter = new CacbienbaoAdapter(getContext(), cacbienbaoList);
        recyclerview.setAdapter(adapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerview.setLayoutManager(layoutManager);

        return view;
    }
}
