package cryptonite.android.apps.com.traficoin;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Button;
import android.widget.Toast;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import cryptonite.android.apps.com.traficoin.Models.DaoSession;
import cryptonite.android.apps.com.traficoin.Models.Day;
import cryptonite.android.apps.com.traficoin.Models.Route;
import cryptonite.android.apps.com.traficoin.Models.RouteDao;
import cryptonite.android.apps.com.traficoin.Models.Traffic;
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
        Route tempa = getRouteFromPriority();
        while (tempa!=null){
            final Route temp = tempa;
            List<Traffic> traffics = new ArrayList<>();
            t.scheduleAtFixedRate(new TimerTask() {
                                      @Override
                                      public void run() {
                                          //Called each time when 1000 milliseconds (1 second) (the period parameter)
                                          RetrofitClient retrofitClient = new RetrofitClient(BackgroundService.this);
                                          retrofitClient.getResponse(temp.getStartlat(), temp.getStartlng(), temp.getEndlat(), temp.getEndlng());

                                      }
                                  },
//Set how long before to start calling the TimerTask (in milliseconds)
                    0,
//Set the amount of time between each execution (in milliseconds)
                    18000000);
        }
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

    public ArrayList<Traffic>getRushHours(ArrayList<Traffic>traffics){
        //TODO Samuel this is your method
        return null;
    }

    public Route getRouteFromPriority(){
        QueryBuilder<Route>qb  = daoSession.getRouteDao().queryBuilder().where(RouteDao.Properties.Pending.eq(false));
        List<Route> routes = qb.list();
        Route max = routes.get(0);

        for(Route r:routes){
            if(r.getOccurances()>max.getOccurances()){
                max = r;
            }
        }
        return max;

    }

    @Override
    public void onTrafficFailure() {

    }
}
