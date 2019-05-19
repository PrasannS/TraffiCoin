
package cryptonite.android.apps.com.traficoin.TrafficSDK;

import java.io.Serializable;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TrafficResponse implements Serializable, Parcelable
{

    @SerializedName("RWS")
    @Expose
    private List<RW> rWS = null;
    @SerializedName("MAP_VERSION")
    @Expose
    private String mAPVERSION;
    @SerializedName("CREATED_TIMESTAMP")
    @Expose
    private String cREATEDTIMESTAMP;
    @SerializedName("VERSION")
    @Expose
    private String vERSION;
    @SerializedName("UNITS")
    @Expose
    private String uNITS;
    public final static Parcelable.Creator<TrafficResponse> CREATOR = new Creator<TrafficResponse>() {


        @SuppressWarnings({
            "unchecked"
        })
        public TrafficResponse createFromParcel(Parcel in) {
            return new TrafficResponse(in);
        }

        public TrafficResponse[] newArray(int size) {
            return (new TrafficResponse[size]);
        }

    }
    ;
    private final static long serialVersionUID = -7364554065570595035L;

    protected TrafficResponse(Parcel in) {
        in.readList(this.rWS, (RW.class.getClassLoader()));
        this.mAPVERSION = ((String) in.readValue((String.class.getClassLoader())));
        this.cREATEDTIMESTAMP = ((String) in.readValue((String.class.getClassLoader())));
        this.vERSION = ((String) in.readValue((String.class.getClassLoader())));
        this.uNITS = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public TrafficResponse() {
    }

    /**
     * 
     * @param vERSION
     * @param rWS
     * @param cREATEDTIMESTAMP
     * @param uNITS
     * @param mAPVERSION
     */
    public TrafficResponse(List<RW> rWS, String mAPVERSION, String cREATEDTIMESTAMP, String vERSION, String uNITS) {
        super();
        this.rWS = rWS;
        this.mAPVERSION = mAPVERSION;
        this.cREATEDTIMESTAMP = cREATEDTIMESTAMP;
        this.vERSION = vERSION;
        this.uNITS = uNITS;
    }

    public List<RW> getRWS() {
        return rWS;
    }

    public void setRWS(List<RW> rWS) {
        this.rWS = rWS;
    }

    public String getMAPVERSION() {
        return mAPVERSION;
    }

    public void setMAPVERSION(String mAPVERSION) {
        this.mAPVERSION = mAPVERSION;
    }

    public String getCREATEDTIMESTAMP() {
        return cREATEDTIMESTAMP;
    }

    public void setCREATEDTIMESTAMP(String cREATEDTIMESTAMP) {
        this.cREATEDTIMESTAMP = cREATEDTIMESTAMP;
    }

    public String getVERSION() {
        return vERSION;
    }

    public void setVERSION(String vERSION) {
        this.vERSION = vERSION;
    }

    public String getUNITS() {
        return uNITS;
    }

    public void setUNITS(String uNITS) {
        this.uNITS = uNITS;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(rWS);
        dest.writeValue(mAPVERSION);
        dest.writeValue(cREATEDTIMESTAMP);
        dest.writeValue(vERSION);
        dest.writeValue(uNITS);
    }

    public int describeContents() {
        return  0;
    }

}
