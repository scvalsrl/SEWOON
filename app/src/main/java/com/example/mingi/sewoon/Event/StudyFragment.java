package com.example.mingi.sewoon.Event;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mingi.sewoon.R;


public class StudyFragment extends Fragment {

    public StudyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_study_fragment, container, false);
    }



    @Override
    public void onActivityCreated(Bundle b) {
        super.onActivityCreated(b);


    }




}