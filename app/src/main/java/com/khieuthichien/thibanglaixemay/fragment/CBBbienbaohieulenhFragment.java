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

public class CBBbienbaohieulenhFragment extends Fragment {

    private RecyclerView recyclerview;
    private List<Cacbienbao> cacbienbaoList;
    private CacbienbaoAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cbbbienbaohieulenh, container, false);

        recyclerview = view.findViewById(R.id.recyclerview);

        cacbienbaoList = new ArrayList<>();

        cacbienbaoList.add(new Cacbienbao("https://imgur.com/nzryfKb.png", "Hướng đi phải theo", "Báo cho các loại xe thô sơ và cơ giới chỉ được đi thẳng."));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/T8SHfDd.png", "Hướng đi phải theo", "Báo cho các loại xe thô sơ và cơ giới chỉ được rẽ phải."));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/3eEXAXu.png", "Hướng đi phải theo", "Báo cho các loại xe thô sơ và cơ giới chỉ được rẽ trái."));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/d9rMRy5.png", "Hướng đi phải theo", "Báo cho các loại xe thô sơ và cơ giới chỉ được rẽ phải."));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/Lvj01O4.png", "Hướng đi phải theo", "Báo cho các loại xe thô sơ và cơ giới chỉ được rẽ trái."));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/nC12SaC.png", "Hướng đi phải theo", "Báo cho các loại xe thô sơ và cơ giới chỉ được đi thẳng và rẽ phải."));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/5FT3jYo.png", "Hướng đi phải theo", "Báo cho các loại xe thô sơ và cơ giới chỉ được đi thẳng và rẽ trái."));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/FF7tPsx.png", "Hướng đi phải theo", "Báo cho các loại xe thô sơ và cơ giới chỉ được rẽ phải và rẽ trái."));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/l4AFV3F.png", "Hướng phải đi vòng chướng ngại vật", "Các loại xe phải đi vòng chướng ngại vật theo hướng mũi tên chỉ."));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/40slABB.png", "Hướng phải đi vòng chướng ngại vật", "Các loại xe phải đi vòng chướng ngại vật theo hướng mũi tên chỉ."));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/FqZkqeE.png", "Nơi giao nhau chạy theo vòng xuyến", "Phải chạy vòng theo đảo an toàn ở các ngã tư, ngã năm. Bắt buộc các loại xe muốn chuyến hướng phải chạy vòng theo hướng mũi tên chỉ."));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/dJzuplv.png", "Đường dành cho xe thô sơ", "Làn đường dành cho xe thô sơ, xe của người tàn tật, người đi bộ. Cấm tất cả các xe đi vào."));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/Q9Y9Y1V.png", "Đường dành cho người đi bộ", "Đường dành cho người đi bộ. Cấm tất cả các xe đi vào."));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/8b4UeAb.png", "Tốc độ tối thiểu cho phép", "Tốc độ tối thiểu không được nhỏ hơn trị số ghi trên biển."));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/5tscZo8.png", "Hết hạn chế tốc độ tối thiểu", "Các xe có thể chạy chậm hơn trị số ghi trên biển."));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/I91VErf.png", "Tuyến đường cầu vượt cắt qua", "Biểu thị tại cầu vượt. Xe có thể đi thẳng hoặc rẽ phải. Biển đặt vị trí thích hợp trước khi qua cầu hoặc vào đường rẽ trái."));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/CQPjbbb.png", "Tuyến đường cầu vượt cắt qua", "Biểu thị tại cầu vượt. Xe có thể đi thẳng hoặc rẽ phải. Biển đặt vị trí thích hợp trước khi qua cầu hoặc vào đường rẽ phải."));
        cacbienbaoList.add(new Cacbienbao("https://imgur.com/wN5APgm.png", "Ấn còi", "Xe cộ đi đến chỗ cắm biển đó thì phải bấm còi."));

        adapter = new CacbienbaoAdapter(getContext(), cacbienbaoList);
        recyclerview.setAdapter(adapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerview.setLayoutManager(layoutManager);

        return view;
    }
}
