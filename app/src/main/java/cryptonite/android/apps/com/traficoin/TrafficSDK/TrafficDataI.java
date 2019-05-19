package cryptonite.android.apps.com.traficoin.TrafficSDK;

import cryptonite.android.apps.com.traficoin.TrafficSDK.TrafficResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TrafficDataI {
    //This is format of bbox - 39.8485715,-86.0969867;39.8358934,-86.0757964
    @GET("/photos.json")
    Call<TrafficResponse> getAllPhotos(@Query("app_id")String appID,@Query("app_code")String appcode, @Query("bbox")String bbox );


}
