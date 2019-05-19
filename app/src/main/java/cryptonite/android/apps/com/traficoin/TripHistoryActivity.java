package cryptonite.android.apps.com.traficoin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;

public class TripHistoryActivity extends AppCompatActivity {

    ArrayList<String> distances = new ArrayList<>();
    ArrayList<String> times = new ArrayList<>();
    ArrayList<String> dates = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_history);
    }

    public String getDay(long ts){
        Date date = new Date(ts);
        // format of the date
        SimpleDateFormat jdf = new SimpleDateFormat("yyyy-MM-dd");
        jdf.setTimeZone(TimeZone.getTimeZone("GMT-4"));
        String java_date = jdf.format(date);
        return java_date;
    }

    private void loadDates(){

    }

    private void initRecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.triphistoryrv);
        TripHistoryRVAdapter adapter = new TripHistoryRVAdapter(this, distances, times, dates);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
