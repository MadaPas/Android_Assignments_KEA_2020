package com.madapas.fragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class NameFragment extends Fragment {
    private  String name;
    private static final String AGR_NAME="name";
    public NameFragment() {
        // empty public constructor
    }
    public static NameFragment newInstance(String name)
    {
        Bundle bundle = new Bundle();
        bundle.putString("name",name);
        NameFragment fragment = new NameFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if(bundle !=null)
        {
            name = bundle.getString(AGR_NAME);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_name, container, false);
        TextView tv_name = v.findViewById(R.id.fragment_tv_name);
        tv_name.setText(name);
        return v;
    }
}
