package cryptonite.android.apps.com.traficoin.Models;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity(nameInDb = "preferences")
public class Preferences {
    @Id(autoincrement = true)
    Long id;
    @Property(nameInDb = "goalLocked")
    public boolean goalLocked;
    @Property(nameInDb = "timestamp")
    public long timestamp;
    @Generated(hash = 1025294464)
    public Preferences(Long id, boolean goalLocked, long timestamp) {
        this.id = id;
        this.goalLocked = goalLocked;
        this.timestamp = timestamp;
    }
    @Generated(hash = 81438259)
    public Preferences() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public boolean getGoalLocked() {
        return this.goalLocked;
    }
    public void setGoalLocked(boolean goalLocked) {
        this.goalLocked = goalLocked;
    }
    public long getTimestamp() {
        return this.timestamp;
    }
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

}
