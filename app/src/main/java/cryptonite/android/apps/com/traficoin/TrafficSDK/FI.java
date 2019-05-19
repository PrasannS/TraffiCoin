
package cryptonite.android.apps.com.traficoin.TrafficSDK;

import java.io.Serializable;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FI implements Serializable, Parcelable
{

    @SerializedName("FI")
    @Expose
    private List<FI_> fI = null;
    public final static Parcelable.Creator<FI> CREATOR = new Creator<FI>() {


        @SuppressWarnings({
            "unchecked"
        })
        public FI createFromParcel(Parcel in) {
            return new FI(in);
        }

        public FI[] newArray(int size) {
            return (new FI[size]);
        }

    }
    ;
    private final static long serialVersionUID = -4669121338302995966L;

    protected FI(Parcel in) {
        in.readList(this.fI, (FI.class.getClassLoader()));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public FI() {
    }

    /**
     * 
     * @param fI
     */
    public FI(List<FI_> fI) {
        super();
        this.fI = fI;
    }

    public List<FI_> getFI() {
        return fI;
    }

    public void setFI(List<FI_> fI) {
        this.fI = fI;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(fI);
    }

    public int describeContents() {
        return  0;
    }

}
