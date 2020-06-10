package com.example.recyclerviewdatabinding;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import com.example.recyclerviewdatabinding.databinding.ActivityMainBinding;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding activityMainBinding;
    private RecyclerAdapter recyclerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        activityMainBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        activityMainBinding.recyclerView.setHasFixedSize(true);
        loadData();
    }

    private void loadData(){
        List<Cat> catList = new ArrayList<>();
        catList.add(new Cat("Cat1","https://icatcare.org/app/uploads/2018/06/Layer-1704-1920x840.jpg"));
        catList.add(new Cat("Cat2","https://icatcare.org/app/uploads/2018/07/Thinking-of-getting-a-cat.png"));
        catList.add(new Cat("Cat3","https://static01.nyt.com/images/2020/04/22/science/22VIRUS-PETCATS1/22VIRUS-PETCATS1-mediumSquareAt3X.jpg"));
        catList.add(new Cat("Cat4","https://undark.org/wp-content/uploads/2020/02/GettyImages-1199242002-1-scaled.jpg"));
        catList.add(new Cat("Cat5","https://cdn.mos.cms.futurecdn.net/otjbibjaAbiifyN9uVaZyL.jpg"));
        catList.add(new Cat("Cat6","https://cdn.mos.cms.futurecdn.net/otjbibjaAbiifyN9uVaZyL.jpg"));
        catList.add(new Cat("Cat7","https://icatcare.org/app/uploads/2018/06/Layer-1704-1920x840.jpg"));
        catList.add(new Cat("Cat8","https://static01.nyt.com/images/2020/04/22/science/22VIRUS-PETCATS1/22VIRUS-PETCATS1-mediumSquareAt3X.jpg"));
        catList.add(new Cat("Cat9","https://undark.org/wp-content/uploads/2020/02/GettyImages-1199242002-1-scaled.jpg"));
        catList.add(new Cat("Cat10","https://icatcare.org/app/uploads/2018/06/Layer-1704-1920x840.jpg"));
        catList.add(new Cat("Cat11","https://cdn.mos.cms.futurecdn.net/otjbibjaAbiifyN9uVaZyL.jpg"));
        catList.add(new Cat("Cat12","https://cdn.mos.cms.futurecdn.net/otjbibjaAbiifyN9uVaZyL.jpg"));
        catList.add(new Cat("Cat13","https://icatcare.org/app/uploads/2018/07/Thinking-of-getting-a-cat.png"));
        catList.add(new Cat("Cat14","https://cdn.mos.cms.futurecdn.net/otjbibjaAbiifyN9uVaZyL.jpg"));

        recyclerAdapter = new RecyclerAdapter(this,catList);
        activityMainBinding.recyclerView.setAdapter(recyclerAdapter);
    }

}
