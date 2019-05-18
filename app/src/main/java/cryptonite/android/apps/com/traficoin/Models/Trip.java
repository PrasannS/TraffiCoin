package cryptonite.android.apps.com.traficoin.Models;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity(nameInDb = "trip")
public class Trip {
    @Id(autoincrement = true)
    Long id;
    @Property(nameInDb = "starttime")
    long starttime;
    @Property(nameInDb = "endtime")
    long endtime;
    @Property(nameInDb = "routeID")
    String routeID;
    @Generated(hash = 1282351324)
    public Trip(Long id, long starttime, long endtime, String routeID) {
        this.id = id;
        this.starttime = starttime;
        this.endtime = endtime;
        this.routeID = routeID;
    }
    @Generated(hash = 1047475835)
    public Trip() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public long getStarttime() {
        return this.starttime;
    }
    public void setStarttime(long starttime) {
        this.starttime = starttime;
    }
    public long getEndtime() {
        return this.endtime;
    }
    public void setEndtime(long endtime) {
        this.endtime = endtime;
    }
    public String getRouteID() {
        return this.routeID;
    }
    public void setRouteID(String routeID) {
        this.routeID = routeID;
    }

}
