package com.derek.tourguide1;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class descriptionFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    private TextView textView;

    public descriptionFragment() {
        // Required empty public constructor
    }

    public static descriptionFragment newInstance(String param1, String param2) {
        descriptionFragment fragment = new descriptionFragment();
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
        return inflater.inflate(R.layout.fragment_description, container, false);
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
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        textView = (TextView)getActivity().findViewById(R.id.description);

        if(savedInstanceState != null){
            textView.setText(savedInstanceState.getString("description"));
        }
    }

    public void updateText(int data){
        Resources res = getResources();
        String [] description = res.getStringArray(R.array.desc);
        textView.setText(description[data]);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("description",textView.getText().toString());
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(int data);
    }
}
