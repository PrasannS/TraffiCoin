package cryptonite.android.apps.com.traficoin.Models;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity(nameInDb = "route")
public class Route {

    @Property(nameInDb = "occurances")
    int occurances;
    @Property(nameInDb = "startlat")
    double startlat;
    @Property(nameInDb = "startlng")
    double startlng;
    @Property(nameInDb = "endlat")
    double endlat;
    @Property(nameInDb = "endlng")
    double endlng;
    @Property(nameInDb = "name")
    String name;
    @Property(nameInDb = "routeID")
    String routeID;
    @Property(nameInDb = "routeCode")
    String routeCode;
    @Generated(hash = 668539427)
    public Route(int occurances, double startlat, double startlng, double endlat,
            double endlng, String name, String routeID, String routeCode) {
        this.occurances = occurances;
        this.startlat = startlat;
        this.startlng = startlng;
        this.endlat = endlat;
        this.endlng = endlng;
        this.name = name;
        this.routeID = routeID;
        this.routeCode = routeCode;
    }
    @Generated(hash = 467763370)
    public Route() {
    }
    public int getOccurances() {
        return this.occurances;
    }
    public void setOccurances(int occurances) {
        this.occurances = occurances;
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
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getRouteID() {
        return this.routeID;
    }
    public void setRouteID(String routeID) {
        this.routeID = routeID;
    }
    public String getRouteCode() {
        return this.routeCode;
    }
    public void setRouteCode(String routeCode) {
        this.routeCode = routeCode;
    }


}
