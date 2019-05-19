package cryptonite.android.apps.com.traficoin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import cryptonite.android.apps.com.traficoin.Models.DaoSession;
import cryptonite.android.apps.com.traficoin.Models.Day;
import cryptonite.android.apps.com.traficoin.Models.Trip;

public class TripHistoryActivity extends AppCompatActivity {

    ArrayList<String> distances = new ArrayList<>();
    ArrayList<String> times = new ArrayList<>();
    ArrayList<String> dates = new ArrayList<>();
    DaoSession daoSession;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_history);
        daoSession = ((App)getApplication()).getDaoSession();
        loadData();
    }

    public String getDay(long ts){
        Date date = new Date(ts);
        // format of the date
        SimpleDateFormat jdf = new SimpleDateFormat("yyyy-MM-dd");
        jdf.setTimeZone(TimeZone.getTimeZone("GMT-4"));
        String java_date = jdf.format(date);
        return java_date;
    }

    public static double getDistanceKm(double sLat, double oLat, double sLong, double oLong) {
        int Radius=6371;//radius of earth in Km
        double lat1 = sLat;
        double lat2 = oLat;
        double lon1 = sLong;
        double lon2 = oLong;
        double dLat = Math.toRadians(lat2-lat1);
        double dLon = Math.toRadians(lon2-lon1);
        double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
                Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                        Math.sin(dLon/2) * Math.sin(dLon/2);
        double c = 2 * Math.asin(Math.sqrt(a));
        double valueResult= Radius*c;
        double km=valueResult/1;
        DecimalFormat newFormat = new DecimalFormat("####");
        int kmInDec =  Integer.valueOf(newFormat.format(km));
        double meter=valueResult%1000;
        int  meterInDec= Integer.valueOf(newFormat.format(meter));
        //Log.i("Radius Value",""+valueResult+"   KM  "+kmInDec+" Meter   "+meterInDec);

        return Radius * c;
    }

    private void loadDates(){

    }

    private void initRecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.triphistoryrv);
        TripHistoryRVAdapter adapter = new TripHistoryRVAdapter(this, distances, times, dates);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void loadData(){
        List<Trip> tripList = daoSession.getTripDao().loadAll();
        for(Trip t: tripList){
            distances.add(getDistanceKm(t.getStartlat(), t.getEndlat(), t.getStartlng(), t.getEndlng())+"");
            times.add((t.getEndtime()-t.getStarttime()/60000)+"");
            dates.add(getDay(t.getStarttime()));
        }
        initRecyclerView();
    }
}
