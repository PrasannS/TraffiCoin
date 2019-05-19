package cryptonite.android.apps.com.traficoin;


import android.Manifest;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.location.Location;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import cryptonite.android.apps.com.traficoin.Models.DaoSession;
import cryptonite.android.apps.com.traficoin.Models.Route;
import cryptonite.android.apps.com.traficoin.Models.Trip;

public class LocationTracker
{
    public static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;
    public static final String TAG = LoginActivity.class.getSimpleName();
    TextView t, test;
    String cur = "Unknown";
    ArrayList<String> prev = new ArrayList<>();
    double sLat, sLong;
    double starttime;
    double endtime;
    public FusedLocationProviderClient fusedLocationClient;
    int sHour, sMin;
    Context con;
    Context c;
    Calendar cal = Calendar.getInstance();
    public DaoSession daoSession;
    public  LocationTracker() {}
    public LocationTracker(Context context,Context cont)
    {
        con = context;
        c=cont;
        daoSession = ((App)cont).getDaoSession();
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(context);
    }
    protected void start(Context context)
    {
        Log.d(TAG, "onStart():start ActivityDetectionService");
        LocalBroadcastManager.getInstance(context).registerReceiver(mActivityBroadcastReceiver,
                new IntentFilter(Constant.BROADCAST_DETECTED_ACTIVITY));

        //REMEMBER TO START SERVICE IN CLASS, CODE NOT IN HERE
    }
    void setTextView(TextView t, TextView test)
    {
        this.t = t;
        this.test = test;
    }
    BroadcastReceiver mActivityBroadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            // Log.d(TAG, "onReceive()");
            if (intent.getAction().equals(Constant.BROADCAST_DETECTED_ACTIVITY)) {
                int type = intent.getIntExtra("type", -1);
                int confidence = intent.getIntExtra("confidence", 0);
                handleUserActivity(type, confidence);
            }
        }
    };
    private void handleUserActivity(int type, int confidence) {
        String label = "Unknown";
        switch (type) {
            case DetectedActivity.IN_VEHICLE: {
                label = "In_Vehicle";
                break;
            }
            case DetectedActivity.ON_BICYCLE: {
                label = "On_Bicycle";
                break;
            }
            case DetectedActivity.ON_FOOT: {
                label = "On_Foot";
                break;
            }
            case DetectedActivity.RUNNING: {
                label = "Running";
                break;
            }
            case DetectedActivity.STILL: {
                label = "Still";
                break;
            }
            case DetectedActivity.WALKING: {
                label = "Walking";
                break;
            }
            case DetectedActivity.UNKNOWN: {
                break;
            }
        }
        Log.d(TAG, "broadcast:onReceive(): Activity is " + label
                + " and confidence level is: " + confidence);
        t.setText("You are : " + cur + ", Recording: " + label + "next" + prev);
        if (cur.equals("Unknown") && !label.equals("Unknown"))
            cur = label;
        if (!prev.contains(cur) && prev.size() >= 10)
        {
            if (ContextCompat.checkSelfPermission(con,
                    Manifest.permission.ACCESS_FINE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED)
            {
                ActivityCompat.requestPermissions((Activity) con,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_LOCATION);
            }
            else
            {
                Toast.makeText(con, "prev doesnt have label and permissions good", Toast.LENGTH_LONG);
                fusedLocationClient.getLastLocation()
                        .addOnSuccessListener(new OnSuccessListener<Location>() {
                            @Override
                            public void onSuccess(Location location) {
                                // GPS location can be null if GPS is switched off
                                Toast.makeText(con, "SUCCESS", Toast.LENGTH_LONG);
                                if (location != null) {
                                    Toast.makeText(con, "NOT NULL", Toast.LENGTH_LONG);
                                    double eLong = location.getLongitude();
                                    double eLat = location.getLatitude();
                                    int hr = cal.get(Calendar.HOUR_OF_DAY);
                                    int min = cal.get(Calendar.MINUTE);
                                    test.setText(hr + ":" + min + ": You are at: " + sLat + " , " + sLong);
                                    if (!cur.equals("Unknown") && !cur.equals("Still") && !close(sHour, sMin, hr, min))
                                        addTrip(sLat,sLong,eLat,eLong,sHour,sMin,hr,min, cur);

                                    Toast.makeText(con, "SHOULDVE RUN", Toast.LENGTH_LONG);

                                    sLong = location.getLongitude();
                                    sLat = location.getLatitude();
                                    sHour = cal.get(Calendar.HOUR_OF_DAY);
                                    sMin = cal.get(Calendar.MINUTE);
                                    starttime = (new Date()).getTime();

                                }
                            }
                        });
                prev.clear();
                prev.add(label);
                cur = label;
            }
        }
        else
        {
            if (prev.size() == 10)
                prev.remove(0);
            prev.add(label);
        }
    }
    public boolean close(int sHr, int sMin, int eHr, int eMin)
    {
        if (eHr < sHr)
            eHr += 24;
        int fir = sHr * 60 + sMin;
        int sec = eHr * 60 + eMin;
        if (sec - fir < 3)
            return true;
        return false;
    }
    public void addTrip(double sLat, double sLong, double eLat, double eLong, int sHr, int sMin, int eHr, int eMin, String type, long st, long en)

        Trip trip = new Trip();
        trip.setStartlat(sLat);
        trip.setEndlat(eLat);
        trip.setStartlng(sLong);
        trip.setEndlng(eLong);
        if(!type.equals("on_bicycle")){
            trip.setType(1);
        }
        else trip.setType(4);
        trip.setStarttime(st);
        trip.setEndtime(en);
        trip.setStarthour(sHr);
        trip.setStartmin(sMin);
        trip.setEndhour(eHr);
        trip.setEndmin(eMin);

        if(getRouteKey(eLat, eLong,sLat,sLong)==null){
            Route r = new Route();
            r.setEndlat(eLat);
            r.setEndlng(eLong);
            r.setStartlat(sLat);
            r.setStartlng(sLong);
            r.setOccurances(1);
            r.setRouteID(UUID.randomUUID().toString());
            daoSession.getRouteDao().insert(r);
            trip.setRouteID(r.getRouteID());
        }
        else
            trip.setRouteID(getRouteKey(eLat, eLong,sLat,sLong));

        daoSession.getTripDao().insert(trip);

    }

    public String getRouteKey(double elat, double elng,double slat, double slng){
        List<Route> routes = daoSession.getRouteDao().loadAll();
        for(Route r: routes){
            double a = r.getEndlat()-elat;
            double c = r.getStartlat()-slat;
            double b = r.getStartlng()-slng;
            double d = r.getEndlng()-elng;
            if(CoinGeneratorClient.getDistanceKm(c,a,b,d)<.3){
                return r.getRouteID();
            }
        }
        return null;
}