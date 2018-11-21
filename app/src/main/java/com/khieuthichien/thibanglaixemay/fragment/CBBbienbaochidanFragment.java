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

public class CBBbienbaochidanFragment extends Fragment {

    private RecyclerView recyclerview;
    private List<Cacbienbao> cacbienbaoList;
    private CacbienbaoAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cbbbienbaochidan, container, false);

        recyclerview = view.findViewById(R.id.recyclerview);

        cacbienbaoList = new ArrayList<>();

        cacbienbaoList.add(new Cacbienbao("https://imgur.com/09kkHlL.png", "Đường có làn đường dành cho oto khách", "Biển đặt ở ngã 3, ngã 4 đầu đường ngược chiều"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/85WqQnH.png", "Chỉ hướng đuòng", "Chỉ dẫn có 1 khu đông dân cư trên đường hướng đến"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/StKzTqO.png", "Chỉ hướng đuòng", "Chỉ dẫn có 1 khu đông dân cư trên đường hướng đến"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/eUQULLE.png", "Hướng phải đi cho từng loại xe", ""));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/9PrW7UK.png", "Lối đi ở chỗ cấm rẽ", ""));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/n11KNX4.png", "Chỉ dẫn địa giới", ""));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/1KiygFC.png", "Hướng ra đường dành cho oto khách", "Rẽ ra đường có làn đường dành cho oto khách"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/nBQ80Gj.png", "Hướng ra đường dành cho oto khách", "Rẽ ra đường có làn đường dành cho oto khách"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/rBka2Nc.png", "Làn đường dành cho oto khách", "Làn đường dành cho oto khách được phép chạy"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/LpXAIlp.png", "Hướng đi theo biển", ""));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/0aJ6Kty.png", "Khu vực quay xe", "Các xe được phép quay đầu"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/zsWDHDq.png", "Chỗ quay xe", "Các xe được phép quay đầu"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/E2K4QZA.png", "Nơi đỗ xe", "Những nơi được phép đỗ xe, gần bãi xe"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/MPP7bmF.png", "Đường một chiều", "Những đoạn đường chạy 1 chiều"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/3TbNy3c.png", "Đường một chiều", "Những đoạn đường chạy 1 chiều"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/Ln7wLp1.png", "Đường một chiều", "Những đoạn đường chạy 1 chiều"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/kW2fwC3.png", "Đường cụt", "trước mặt là đường cụt"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/1k39Fqp.png", "Đường cụt", "Lối rẽ là đường cụt"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/gjbnzYy.png", "Đường cụt", "Lối rẽ là đường cụt"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/3avZjFS.png", "Hết đường dành cho oto, xe máy", ""));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/VOcP5qo.png", "Hết đường dành cho oto", ""));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/ysxUSRq.png", "Đường dành cho oto, xe máy", ""));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/FJSLomz.png", "Đường dành cho oto", ""));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/9zEMt3H.png", "Hướng đi quốc lộ", ""));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/VI0qwfW.png", "Đường dành cho người tàn tật", "Các phương tiện không được phép đi vào"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/pG7V3y5.png", "Xe kéo móoc", ""));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/zm22bNw.png", "Chợ", "Sắp đến khu vực họp chợ"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/Eao5yzk.png", "Tốc độ cho phép chạy trên đường cao tốc", "Tùy từng đoạn đường"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/5Pdb0kX.png", "Hết đường cao tốc", ""));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/hmTzKnx.png", "Đường cao tốc", ""));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/NhG26nc.png", "Trạm cảnh sát giao thông", "Chú ý né né ra nhé"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/70JN4LL.png", "Bến xe điện", ""));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/dU8UgC9.png", "Bến xe buýt", ""));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/4j23rGH.png", "Khách sạn", "Dừng chân nghỉ ngơi"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/BpW0ZH6.png", "Cửa hàng ăn uống", ""));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/bbAugoV.png", "Điện thoại", "Nơi có trạm điện thoại"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/55Uj7F2.png", "Nơi rửa xe", ""));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/9AqWXRc.png", "Trạm bơm xăng", ""));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/wuHKTbd.png", "Trạm sửa chữa", ""));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/Z1dGBR4.png", "Trạm cấp cứu", ""));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/sxKRShY.png", "Bệnh viện", "C"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/G1Xv43v.png", "Cầu vượt cho người đi bộ", ""));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/Q7i9H0M.png", "Đường người đi bộ sang ngang", ""));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/lTvbNGK.png", "Lối đi đường vòng tránh", ""));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/X4mmXOh.png", "Mũi tên chỉ đường", ""));

        adapter = new CacbienbaoAdapter(getContext(), cacbienbaoList);
        recyclerview.setAdapter(adapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerview.setLayoutManager(layoutManager);

        return view;
    }
}
