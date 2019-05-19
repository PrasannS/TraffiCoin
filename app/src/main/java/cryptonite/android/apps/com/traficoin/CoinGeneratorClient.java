package cryptonite.android.apps.com.traficoin;

import android.content.Context;

import org.greenrobot.greendao.query.QueryBuilder;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import cryptonite.android.apps.com.traficoin.Models.DaoSession;
import cryptonite.android.apps.com.traficoin.Models.Day;
import cryptonite.android.apps.com.traficoin.Models.Route;
import cryptonite.android.apps.com.traficoin.Models.Transaction;
import cryptonite.android.apps.com.traficoin.Models.Trip;
import cryptonite.android.apps.com.traficoin.Models.TripDao;

public class CoinGeneratorClient {

    //Avg Mileage: 39 miles
    //Avg Time: 57 minutes

    DaoSession daoSession;
    Context context;

    public CoinGeneratorClient(Context c){
        context = c;
          daoSession = ((App)context).getDaoSession();
    }

    public void runTransaction(int val){
        Transaction t = new Transaction();
        t.setCost(val);
        Date date= new Date();
        t.setTimestamp(date.getTime());
        daoSession.getTransactionDao().insert(t);
    }

    public void getCoins(int timegoal, int disgoal, int rd){
        List<Day>days=new ArrayList<>();
        String temp = "";
        while(temp!=null){
            temp = getLastDay();
            days.add(getNewDay(temp));
        }
        for(Day d: days){
            double sum = avgCoins(timegoal, disgoal, d.getMiles(), d.getMinutes())+bikeCoins((int)d.getBminutes())+rushCoins(rd);
            runTransaction((int)sum);
        }


    }

    public double bikeCoins(int bikemins){
        return 2.5*rushCoins(bikemins);
    }

    public double avgMins(double mins,int tg){
        double b  = 57*4/mins;
        return Math.pow(50*(1/1.1),(tg+b));
    }

    public double avgDist(double mins,int tg){
        double b  = 39*4/mins;
        return Math.pow(50*(1/1.1),(tg+b));
    }

    public double avgCoins(int timegoal, int disgoal,double avgt, double avgm){
        return (avgMins(avgt,timegoal)+avgDist(avgm,disgoal))/2;
    }

    public double rushCoins(int rushDiff){
        return Math.max(0.4*((Math.log(rushDiff))/(Math.log(2))),0);
    }

    //type bike = type 4
    public Day getNewDay(String day){
        int totalm = 0;
        int totalmiles = 0;
        int totalbikes = 0;
        List<Trip>trips = daoSession.getTripDao().queryBuilder().where(TripDao.Properties.Checked.eq(false)).orderAsc(TripDao.Properties.Id).list();
        boolean start=false;
        for(Trip cur: trips){
            if(!start&&day.equals(getDay(cur.getStarttime()))&&cur.getType()!=4){
                start=true;
                totalm+= TimeUnit.MILLISECONDS.toMinutes(cur.getEndtime()-cur.getStarttime());
                totalmiles+= getD(cur.getEndlat(), cur.getStartlat(), cur.getEndlat(), cur.getEndlng());
                cur.setChecked(true);
                daoSession.getTripDao().update(cur);
                Route r = getRoutefromID(cur.getRouteID());
                r.setOccurances(r.getOccurances()+1);
                daoSession.getRouteDao().update(r);
            }
            else if(day.equals(getDay(cur.getStarttime()))&&cur.getType()!=4){
                totalm+= TimeUnit.MILLISECONDS.toMinutes(cur.getEndtime()-cur.getStarttime());
                totalmiles+= getD(cur.getEndlat(), cur.getStartlat(), cur.getEndlat(), cur.getEndlng());
                cur.setChecked(true);
                daoSession.getTripDao().update(cur);
                Route r = getRoutefromID(cur.getRouteID());
                r.setOccurances(r.getOccurances()+1);
                daoSession.getRouteDao().update(r);
            }
            else if(day.equals(getDay(cur.getStarttime()))&&cur.getType()!=4){
                cur.setChecked(true);
                daoSession.getTripDao().update(cur);
                Route r = getRoutefromID(cur.getRouteID());
                r.setOccurances(r.getOccurances()+1);
                daoSession.getRouteDao().update(r);
                totalbikes+=TimeUnit.MILLISECONDS.toMinutes(cur.getEndtime()-cur.getStarttime());
            }
        }
        Day d = new Day();
        d.setDate(day);
        d.setDayID(UUID.randomUUID().toString());
        d.setMiles(totalmiles);
        d.setMinutes(totalm);
        d.setBminutes(totalbikes);
        return d;
    }

    public String getLastDay(){
        List<Trip>trips = daoSession.getTripDao().queryBuilder().where(TripDao.Properties.Checked.eq(false)).orderAsc(TripDao.Properties.Id).list();
        if(trips.size()==0)return null;
        else return getDay(trips.get(0).getStarttime());
    }

    public Route getRoutefromID(String rid){
        List<Route> routes = daoSession.getRouteDao().loadAll();
        for(Route r: routes){
            if(r.getRouteID().equals(rid));
                return r;
        }
        return null;
    }

    public static double getD(double sLat, double oLat, double sLong, double oLong){
        return getDistanceKm(sLat, oLat, sLong, oLong)/1.6;
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

    public String getDay(long ts){
        Date date = new Date(ts);
        // format of the date
        SimpleDateFormat jdf = new SimpleDateFormat("yyyy-MM-dd");
        jdf.setTimeZone(TimeZone.getTimeZone("GMT-4"));
        String java_date = jdf.format(date);
        return java_date;
    }

    //the boolean decides whether the avg of distance or time
    public double getAverage(boolean distance){
        List<Day>days = daoSession.getDayDao().loadAll();
        double sum = 0;
        for(Day d:days){
            if(distance)
            sum+=d.getMinutes();
            else sum+=d.getMiles();
        }
        return (sum/days.size());
    }

    public double getCoinBalance(){
        List<Transaction>days = daoSession.getTransactionDao().loadAll();
        double sum = 0;
        for(Transaction d:days){
            sum+=d.getCost();
        }
        return sum;
    }




}
