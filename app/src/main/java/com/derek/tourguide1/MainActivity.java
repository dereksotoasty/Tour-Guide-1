package com.derek.tourguide1;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements CityFragment.OnFragmentInteractionListener,
descriptionFragment.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public void onFragmentInteraction(int Data) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        descriptionFragment descriptionFragment = (descriptionFragment) fragmentManager.findFragmentById(R.id.fragment2);
        descriptionFragment.updateText(Data);
    }
}
