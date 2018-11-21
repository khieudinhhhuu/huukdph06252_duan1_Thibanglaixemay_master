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

public class CBBbienbaonguyhiemFragment extends Fragment {

    private RecyclerView recyclerview;
    private List<Cacbienbao> cacbienbaoList;
    private CacbienbaoAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cbbbienbaonguyhiem, container, false);

        recyclerview = view.findViewById(R.id.recyclerview);

        cacbienbaoList = new ArrayList<>();

        cacbienbaoList.add(new Cacbienbao("https://imgur.com/nqeriES.png", "Chỗ ngoặt nguy hiểm vòng bên trái", "Chỗ ngoặt nguy hiểm vòng bên trái"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/Rr91itI.png", "Chỗ ngoặt nguy hiểm vòng bên phải", "Chỗ ngoặt nguy hiểm vòng bên phải"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/sHyYzsy.png", "Nhiều chỗ ngoặt nguy hiểm liên tiếp", "Cần giảm tốc độ"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/7G4hxMC.png", "Đường bị hẹp cả 2 bên", "Đường bị hẹp cả 2 bên"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/C6ArLx7.png", "Đường bị hẹp về phía trái", "Đường bị hẹp về phía trái"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/7RMNqc6.png", "Đường bị hẹp về phía phải", "Đường bị hẹp về phía phải"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/wH6cAdy.png", "Đường hai chiều", "Đường hai chiều"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/BRqwLS8.png", "Chú ý đường cụt", "Chú ý đường cụt"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/GZj9NC3.png", "Chú ý đường cụt", "Chú ý đường cụt"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/xH53mqs.png", "Chú ý đường cụt", "Chú ý đường cụt"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/9JFcIhl.png", "Chú ý ngã ba", "Chú ý ngã ba"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/ISLmdGV.png", "Đường giao nhau", "Đường giao nhau"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/48rRzCS.png", "Giao nhau chạy theo vòng xuyến", "Giao nhau chạy theo vòng xuyến"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/BshmeFa.png", "Giao nhau với đường không ưu tiên", "Giao nhau với đường không ưu tiên"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/yJXeDio.png", "Giao nhau với đường không ưu tiên", "Giao nhau với đường không ưu tiên"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/fe1hC0W.png", "Giao nhau với đường ưu tiên", "Giao nhau với đường ưu tiên"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/FcBFwA2.png", "Giao nhau có tín hiệu đèn", "Giao nhau có tín hiệu đèn"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/f7juhJu.png", "Giao nhau với rào sắt có rào chắn", "Giao nhau với rào sắt có rào chắn"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/d4XnjNI.png", "Giao nhau với rào sắt không có rào chắn", "Giao nhau với rào sắt không có rào chắn"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/SvgLfmp.png", "Cầu hẹp", "Cầu hẹp"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/QvySZdu.png", "Cầu xoay - cầu cất", "Cầu xoay - cầu cất"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/w6C3bpF.png", "Kè, vực sâu phía trước", "Kè, vực sâu phía trước"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/b2W0eXb.png", "Kè, vực sâu phía trước", "Kè, vực sâu phía trước"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/J1oKpmQ.png", "Đường ngầm", "Đường ngầm"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/xRV8iBN.png", "Bến phà", "Bến phà"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/oc4Bo03.png", "Cửa chui", "Cửa chui"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/D7Qbzo2.png", "Dốc xuống nguy hiểm", "Dốc xuống nguy hiểm"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/QLTEx64.png", "Dốc lên nguy hiểm", "Dốc lên nguy hiểm"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/s5uhMnZ.png", "Đường không bằng phẳng", "Đường không bằng phẳng"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/yIl4Iah.png", "Đường không bằng phẳng", "Đường không bằng phẳng"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/bpuQGAm.png", "Đường trơn", "Đường trơn"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/1DCnqOo.png", "Vách núi nguy hiểm", "Vách núi nguy hiểm"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/C2hnzWQ.png", "Đường người đi bộ cắt ngang", "Đường người đi bộ cắt ngang"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/yY54bDt.png", "Trẻ em", "Nơi có nhiều trẻ em vui chơi, qua lại"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/zzWMWIz.png", "Công trường", "Công trường"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/sobAzVg.png", "Đoạn đường người đi xe đạp cắt qua", "Đoạn đường người đi xe đạp cắt qua"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/dXh9CQX.png", "Đá lở", "Đoạn đường có đá lở"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/DPMB58j.png", "Giải máy bay lên xuống", "Giải máy bay lên xuống"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/hHpwTbL.png", "Gia súc", "Đoạn đường có gia súc qua lại"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/qzVWxzJ.png", "Thú rừng vượt qua đường", "Thú rừng vượt qua đường"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/GIoq0iP.png", "Gió ngang", "Đoạn đường có gió ngang thổi mạnh"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/0myJkva.png", "Nguy hiểm khác", "Nguy hiểm khác"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/yw6SKws.png", "Giao nhau với đường hai chiều", "Giao nhau với đường hai chiều"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/uZpxqhJ.png", "Đường đôi", "Đường đôi"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/NX1q80Q.png", "Hết đường đôi", "Hết đường đôi"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/1A8AKgf.png", "Cầu vòng", "Cầu vòng"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/JWDKQTk.png", "Đường cao tốc phía trước", "Đường cao tốc phía trước"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/WQszb5c.png", "Đường cáp điện ở phía trên", "Đường cáp điện ở phía trên"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/gRO2cYj.png", "Đường hầm", "Đường hầm"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/vNEBgcL.png", "Thôn bản", "Thôn bản"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/wa6R2Wp.png", "Chỗ đường sắt cắt đường bộ", "Chỗ đường sắt cắt đường bộ"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/k44vHI5.png", "Chỗ đường sắt cắt đường bộ", "Chỗ đường sắt cắt đường bộ"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/TeL7OQx.png", "Đoạn đường hay xảy ra tai nạn", "Đoạn đường hay xảy ra tai nạn"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/OKMYNSA.png", "Đường sắt giao cắt với đường bộ không vuông góc", "Đường sắt giao cắt với đường bộ không vuông góc"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/OPU8dMk.png", "Đi chậm", "Đi chậm"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/z1lHco3.png", "Chú ý chướng ngại vật", "Chú ý chướng ngại vật"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/AVivZVy.png", "Chú ý chướng ngại vật bên trái", "Chú ý chướng ngại vật bên trái"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/C47a11R.png", "Dốc xuống nguy hiểm", "Dốc xuống nguy hiểm"));

        adapter = new CacbienbaoAdapter(getContext(), cacbienbaoList);
        recyclerview.setAdapter(adapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerview.setLayoutManager(layoutManager);

        return view;
    }
}
