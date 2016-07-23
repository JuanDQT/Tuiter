package com.example.juan.tuiter.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.juan.tuiter.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class fr_mensajes extends Fragment {


    public fr_mensajes() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fr_mensajes, container, false);
    }

}
