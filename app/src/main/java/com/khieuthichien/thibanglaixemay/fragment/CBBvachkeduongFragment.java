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

public class CBBvachkeduongFragment extends Fragment {

    private RecyclerView recyclerview;
    private List<Cacbienbao> cacbienbaoList;
    private CacbienbaoAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cbbvachkeduong, container, false);

        recyclerview = view.findViewById(R.id.recyclerview);

        cacbienbaoList = new ArrayList<>();

        cacbienbaoList.add(new Cacbienbao("https://imgur.com/n3d8pa0.png", "Vạch nằm ngang 4", "Xác định nơi cấm dừng và cấm đỗ xe"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/Yo5QftU.png", "Vạch nằm ngang 2", "Xác định mép phần xe chạy trên các trục đường"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/oDb8VQY.png", "Vạch nằm ngang 11", "Phân chia dòng phương tiện 2 hướng ngược chiều"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/uI7BDcV.png", "Vạch nằm ngang 7", "Đảm bảo an toàn chỗ giao nhau"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/MG9DVML.png", "Vạch nằm ngang 17", "Quy định vị trí dừng của các phương tiện vận tải"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/zGn1zLk.png", "Vạch nằm ngang 15", "Xác định vị trí chỗ xe đạp đi ngang qua xe cơ giới"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/xh65W0I.png", "Vạch nằm ngang 6", "Phân chia dòng xe cùng chiều và ngược chiều"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/wvXw14t.png", "Vạch nằm ngang 16.1", "Đảo phân chia dòng phương tiện ngược chiều"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/WcD6BEO.png", "Vạch nằm ngang 9", "Quy định ranh giới làn xe dự trữ, chiều xe có thể được thay đổi"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/ddrRwZ7.png", "Vạch nằm ngang 16.2", "Phương tiện chạy cùng hướng được phân chia nhiều làn khác nhau"));

        adapter = new CacbienbaoAdapter(getContext(), cacbienbaoList);
        recyclerview.setAdapter(adapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerview.setLayoutManager(layoutManager);

        return view;
    }
}
