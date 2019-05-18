package cryptonite.android.apps.com.traficoin;

import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

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

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.PriorityQueue;

public class LocationTracker
{
    public static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;
    public static final String TAG = LoginActivity.class.getSimpleName();
    TextView t, test;
    String cur = "Unknown";
    ArrayList<String> prev = new ArrayList<>();
    double sLat, sLong;
    public FusedLocationProviderClient fusedLocationClient;
    int sHour, sMin;
    Context con;
    Calendar cal = Calendar.getInstance();
    public  LocationTracker() {}
    public LocationTracker(Context context)
    {
        con = context;
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
                                    if (!cur.equals("Unknown"))
                                        addTrip(sLat,sLong,eLat,eLong,sHour,sMin,hr,min, cur);

                                    Toast.makeText(con, "SHOULDVE RUN", Toast.LENGTH_LONG);

                                    sLong = location.getLongitude();
                                    sLat = location.getLatitude();
                                    sHour = cal.get(Calendar.HOUR_OF_DAY);
                                    sMin = cal.get(Calendar.MINUTE);

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
    public void addTrip(double sLat, double sLong, double eLat, double eLong, int sHr, int sMin, int eHr, int eMin, String type)
    {

    }
}