package cryptonite.android.apps.com.traficoin.Models;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity(nameInDb = "goal")
public class Goal {

    @Property(nameInDb = "distance")
    boolean distance;
    @Property(nameInDb = "value")
    int value;
    @Property(nameInDb = "timestamp")
    long timestamp;
    @Id(autoincrement = true)
    Long id;
    @Generated(hash = 773082644)
    public Goal(boolean distance, int value, long timestamp, Long id) {
        this.distance = distance;
        this.value = value;
        this.timestamp = timestamp;
        this.id = id;
    }
    @Generated(hash = 1149104271)
    public Goal() {
    }
    public boolean getDistance() {
        return this.distance;
    }
    public void setDistance(boolean distance) {
        this.distance = distance;
    }
    public int getValue() {
        return this.value;
    }
    public void setValue(int value) {
        this.value = value;
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public long getTimestamp() {
        return this.timestamp;
    }
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
    
}
