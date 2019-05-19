package cryptonite.android.apps.com.traficoin;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Button;
import android.widget.Toast;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import cryptonite.android.apps.com.traficoin.Models.DaoSession;
import cryptonite.android.apps.com.traficoin.Models.Day;
import cryptonite.android.apps.com.traficoin.Models.Route;
import cryptonite.android.apps.com.traficoin.Models.RouteDao;
import cryptonite.android.apps.com.traficoin.Models.Traffic;
import cryptonite.android.apps.com.traficoin.TrafficSDK.CF;
import cryptonite.android.apps.com.traficoin.TrafficSDK.FI;
import cryptonite.android.apps.com.traficoin.TrafficSDK.FI_;
import cryptonite.android.apps.com.traficoin.TrafficSDK.RW;
import cryptonite.android.apps.com.traficoin.TrafficSDK.RW_;
import cryptonite.android.apps.com.traficoin.TrafficSDK.RetrofitClient;
import cryptonite.android.apps.com.traficoin.TrafficSDK.TrafficResponse;

public class BackgroundService extends Service implements RetrofitClient.TrafficListener {
    public BackgroundService() {
    }

    public List<Traffic>traffics = new ArrayList<>();
    Traffic cur = new Traffic();
    public int count=0;
    public DaoSession daoSession;
    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        daoSession = ((App)getApplication()).getDaoSession();
        //Declare the timer
        Timer t = new Timer();
//Set the schedule function and rate
        Route tempa = getRouteFromPriority();
        final int starthrs = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        final int startmins = Calendar.getInstance().get(Calendar.MINUTE);
        while (tempa!=null){
            final Route temp = tempa;
            t.scheduleAtFixedRate(new TimerTask() {
                                      @Override
                                      public void run() {
                                          //Called each time when 1000 milliseconds (1 second) (the period parameter)
                                          RetrofitClient retrofitClient = new RetrofitClient(BackgroundService.this);
                                          retrofitClient.getResponse(temp.getStartlat(), temp.getStartlng(), temp.getEndlat(), temp.getEndlng());
                                          cur.setEndhours(Calendar.HOUR_OF_DAY);
                                          cur.setEndmins(Calendar.MINUTE);
                                          cur.setStarthours(starthrs);
                                          cur.setStartmins(startmins);
                                          cur.setEndlat(temp.getEndlat());
                                          cur.setEndlng(temp.getEndlng());
                                          cur.setStartlat(temp.getStartlat());
                                          cur.setStartlng(temp.getStartlng());
                                          cur.setRouteID(getRouteKey(temp.getEndlat(),temp.getEndlng(),temp.getStartlat(),temp.getStartlng()));
                                          daoSession.getTrafficDao().insertInTx(cur);
                                          count++;
                                          if(count==49){
                                              count=0;
                                              temp.setPending(false);
                                              daoSession.update(temp);
                                          }
                                          final int starthrs = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
                                          final int startmins = Calendar.getInstance().get(Calendar.MINUTE);
                                      }
                                  },
//Set how long before to start calling the TimerTask (in milliseconds)
                    18000000,
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
        List<RW> rws = tr.getRWS();
        double d=0;
        int z=0;
        for(RW r:rws){
            List<RW_> rs = r.getRW();
            for(RW_ a:rs){
                List<FI> fis = a.getFIS();
                for(FI f:fis){
                    List<FI_> fs = f.getFI();
                    for(FI_ g:fs){
                        List<CF>cs = g.getCF();
                        for(CF c:cs){
                            d+=c.getJF();
                            z++;
                        }
                    }
                }
            }
        }
        d/=z;
        cur.setJf(d);

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

    public ArrayList<Traffic>getRushHours(ArrayList<Traffic>traffics)
    {
        int good = 0;
        double d = 0;
        for (int i = 0; i < traffics.size(); i++)
        {
            if (traffics.get(i).getJf() != -1)
            {
                good++;
                d += traffics.get(i).getJf();
            }
            else
            {
                traffics.remove(i);
                i--;
            }
        }
        if (good == 0)
            return new ArrayList<>();
        d /= good;
        int start = -1;
        boolean cont = false;
        ArrayList<Traffic> ret = new ArrayList<>();
        for (int i = 0; i < traffics.size(); i++)
        {
            if (traffics.get(i).getJf() > d)
            {
                if (!cont)
                {
                    cont = true;
                    start = i;
                }
            }
            else
            {
                if (cont && i != start + 1)
                {
                    cont = false;
                    Traffic traf = new Traffic();
                    traf.setStarthours(traffics.get(start).getStarthours());
                    traf.setStartmins(traffics.get(start).getStartmins());
                    traf.setEndhours(traffics.get(i - 1).getEndhours());
                    traf.setEndmins(traffics.get(i - 1).getEndmins());
                    ret.add(traf);
                }
            }
        }
        return ret;
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
        System.out.println("SOMETHING BAD HAPPENED WITH TRAFFIC API");

    }
}
