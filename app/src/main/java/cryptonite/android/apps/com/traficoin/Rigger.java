package cryptonite.android.apps.com.traficoin;

import android.content.Context;

import java.util.ArrayList;

import cryptonite.android.apps.com.traficoin.Models.DaoSession;
import cryptonite.android.apps.com.traficoin.Models.Trip;

public class Rigger {

    public Context context;
    public DaoSession daoSession;

    public Rigger(Context c){
        context = c;
        daoSession = ((App)context).getDaoSession();
    }

    public void InsertRandomTrips(){

    }
    /*
    * ip(Long id, long starttime, long endtime, String routeID,
            boolean checked, double startlat, double startlng, double endlat,
            double endlng, double type, int starthour, int startmin, int endhour,
            int endmin) {
    *
    *
    *
    * */

    public Trip randomTripGen(){
        return new Trip(Long.valueOf(40),2948,294824,"awroig23d2aq32",false,440.293852,435.230843223,-24592398.324,2497554.3487,4,42,45,43,59);
    }
    
    
    

}
