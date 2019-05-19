
package cryptonite.android.apps.com.traficoin.TrafficSDK;

import java.io.Serializable;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RW_ implements Serializable, Parcelable
{

    @SerializedName("FIS")
    @Expose
    private List<FI> fIS = null;
    @SerializedName("mid")
    @Expose
    private String mid;
    @SerializedName("LI")
    @Expose
    private String lI;
    @SerializedName("DE")
    @Expose
    private String dE;
    @SerializedName("PBT")
    @Expose
    private String pBT;
    public final static Parcelable.Creator<RW_> CREATOR = new Creator<RW_>() {


        @SuppressWarnings({
            "unchecked"
        })
        public RW_ createFromParcel(Parcel in) {
            return new RW_(in);
        }

        public RW_[] newArray(int size) {
            return (new RW_[size]);
        }

    }
    ;
    private final static long serialVersionUID = 6369371451837870017L;

    protected RW_(Parcel in) {
        in.readList(this.fIS, (cryptonite.android.apps.com.traficoin.FI.class.getClassLoader()));
        this.mid = ((String) in.readValue((String.class.getClassLoader())));
        this.lI = ((String) in.readValue((String.class.getClassLoader())));
        this.dE = ((String) in.readValue((String.class.getClassLoader())));
        this.pBT = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public RW_() {
    }

    /**
     * 
     * @param lI
     * @param fIS
     * @param mid
     * @param pBT
     * @param dE
     */
    public RW_(List<FI> fIS, String mid, String lI, String dE, String pBT) {
        super();
        this.fIS = fIS;
        this.mid = mid;
        this.lI = lI;
        this.dE = dE;
        this.pBT = pBT;
    }

    public List<FI> getFIS() {
        return fIS;
    }

    public void setFIS(List<FI> fIS) {
        this.fIS = fIS;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getLI() {
        return lI;
    }

    public void setLI(String lI) {
        this.lI = lI;
    }

    public String getDE() {
        return dE;
    }

    public void setDE(String dE) {
        this.dE = dE;
    }

    public String getPBT() {
        return pBT;
    }

    public void setPBT(String pBT) {
        this.pBT = pBT;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(fIS);
        dest.writeValue(mid);
        dest.writeValue(lI);
        dest.writeValue(dE);
        dest.writeValue(pBT);
    }

    public int describeContents() {
        return  0;
    }

}
