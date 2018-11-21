package com.khieuthichien.thibanglaixemay.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.khieuthichien.thibanglaixemay.fragment.MeolythuyetFragment;
import com.khieuthichien.thibanglaixemay.fragment.MeothuchanhFragment;

public class MeoghinhoAdapter extends FragmentPagerAdapter {

    public MeoghinhoAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new MeolythuyetFragment();
            case 1:
                return new MeothuchanhFragment();
            default:
                return new MeolythuyetFragment();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Mẹo lý thuyết";
            case 1:
                return "Mẹo thực hành";
            default:
                return "Mẹo lý thuyết";
        }
    }
}
