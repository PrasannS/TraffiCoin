
package cryptonite.android.apps.com.traficoin.TrafficSDK;

import java.io.Serializable;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RW implements Serializable, Parcelable
{

    @SerializedName("RW")
    @Expose
    private List<RW_> rW = null;
    @SerializedName("TY")
    @Expose
    private String tY;
    @SerializedName("MAP_VERSION")
    @Expose
    private String mAPVERSION;
    @SerializedName("EBU_COUNTRY_CODE")
    @Expose
    private String eBUCOUNTRYCODE;
    @SerializedName("EXTENDED_COUNTRY_CODE")
    @Expose
    private String eXTENDEDCOUNTRYCODE;
    @SerializedName("TABLE_ID")
    @Expose
    private String tABLEID;
    @SerializedName("UNITS")
    @Expose
    private String uNITS;
    public final static Parcelable.Creator<RW> CREATOR = new Creator<RW>() {


        @SuppressWarnings({
            "unchecked"
        })
        public RW createFromParcel(Parcel in) {
            return new RW(in);
        }

        public RW[] newArray(int size) {
            return (new RW[size]);
        }

    }
    ;
    private final static long serialVersionUID = 7707497364357318141L;

    protected RW(Parcel in) {
        in.readList(this.rW, (cryptonite.android.apps.com.traficoin.RW_.class.getClassLoader()));
        this.tY = ((String) in.readValue((String.class.getClassLoader())));
        this.mAPVERSION = ((String) in.readValue((String.class.getClassLoader())));
        this.eBUCOUNTRYCODE = ((String) in.readValue((String.class.getClassLoader())));
        this.eXTENDEDCOUNTRYCODE = ((String) in.readValue((String.class.getClassLoader())));
        this.tABLEID = ((String) in.readValue((String.class.getClassLoader())));
        this.uNITS = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public RW() {
    }

    /**
     * 
     * @param tABLEID
     * @param eXTENDEDCOUNTRYCODE
     * @param uNITS
     * @param mAPVERSION
     * @param rW
     * @param eBUCOUNTRYCODE
     * @param tY
     */
    public RW(List<RW_> rW, String tY, String mAPVERSION, String eBUCOUNTRYCODE, String eXTENDEDCOUNTRYCODE, String tABLEID, String uNITS) {
        super();
        this.rW = rW;
        this.tY = tY;
        this.mAPVERSION = mAPVERSION;
        this.eBUCOUNTRYCODE = eBUCOUNTRYCODE;
        this.eXTENDEDCOUNTRYCODE = eXTENDEDCOUNTRYCODE;
        this.tABLEID = tABLEID;
        this.uNITS = uNITS;
    }

    public List<RW_> getRW() {
        return rW;
    }

    public void setRW(List<RW_> rW) {
        this.rW = rW;
    }

    public String getTY() {
        return tY;
    }

    public void setTY(String tY) {
        this.tY = tY;
    }

    public String getMAPVERSION() {
        return mAPVERSION;
    }

    public void setMAPVERSION(String mAPVERSION) {
        this.mAPVERSION = mAPVERSION;
    }

    public String getEBUCOUNTRYCODE() {
        return eBUCOUNTRYCODE;
    }

    public void setEBUCOUNTRYCODE(String eBUCOUNTRYCODE) {
        this.eBUCOUNTRYCODE = eBUCOUNTRYCODE;
    }

    public String getEXTENDEDCOUNTRYCODE() {
        return eXTENDEDCOUNTRYCODE;
    }

    public void setEXTENDEDCOUNTRYCODE(String eXTENDEDCOUNTRYCODE) {
        this.eXTENDEDCOUNTRYCODE = eXTENDEDCOUNTRYCODE;
    }

    public String getTABLEID() {
        return tABLEID;
    }

    public void setTABLEID(String tABLEID) {
        this.tABLEID = tABLEID;
    }

    public String getUNITS() {
        return uNITS;
    }

    public void setUNITS(String uNITS) {
        this.uNITS = uNITS;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(rW);
        dest.writeValue(tY);
        dest.writeValue(mAPVERSION);
        dest.writeValue(eBUCOUNTRYCODE);
        dest.writeValue(eXTENDEDCOUNTRYCODE);
        dest.writeValue(tABLEID);
        dest.writeValue(uNITS);
    }

    public int describeContents() {
        return  0;
    }

}
