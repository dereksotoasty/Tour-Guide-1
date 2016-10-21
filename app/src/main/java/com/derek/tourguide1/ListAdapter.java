package com.derek.tourguide1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Derek on 2016-10-13.
 */

public class ListAdapter extends ArrayAdapter<City> {

    public ListAdapter(Context context, int resource, List<City> items) {
        super(context, resource, items);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;

        if(view == null){
            LayoutInflater inflater;
            inflater = LayoutInflater.from(getContext());
            view = inflater.inflate(R.layout.column_row, null);
        }

        City city = getItem(position);

        if(city != null){
            TextView idtxt = (TextView) view.findViewById(R.id.id);
            TextView citytxt = (TextView) view.findViewById(R.id.city);

            if(idtxt != null){
                idtxt.setText(Integer.toString(city.getId()));
            }

            if (citytxt != null){
                citytxt.setText(city.getCityName());
            }
        }

        return view;
    }
}