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
    @Property(nameInDb = "checked")
    boolean checked;
    @Property(nameInDb = "startlat")
    double startlat;
    @Property(nameInDb = "startlng")
    double startlng;
    @Property(nameInDb = "endlat")
    double endlat;
    @Property(nameInDb = "endlng")
    double endlng;
    @Property(nameInDb = "type")
    double type;

    @Generated(hash = 628117037)
    public Trip(Long id, long starttime, long endtime, String routeID,
            boolean checked, double startlat, double startlng, double endlat,
            double endlng, double type) {
        this.id = id;
        this.starttime = starttime;
        this.endtime = endtime;
        this.routeID = routeID;
        this.checked = checked;
        this.startlat = startlat;
        this.startlng = startlng;
        this.endlat = endlat;
        this.endlng = endlng;
        this.type = type;
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
    public boolean getChecked() {
        return this.checked;
    }
    public void setChecked(boolean checked) {
        this.checked = checked;
    }
    public double getStartlat() {
        return this.startlat;
    }
    public void setStartlat(double startlat) {
        this.startlat = startlat;
    }
    public double getStartlng() {
        return this.startlng;
    }
    public void setStartlng(double startlng) {
        this.startlng = startlng;
    }
    public double getEndlat() {
        return this.endlat;
    }
    public void setEndlat(double endlat) {
        this.endlat = endlat;
    }
    public double getEndlng() {
        return this.endlng;
    }
    public void setEndlng(double endlng) {
        this.endlng = endlng;
    }
    public double getType() {
        return this.type;
    }
    public void setType(double type) {
        this.type = type;
    }

}
