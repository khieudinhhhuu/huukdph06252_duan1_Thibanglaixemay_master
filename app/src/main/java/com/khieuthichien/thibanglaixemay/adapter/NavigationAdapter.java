package com.khieuthichien.thibanglaixemay.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.khieuthichien.thibanglaixemay.R;
import com.khieuthichien.thibanglaixemay.model.Navigation;

import java.util.List;


public class NavigationAdapter extends ArrayAdapter<Navigation> {

    private List<Navigation> navigationList;

    public NavigationAdapter(Context context, int resource, List<Navigation> objects) {
        super(context, resource, objects);
        this.navigationList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.item_listview_navigation,parent,false);

        TextView tvnavigation = view.findViewById(R.id.tvnavigation);
        tvnavigation.setText(navigationList.get(position).getTitle());

        if (navigationList.get(position).isColor()) {
            view.setBackgroundResource(R.color.colorAccent);
        }
        return view;
    }
}
