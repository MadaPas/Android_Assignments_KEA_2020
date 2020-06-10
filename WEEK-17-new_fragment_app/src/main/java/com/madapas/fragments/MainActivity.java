package com.madapas.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rv = findViewById(R.id.main_rv);
        ArrayList<Name> nameArrayList = new ArrayList<>();
        for (int e = 0; e < 50; )
            nameArrayList.add(new Name("MadaPas " + ++e));

        NameAdapter nameAdapter = new NameAdapter(nameArrayList, new NameAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Name name) {
                NameFragment fragment = NameFragment.newInstance(name.getName());
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.main_fragment, fragment);
                ft.commit();
            }
        });
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setHasFixedSize(true);
        rv.setAdapter(nameAdapter);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(rv.getContext(), DividerItemDecoration.VERTICAL);
        rv.addItemDecoration(dividerItemDecoration);

    }

}









































