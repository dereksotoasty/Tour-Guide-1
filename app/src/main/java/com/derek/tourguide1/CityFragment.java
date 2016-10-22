package com.derek.tourguide1;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class CityFragment extends ListFragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String[] sCities;

    private OnFragmentInteractionListener mListener;

    public CityFragment() {
        // Required empty public constructor
    }



    public static CityFragment newInstance(String param1, String param2) {
        CityFragment fragment = new CityFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_city, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        List<City> cities = new ArrayList<>();
        sCities = getResources().getStringArray(R.array.cities);

        for(int i = 0; i < sCities.length; i++){
            cities.add(new City(sCities[i], i+1));
        }


        ListView listView = getListView();

        ListAdapter listAdapter = new ListAdapter(getContext(),R.layout.column_row, cities);
        listView.setAdapter(listAdapter);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Log.d("List Click","Clicked -> " + position);
        mListener.onFragmentInteraction(position);
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(int Data);
    }
}
