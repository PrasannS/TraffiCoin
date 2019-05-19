
package cryptonite.android.apps.com.traficoin.TrafficSDK;

import java.io.Serializable;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FI_ implements Serializable, Parcelable
{

    @SerializedName("TMC")
    @Expose
    private TMC tMC;
    @SerializedName("SHP")
    @Expose
    private List<Object> sHP = null;
    @SerializedName("CF")
    @Expose
    private List<CF> cF = null;
    public final static Parcelable.Creator<FI_> CREATOR = new Creator<FI_>() {


        @SuppressWarnings({
            "unchecked"
        })
        public FI_ createFromParcel(Parcel in) {
            return new FI_(in);
        }

        public FI_[] newArray(int size) {
            return (new FI_[size]);
        }

    }
    ;
    private final static long serialVersionUID = -6730180442899227452L;

    protected FI_(Parcel in) {
        this.tMC = ((TMC) in.readValue((TMC.class.getClassLoader())));
        in.readList(this.sHP, (java.lang.Object.class.getClassLoader()));
        in.readList(this.cF, (CF.class.getClassLoader()));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public FI_() {
    }

    /**
     * 
     * @param tMC
     * @param sHP
     * @param cF
     */
    public FI_(TMC tMC, List<Object> sHP, List<CF> cF) {
        super();
        this.tMC = tMC;
        this.sHP = sHP;
        this.cF = cF;
    }

    public TMC getTMC() {
        return tMC;
    }

    public void setTMC(TMC tMC) {
        this.tMC = tMC;
    }

    public List<Object> getSHP() {
        return sHP;
    }

    public void setSHP(List<Object> sHP) {
        this.sHP = sHP;
    }

    public List<CF> getCF() {
        return cF;
    }

    public void setCF(List<CF> cF) {
        this.cF = cF;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(tMC);
        dest.writeList(sHP);
        dest.writeList(cF);
    }

    public int describeContents() {
        return  0;
    }

}
