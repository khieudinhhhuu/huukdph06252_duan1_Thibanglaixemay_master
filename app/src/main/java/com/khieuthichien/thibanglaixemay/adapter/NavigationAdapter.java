package com.khieuthichien.thibanglaixemay.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.khieuthichien.thibanglaixemay.R;
import com.khieuthichien.thibanglaixemay.model.Navigation;

import java.util.List;

public class NavigationAdapter extends ArrayAdapter<Navigation>{

    private List<Navigation> navigationArrayAdapter;

    public NavigationAdapter(@NonNull Context context, int resource, @NonNull List<Navigation> objects) {
        super(context, resource, objects);
        this.navigationArrayAdapter = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View view = inflater.inflate(R.layout.item_navigation, parent, false);

        TextView tvnavigation = view.findViewById(R.id.tvnavigation);

        tvnavigation.setText(navigationArrayAdapter.get(position).getTitle());
        if (navigationArrayAdapter.get(position).isColor())
            view.setBackgroundResource(R.color.colorPrimary6);

        return view;
    }
}
