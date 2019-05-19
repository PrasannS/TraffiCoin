
package cryptonite.android.apps.com.traficoin.TrafficSDK;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CF implements Serializable, Parcelable
{

    @SerializedName("TY")
    @Expose
    private String tY;
    @SerializedName("SP")
    @Expose
    private double sP;
    @SerializedName("SU")
    @Expose
    private double sU;
    @SerializedName("FF")
    @Expose
    private double fF;
    @SerializedName("JF")
    @Expose
    private double jF;
    @SerializedName("CN")
    @Expose
    private double cN;
    public final static Parcelable.Creator<CF> CREATOR = new Creator<CF>() {


        @SuppressWarnings({
            "unchecked"
        })
        public CF createFromParcel(Parcel in) {
            return new CF(in);
        }

        public CF[] newArray(int size) {
            return (new CF[size]);
        }

    }
    ;
    private final static long serialVersionUID = 5138348841284674568L;

    protected CF(Parcel in) {
        this.tY = ((String) in.readValue((String.class.getClassLoader())));
        this.sP = ((double) in.readValue((double.class.getClassLoader())));
        this.sU = ((double) in.readValue((double.class.getClassLoader())));
        this.fF = ((double) in.readValue((double.class.getClassLoader())));
        this.jF = ((double) in.readValue((double.class.getClassLoader())));
        this.cN = ((double) in.readValue((double.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public CF() {
    }

    /**
     * 
     * @param sP
     * @param fF
     * @param cN
     * @param jF
     * @param sU
     * @param tY
     */
    public CF(String tY, double sP, double sU, double fF, double jF, double cN) {
        super();
        this.tY = tY;
        this.sP = sP;
        this.sU = sU;
        this.fF = fF;
        this.jF = jF;
        this.cN = cN;
    }

    public String getTY() {
        return tY;
    }

    public void setTY(String tY) {
        this.tY = tY;
    }

    public double getSP() {
        return sP;
    }

    public void setSP(double sP) {
        this.sP = sP;
    }

    public double getSU() {
        return sU;
    }

    public void setSU(double sU) {
        this.sU = sU;
    }

    public double getFF() {
        return fF;
    }

    public void setFF(double fF) {
        this.fF = fF;
    }

    public double getJF() {
        return jF;
    }

    public void setJF(double jF) {
        this.jF = jF;
    }

    public double getCN() {
        return cN;
    }

    public void setCN(double cN) {
        this.cN = cN;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(tY);
        dest.writeValue(sP);
        dest.writeValue(sU);
        dest.writeValue(fF);
        dest.writeValue(jF);
        dest.writeValue(cN);
    }

    public int describeContents() {
        return  0;
    }

}
