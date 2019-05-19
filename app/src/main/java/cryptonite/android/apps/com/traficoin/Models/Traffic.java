package cryptonite.android.apps.com.traficoin.Models;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity(nameInDb = "traffic")
public class Traffic {

    @Property(nameInDb = "rushour")
    boolean rushour;
    @Property(nameInDb = "startlat")
    double startlat;
    @Property(nameInDb = "startlng")
    double startlng;
    @Property(nameInDb = "endlat")
    double endlat;
    @Property(nameInDb = "endlng")
    double endlng;
    @Property(nameInDb = "starthours")
    double starthours;
    @Property(nameInDb = "startmins")
    double startmins;
    @Property(nameInDb = "endhours")
    double endhours;
    @Property(nameInDb = "endmins")
    double endmins;
    @Property(nameInDb = "jf")
    double jf;
    @Property(nameInDb = "routeid")
    String routeID;
    @Id(autoincrement = true)
    Long Id;
    @Generated(hash = 834821133)
    public Traffic(boolean rushour, double startlat, double startlng, double endlat,
            double endlng, double starthours, double startmins, double endhours,
            double endmins, double jf, String routeID, Long Id) {
        this.rushour = rushour;
        this.startlat = startlat;
        this.startlng = startlng;
        this.endlat = endlat;
        this.endlng = endlng;
        this.starthours = starthours;
        this.startmins = startmins;
        this.endhours = endhours;
        this.endmins = endmins;
        this.jf = jf;
        this.routeID = routeID;
        this.Id = Id;
    }
    @Generated(hash = 108881503)
    public Traffic() {
    }
    public double getStarthours() {
        return this.starthours;
    }
    public void setStarthours(double starthours) {
        this.starthours = starthours;
    }
    public double getStartmins() {
        return this.startmins;
    }
    public void setStartmins(double startmins) {
        this.startmins = startmins;
    }
    public double getEndhours() {
        return this.endhours;
    }
    public void setEndhours(double endhours) {
        this.endhours = endhours;
    }
    public double getEndmins() {
        return this.endmins;
    }
    public void setEndmins(double endmins) {
        this.endmins = endmins;
    }
    public String getRouteID() {
        return this.routeID;
    }
    public void setRouteID(String routeID) {
        this.routeID = routeID;
    }
    public Long getId() {
        return this.Id;
    }
    public void setId(Long Id) {
        this.Id = Id;
    }
    public double getJf() {
        return this.jf;
    }
    public void setJf(double jf) {
        this.jf = jf;
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
    public boolean getRushour() {
        return this.rushour;
    }
    public void setRushour(boolean rushour) {
        this.rushour = rushour;
    }
}
