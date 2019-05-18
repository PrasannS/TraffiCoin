package cryptonite.android.apps.com.traficoin.Models;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity(nameInDb = "transaction")
public class Transaction {
    @Id(autoincrement = true)
    Long id;
    @Property(nameInDb = "cost")
    int cost;
    @Property(nameInDb = "timestamp")
    long timestamp;
    @Generated(hash = 1693004828)
    public Transaction(Long id, int cost, long timestamp) {
        this.id = id;
        this.cost = cost;
        this.timestamp = timestamp;
    }
    @Generated(hash = 750986268)
    public Transaction() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public int getCost() {
        return this.cost;
    }
    public void setCost(int cost) {
        this.cost = cost;
    }
    public long getTimestamp() {
        return this.timestamp;
    }
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

}
