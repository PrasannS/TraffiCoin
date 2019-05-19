package cryptonite.android.apps.com.traficoin.Models;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity(nameInDb = "traffic")
public class Traffic {

    @Property(nameInDb = "starthours")
    double starthours;
    @Property(nameInDb = "startmins")
    double startmins;
    @Property(nameInDb = "endhours")
    double endhours;
    @Property(nameInDb = "endmins")
    double endmins;
    @Property(nameInDb = "rf")
    double rf;
    @Property(nameInDb = "routeid")
    String routeID;
    @Id(autoincrement = true)
    Long Id;
    @Generated(hash = 1159270496)
    public Traffic(double starthours, double startmins, double endhours,
            double endmins, double rf, String routeID, Long Id) {
        this.starthours = starthours;
        this.startmins = startmins;
        this.endhours = endhours;
        this.endmins = endmins;
        this.rf = rf;
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
    public double getRf() {
        return this.rf;
    }
    public void setRf(double rf) {
        this.rf = rf;
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
}
