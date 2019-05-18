package cryptonite.android.apps.com.traficoin.Models;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity(nameInDb = "coupon")
public class Coupon {

    @Id(autoincrement = true)
    Long id;
    @Property(nameInDb = "available")
    boolean available;
    @Property(nameInDb = "bought")
    boolean bought;
    @Property(nameInDb = "name")
    String name;
    @Property(nameInDb = "companyID")
    String companyID;
    @Property(nameInDb = "description")
    String description;
    @Property(nameInDb = "cost")
    int cost;
    @Generated(hash = 1237682705)
    public Coupon(Long id, boolean available, boolean bought, String name,
            String companyID, String description, int cost) {
        this.id = id;
        this.available = available;
        this.bought = bought;
        this.name = name;
        this.companyID = companyID;
        this.description = description;
        this.cost = cost;
    }
    @Generated(hash = 75265961)
    public Coupon() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public boolean getAvailable() {
        return this.available;
    }
    public void setAvailable(boolean available) {
        this.available = available;
    }
    public boolean getBought() {
        return this.bought;
    }
    public void setBought(boolean bought) {
        this.bought = bought;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCompanyID() {
        return this.companyID;
    }
    public void setCompanyID(String companyID) {
        this.companyID = companyID;
    }
    public String getDescription() {
        return this.description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public int getCost() {
        return this.cost;
    }
    public void setCost(int cost) {
        this.cost = cost;
    }

}
