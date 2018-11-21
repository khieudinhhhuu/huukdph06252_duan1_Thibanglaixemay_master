package com.khieuthichien.thibanglaixemay.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.khieuthichien.thibanglaixemay.fragment.CBBbienbaocamFragment;
import com.khieuthichien.thibanglaixemay.fragment.CBBbienbaochidanFragment;
import com.khieuthichien.thibanglaixemay.fragment.CBBbienbaohieulenhFragment;
import com.khieuthichien.thibanglaixemay.fragment.CBBbienbaonguyhiemFragment;
import com.khieuthichien.thibanglaixemay.fragment.CBBbienbaophuFragment;
import com.khieuthichien.thibanglaixemay.fragment.CBBduongcaotocFragment;
import com.khieuthichien.thibanglaixemay.fragment.CBBtuyenduongdoingoaiFragment;
import com.khieuthichien.thibanglaixemay.fragment.CBBvachkeduongFragment;

public class CacbienbaoAdapter2 extends FragmentPagerAdapter {

    public CacbienbaoAdapter2(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new CBBbienbaocamFragment();
            case 1:
                return new CBBbienbaohieulenhFragment();
            case 2:
                return new CBBbienbaonguyhiemFragment();
            case 3:
                return new CBBbienbaophuFragment();
            case 4:
                return new CBBbienbaochidanFragment();
            case 5:
                return new CBBvachkeduongFragment();
            case 6:
                return new CBBduongcaotocFragment();
            case 7:
                return new CBBtuyenduongdoingoaiFragment();
            default:
                return new CBBbienbaocamFragment();
        }
    }

    @Override
    public int getCount() {
        return 8;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Biển báo cấm";
            case 1:
                return "biển báo hiệu lệnh";
            case 2:
                return "biển báo nguy hiểm";
            case 3:
                return "biển báo phụ";
            case 4:
                return "biển báo chỉ dẫn";
            case 5:
                return "Vạch kẻ đường";
            case 6:
                return "đường cao tốc";
            case 7:
                return "tuyến đường đối ngoại";
            default:
                return "Biển báo cấm";
        }
    }
}
