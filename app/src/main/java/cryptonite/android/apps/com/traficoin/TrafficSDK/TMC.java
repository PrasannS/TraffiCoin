
package cryptonite.android.apps.com.traficoin.TrafficSDK;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TMC implements Serializable, Parcelable
{

    @SerializedName("PC")
    @Expose
    private int pC;
    @SerializedName("DE")
    @Expose
    private String dE;
    @SerializedName("QD")
    @Expose
    private String qD;
    @SerializedName("LE")
    @Expose
    private double lE;
    public final static Parcelable.Creator<TMC> CREATOR = new Creator<TMC>() {


        @SuppressWarnings({
            "unchecked"
        })
        public TMC createFromParcel(Parcel in) {
            return new TMC(in);
        }

        public TMC[] newArray(int size) {
            return (new TMC[size]);
        }

    }
    ;
    private final static long serialVersionUID = -1569619899842186104L;

    protected TMC(Parcel in) {
        this.pC = ((int) in.readValue((int.class.getClassLoader())));
        this.dE = ((String) in.readValue((String.class.getClassLoader())));
        this.qD = ((String) in.readValue((String.class.getClassLoader())));
        this.lE = ((double) in.readValue((double.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public TMC() {
    }

    /**
     * 
     * @param pC
     * @param lE
     * @param qD
     * @param dE
     */
    public TMC(int pC, String dE, String qD, double lE) {
        super();
        this.pC = pC;
        this.dE = dE;
        this.qD = qD;
        this.lE = lE;
    }

    public int getPC() {
        return pC;
    }

    public void setPC(int pC) {
        this.pC = pC;
    }

    public String getDE() {
        return dE;
    }

    public void setDE(String dE) {
        this.dE = dE;
    }

    public String getQD() {
        return qD;
    }

    public void setQD(String qD) {
        this.qD = qD;
    }

    public double getLE() {
        return lE;
    }

    public void setLE(double lE) {
        this.lE = lE;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(pC);
        dest.writeValue(dE);
        dest.writeValue(qD);
        dest.writeValue(lE);
    }

    public int describeContents() {
        return  0;
    }

}
