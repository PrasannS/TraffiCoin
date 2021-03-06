package cryptonite.android.apps.com.traficoin;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Button;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

import cryptonite.android.apps.com.traficoin.Models.DaoSession;
import cryptonite.android.apps.com.traficoin.TrafficSDK.RetrofitClient;
import cryptonite.android.apps.com.traficoin.TrafficSDK.TrafficResponse;

public class BackgroundService extends Service implements RetrofitClient.TrafficListener {
    public BackgroundService() {
    }

    public DaoSession daoSession;
    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        daoSession = ((App)getApplication()).getDaoSession();
        //Declare the timer
        Timer t = new Timer();
//Set the schedule function and rate
        t.scheduleAtFixedRate(new TimerTask() {
                                  @Override
                                  public void run() {
                                      //Called each time when 1000 milliseconds (1 second) (the period parameter)
                                        RetrofitClient retrofitClient = new RetrofitClient(BackgroundService.this);
                                  }
                              },
//Set how long before to start calling the TimerTask (in milliseconds)
                0,
//Set the amount of time between each execution (in milliseconds)
                18000000);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // Let it continue running until it is stopped.
        Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show();
        return START_STICKY;
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Service Destroyed", Toast.LENGTH_LONG).show();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onTrafficResponse(TrafficResponse tr) {

    }

    @Override
    public void onTrafficFailure() {

    }
}
