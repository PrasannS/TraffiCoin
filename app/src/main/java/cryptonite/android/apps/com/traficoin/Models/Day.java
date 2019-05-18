package cryptonite.android.apps.com.traficoin.Models;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity(nameInDb = "day")
public class Day {

    @Id(autoincrement = true)
    Long id;
    @Property(nameInDb = "date")
    String date;
    @Property(nameInDb = "miles")
    double miles;
    @Property(nameInDb = "hours")
    double hours;
    @Property(nameInDb = "dayID")
    String dayID;
    @Generated(hash = 1955057148)
    public Day(Long id, String date, double miles, double hours, String dayID) {
        this.id = id;
        this.date = date;
        this.miles = miles;
        this.hours = hours;
        this.dayID = dayID;
    }
    @Generated(hash = 866989762)
    public Day() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getDate() {
        return this.date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public double getMiles() {
        return this.miles;
    }
    public void setMiles(double miles) {
        this.miles = miles;
    }
    public double getHours() {
        return this.hours;
    }
    public void setHours(double hours) {
        this.hours = hours;
    }
    public String getDayID() {
        return this.dayID;
    }
    public void setDayID(String dayID) {
        this.dayID = dayID;
    }

}
