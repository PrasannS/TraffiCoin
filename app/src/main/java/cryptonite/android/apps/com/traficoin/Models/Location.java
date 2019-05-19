package cryptonite.android.apps.com.traficoin.Models;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity(nameInDb = "location")
public class Location {

    @Id(autoincrement = true)
    Long id;
    @Property(nameInDb = "lat")
    double lat;
    @Property(nameInDb = "lng")
    double lng;
    @Property(nameInDb = "name")
    String name;
    @Property(nameInDb = "locID")
    String locID;

    @Generated(hash = 481405962)
    public Location(Long id, double lat, double lng, String name, String locID) {
        this.id = id;
        this.lat = lat;
        this.lng = lng;
        this.name = name;
        this.locID = locID;
    }
    @Generated(hash = 375979639)
    public Location() {
    }
    public double getLat() {
        return this.lat;
    }
    public void setLat(double lat) {
        this.lat = lat;
    }
    public double getLng() {
        return this.lng;
    }
    public void setLng(double lng) {
        this.lng = lng;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLocID() {
        return this.locID;
    }
    public void setLocID(String locID) {
        this.locID = locID;
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }

}
