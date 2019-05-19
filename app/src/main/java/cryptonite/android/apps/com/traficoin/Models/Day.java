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
    @Property(nameInDb = "minutes")
    double minutes;
    @Property(nameInDb = "bminutes")
    double bminutes;
    @Property(nameInDb = "dayID")
    String dayID;
    @Generated(hash = 1690206404)
    public Day(Long id, String date, double miles, double minutes, double bminutes,
            String dayID) {
        this.id = id;
        this.date = date;
        this.miles = miles;
        this.minutes = minutes;
        this.bminutes = bminutes;
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
    public String getDayID() {
        return this.dayID;
    }
    public void setDayID(String dayID) {
        this.dayID = dayID;
    }
    public double getMinutes() {
        return this.minutes;
    }
    public void setMinutes(double minutes) {
        this.minutes = minutes;
    }
    public double getBminutes() {
        return this.bminutes;
    }
    public void setBminutes(double bminutes) {
        this.bminutes = bminutes;
    }

}
