package cryptonite.android.apps.com.traficoin.Models;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity(nameInDb = "rating")
public class Rating {

    @Id(autoincrement = true)
    Long id;
    @Property(nameInDb = "companyID")
    String companyID;
    @Property(nameInDb = "starts")
    double starts;
    @Property(nameInDb = "commnet")
    String commnet;
    @Generated(hash = 557407004)
    public Rating(Long id, String companyID, double starts, String commnet) {
        this.id = id;
        this.companyID = companyID;
        this.starts = starts;
        this.commnet = commnet;
    }
    @Generated(hash = 573162276)
    public Rating() {
    }
    public String getCompanyID() {
        return this.companyID;
    }
    public void setCompanyID(String companyID) {
        this.companyID = companyID;
    }
    public double getStarts() {
        return this.starts;
    }
    public void setStarts(double starts) {
        this.starts = starts;
    }
    public String getCommnet() {
        return this.commnet;
    }
    public void setCommnet(String commnet) {
        this.commnet = commnet;
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }

}
