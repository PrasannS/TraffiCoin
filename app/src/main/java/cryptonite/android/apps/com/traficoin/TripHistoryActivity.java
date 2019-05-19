package cryptonite.android.apps.com.traficoin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class TripHistoryActivity extends AppCompatActivity {

    private ArrayList<String> startinglocs = new ArrayList<>();
    private ArrayList<String> endinglocs = new ArrayList<>();
    private ArrayList<String> distances = new ArrayList<>();
    private ArrayList<String> times = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_history);
        distances.add("69");
        distances.add("100");
        times.add("1");
        times.add("30");
        initRecyclerView();
    }

    private void initRecyclerView(){
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.tripRecyclerView);
        TripRVAdapter adapter = new TripRVAdapter(this, distances, times);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
