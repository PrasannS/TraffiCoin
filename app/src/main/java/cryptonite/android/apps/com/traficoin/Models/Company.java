package cryptonite.android.apps.com.traficoin.Models;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;

import java.util.UUID;
import org.greenrobot.greendao.annotation.Generated;
@Entity(nameInDb = "company")
public class Company {

    @Id(autoincrement = true)
    Long id;
    @Property(nameInDb = "companyID")
    String companyID;
    @Property(nameInDb = "desc")
    String desc;
    @Property(nameInDb = "name")
    String name;
    @Generated(hash = 87624212)
    public Company(Long id, String companyID, String desc, String name) {
        this.id = id;
        this.companyID = companyID;
        this.desc = desc;
        this.name = name;
    }
    @Generated(hash = 1096856789)
    public Company() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getCompanyID() {
        return this.companyID;
    }
    public void setCompanyID(String companyID) {
        this.companyID = companyID;
    }
    public String getDesc() {
        return this.desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public static Company makeCompany(String n, String d){
        String id = UUID.randomUUID().toString();
        Company c =new Company();
        c.setCompanyID(id);
        c.setDesc(d);
        c.setName(n);
        return c;
    }
}
