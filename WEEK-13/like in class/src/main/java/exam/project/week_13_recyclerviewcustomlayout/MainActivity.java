package exam.project.week_13_recyclerviewcustomlayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import exam.project.week_13_recyclerviewcustomlayout.adapter.ConstraintAdapter;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    // vars
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: Started.");

        initImageBitMaps();

    }

    private void initImageBitMaps() {
        Log.d(TAG, "initImageBitMaps: preparing bitmaps");

        mImageUrls.add("https://i.redd.it/sx75walk2t151.jpg");
        mNames.add("BMW");

        mImageUrls.add("https://i.redd.it/0r59b76zpjz41.jpg");
        mNames.add("Benz GTR");

        mImageUrls.add("https://i.redd.it/ffxvb2tlyy251.jpg");
        mNames.add("Nissan GTR");

        mImageUrls.add("https://i.redd.it/746rf97qu3t41.jpg");
        mNames.add("Lamborghini");

        mImageUrls.add("https://i.redd.it/k3bpt3rkf6251.jpg");
        mNames.add("Civic Type R");

        mImageUrls.add("https://i.redd.it/hqip3ujfepj41.jpg");
        mNames.add("Nismo GTR");

        initRecyclerView();
    }

    private void initRecyclerView() {
        Log.d(TAG, "initRecyclerView: init recyclerview.");
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mNames, mImageUrls);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}