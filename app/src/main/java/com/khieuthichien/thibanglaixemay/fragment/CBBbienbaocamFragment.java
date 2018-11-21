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

public class CBBbienbaocamFragment extends Fragment {

    private RecyclerView recyclerview;
    private List<Cacbienbao> cacbienbaoList;
    private CacbienbaoAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cbbbienbaocam, container, false);

        recyclerview = view.findViewById(R.id.recyclerview);

        cacbienbaoList = new ArrayList<>();

        cacbienbaoList.add(new Cacbienbao("https://imgur.com/3HTto9K.png", "Cấm ôtô", "Cấm tất cả các loại xe cơ giới, kể cả môtô 3 bánh có thùng. Trừ môtô 2 bánh, xe gắn máy và xe ưu tiên."));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/CQdev4Z.png", "Cấm ôtô rẽ phải", "Cấm tất cả các loại xe cơ giới, kể cả môtô 3 bánh có thùng rẽ phải. Trừ môtô 2 bánh, xe gắn máy và xe ưu tiên."));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/y3lYjuM.png", "Đường cấm", "Cấm tất cả phương tiện thô sơ và cơ giới đi lại cả 2 hướng. Trừ các xe ưu tiên."));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/qf6KYuk.png", "Cấm đi ngược chiều", "Cấm tất cả phương tiện thô sơ và cơ giới đi vào theo chiều đặt biển. Trừ các xe ưu tiên."));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/DNfytyB.png", "Cấm ôtô rẽ trái", "Cấm tất cả các loại xe cơ giới, kể cả môtô 3 bánh có thùng rẽ trái. Trừ môtô 2 bánh, xe gắn máy và xe ưu tiên."));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/OVf8q9n.png", "Cấm môtô", "Cấm tất cả các loại môtô đi qua, trừ môtô ưu tiên."));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/UB6lVXR.png", "Cấm ôtô và môtô", "Cấm tất cả các loại xe cơ giới và môtô đi qua"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/HaCva0h.png", "Cấm ôtô tải", "Cấm tất cả các loại ôtô tải có trọng lượng lớn nhất cho phép (bao gồm trọng lượng xe và hàng) trên 3,5 tấn."));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/mz9kyl7.png", "Cấm oto khách và oto tải", "Cấm oto chở hành khách và oto tải có trọng lượng trên 3,5 tấn, kể cả các loại máy kéo và xe máy thi công chuyên dụng."));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/mzCxvZQ.png", "Cấm máy kéo", "Cấm tất cả các loại máy kéo, kể cả bánh hơi và bánh xích."));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/Lj5H0Zc.png", "Cấm đi xe đạp", "Cấm xe đạp đi qua"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/9TauPSZ.png", "Cấm xe đạp thồ", "Cấm xe đạp thồ đi qua, không cấm người dắt loại xe này."));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/QdJisGW.png", "Cấm xe gắn máy", "Cấm xe gắn máy đi qua."));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/ks1Hcfk.png", "Cấm xe ba bánh loại có động cơ", "Cấm xe ba bánh loại có động cơ như xe lam, xích lô máy, xe lôi máy..."));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/CaYNhDZ.png", "Cấm xe lôi máy", "Cấm xe ba bánh loại có động cơ như xe lam, xích lô máy, xe lôi máy..."));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/B2HtiIp.png", "Cấm người đi bộ", "Biển báo cấm người đi bộ qua lại"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/R8g38uJ.png", "Cấm xe người kéo, đẩy", "Cấm xe người kéo, đẩy đi qua. Biển không cấm xe nôi của trẻ em, phương tiện của người tàn tật."));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/7S2LNOX.png", "Cấm xe súc vật kéo", "Cấm súc vật vận tải hàng hóa hoặc hành khách dù kéo xe hay chở trên lưng."));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/UuMeeF1.png", "Hạn chế trọng lượng xe", "Cấm tất cả các loại xe có trọng lượng toàn bộ vượt quá trị số trên biển, kể cả xe ưu tiên."));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/VHwvFyz.png", "Hạn chế trọng lượng trên trục xe", "Cấm tất cả các loại xe có trọng lượng toàn bộ phân bố trên 1 trục bất kì của xe vượt quá trị số trên biển, kể cả xe ưu tiên."));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/PLfrCgX.png", "Hạn chế chiều cao", "Cấm tất cả các loại xe có chiều cao vượt quá trị số trên biển, kể cả xe ưu tiên."));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/T1orLO3.png", "Hạn chế chiều ngang", "Cấm tất cả các loại xe có chiều ngang toàn bộ vượt quá trị giá trên biển, kể cả xe ưu tiên."));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/A7Qyu51.png", "Hạn chế chiều dài oto", "Cấm tất cả các loại xe có độ dài toàn bộ vượt quá trị giá trên biển, kể cả xe ưu tiên."));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/XFwM7FO.png", "Hạn chế chiều dài oto kéo móoc", "Cấm tất cả các loại xe có kéo theo móoc có độ dài toàn bộ vượt quá trị giá trên biển, kể cả xe ưu tiên."));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/hGLSalL.png", "Cự ly tối thiểu giữa 2 xe", "Các loại xe oto phải cách nhau cự ly 8m, kể cả xe ưu tiên."));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/B32zCRm.png", "Dừng xe", "Cấm tất cả các loại xe phải dừng trước biển."));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/FGiG3dP.png", "Cấm rẽ trái", "Cấm rẽ trái theo hướng mũi tên chỉ ở những chỗ đường giao nhau. Biểm có hiệu lực cấm các loại xe cơ giới và thô sơ. Trừ các xe được ưu tiên."));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/X31hkxw.png", "Cấm rẽ phải", "Cấm rẽ phải theo hướng mũi tên chỉ ở những chỗ đường giao nhau. Biểm có hiệu lực cấm các loại xe cơ giới và thô sơ. Trừ các xe được ưu tiên."));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/iAxspHU.png", "Cấm quay xe", "Cấm các loại xe cơ giới và thô sơ quay đầu theo kiểu chữ U. Trừ các xe được ưu tiên."));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/GQ73sMf.png", "Cấm oto quay đầu xe", "Cấm các loại xe oto và moto 3 bánh quay đầu xe theo kiểu chữ U. Trừ các xe được ưu tiên."));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/P4gTV6W.png", "Cấm vượt", "Cấm tất cả các loại xe cơ giới vượt nhau, kể cả xe ưu tiên."));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/QGxZnZT.png", "Cấm oto tải vượt", "Cấm oto tải có trọng lượng trên 3,5 tấn vượt, kể cả xe ưu tiên."));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/S5Tj3RS.png", "Tốc độ tối đa cho phép", "Cấm tất cả các loại xe vượt tốc độ trên. Trừ các xe ưu tiên."));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/k19lNQF.png", "Cấm bấm còi", "Cấm các loại xe bấm còi."));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/2qiMOTX.png", "Kiểm tra", "Nơi đặt trạm kiểm tra, các loại xe vận tải qua đó phải dừng lại vào kiểm tra."));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/167P90m.png", "Cấm dừng xe và đỗ xe", "Cấm tất cả các loại xe cơ giới dừng và đỗ ở phía trước có đặt biển. Trừ các xe được ưu tiên."));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/ENHLNrl.png", "Nhường đường cho xe cơ giới đi ngược chiều qua đường hẹp", "Tất cả các loại xe phải nhường đường cho xe cơ giới đi ngược chiều khi đi qua đường hẹp"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/Ft1Fe4B.png", "Hết cấm vượt", "Các xe được phép vượt nhau trong khoảng cho phép."));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/G4slsmc.png", "Hết hạn chế tốc độ tối đa", "Các xe được chạy với tốc độ tối đa, không bị hạn chế."));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/5kGrOLI.png", "Hết tất cả các lệnh cấm", "Đoạn đường không có lệnh cấm."));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/mcNM5Ql.png", "Cấm đi thẳng", "Cấm tất cả các loại xe đi thẳng"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/glTTSLe.png", "Cấm rẽ phải và rẽ trái", "Cấm tất cả các loại xe rẽ trái và rẽ phải"));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/8QrJ47W.png", "Cấm đi thẳng và rẽ trái", "Biểu thị ở ngã tư, ngã năm đường phía trước cấm tất cả các loại xe đi thẳng và rẽ trái."));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/mpDIkV4.png", "Cấm đi thẳng và rẽ phải", "Biểu thị ở ngã tư, ngã năm đường phía trước cấm tất cả các loại xe đi thẳng và rẽ phải."));

        adapter = new CacbienbaoAdapter(getContext(), cacbienbaoList);
        recyclerview.setAdapter(adapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerview.setLayoutManager(layoutManager);

        return view;
    }
}
