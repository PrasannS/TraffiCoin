package cryptonite.android.apps.com.traficoin.Models;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity(nameInDb = "rating")
public class Rating {

    @Property(nameInDb = "picurl")
    String companyID;
    @Property(nameInDb = "picurl")
    double starts;
    @Property(nameInDb = "picurl")
    String commnet;
    @Generated(hash = 1825399778)
    public Rating(String companyID, double starts, String commnet) {
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

}
