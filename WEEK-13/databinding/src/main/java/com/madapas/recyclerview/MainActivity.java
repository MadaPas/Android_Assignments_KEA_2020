package com.madapas.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.madapas.recyclerview.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // create dataBinding object
    private ActivityMainBinding mainBinding;
    private RecyclerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);


        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        // initialize the recyclerView
        mainBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mainBinding.recyclerView.setHasFixedSize(true);
        adapter = new RecyclerAdapter(this, prepareCat());
        //set adapter for the recycler view
        mainBinding.recyclerView.setAdapter(adapter);

    }

    private List<Cat> prepareCat()
    {
        // getting arrayLists from strings.xml
        List<String> names = Arrays.asList(getResources().getStringArray(R.array.names));
        List<String> descriptions = Arrays.asList(getResources().getStringArray(R.array.description));

        //containing the resource ids of the images
        int [] imageId = {
                R.drawable.cat1,
                R.drawable.cat2,
                R.drawable.cat3,
                R.drawable.cat4,
                R.drawable.cat5,
                R.drawable.cat6,
                R.drawable.cat7,
                R.drawable.cat8,
                R.drawable.cat9,
                R.drawable.cat10
        };
        // list of names
        List<Cat> Names = new ArrayList<>();
        int count = 0;

        for(String name : names) {
            // create an onbect of the cat class and pass each object of the array called names
            Names.add(new Cat(name, descriptions.get(count), imageId[count]));
            count ++;
        }
        return Names;
    }
}
