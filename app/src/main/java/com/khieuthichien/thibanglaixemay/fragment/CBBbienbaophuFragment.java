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

public class CBBbienbaophuFragment extends Fragment {

    private RecyclerView recyclerview;
    private List<Cacbienbao> cacbienbaoList;
    private CacbienbaoAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cbbbienbaophu, container, false);

        recyclerview = view.findViewById(R.id.recyclerview);

        cacbienbaoList = new ArrayList<>();

        cacbienbaoList.add(new Cacbienbao("https://imgur.com/G5TIslq.png", "Hướng tác dụng của biển", "Đi theo hướng của biển chỉ dẫn"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/GMamSKr.png", "Hướng tác dụng của biển", "Đi theo hướng của biển chỉ dẫnt"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/lKNjy5p.png", "Hướng tác dụng của biển", "Đi theo hướng của biển chỉ dẫn"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/yXCblwv.png", "Hướng đường ưu tiên", "Đường ưu tiên ở ngã 4"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/Kg1aIaQ.png", "Làn đường", "Làn đường chịu hiệu lực của biển báo lệnh cấm"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/KbtY0f1.png", "Phạm vi tác dụng của biển", "Chiều dài đoạn đường nguy hiểm hoặc lệnh cấm..."));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/2zRz1YS.png", "Loại xe", "Chỉ loại xe chịu hiệu lực của biển báo"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/1rr1hmO.png", "Hướng đường ưu tiên", "Đường ưu tiên ở ngã 4"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/QXmC2oM.png", "Hướng tác dụng của biển", "Đi theo hướng của biển chỉ dẫnz"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/1OQqSwj.png", "Khoảng cách đến đối tượng báo hiệu", "Khoảng cách đến đối tượng báo hiệu"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/ejU4U4R.png", "Hướng rẽ", "Gần đến chỗ rẽ nguy hiểm"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/4d54rt7.png", "Biểu thị thời gian", "Biểu thị thời gian"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/jERyHNQ.png", "Chiều cao an toàn", "Giới hạn độ cao xe"));

        adapter = new CacbienbaoAdapter(getContext(), cacbienbaoList);
        recyclerview.setAdapter(adapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerview.setLayoutManager(layoutManager);

        return view;
    }
}
