package cryptonite.android.apps.com.traficoin.TrafficSDK;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit retrofit;
    private static final String BASE_URL = "https://traffic.api.here.com/traffic/6.2/";
    TrafficListener tl;

    public interface TrafficListener{
        public void onTrafficResponse(TrafficResponse tr);
        public void onTrafficFailure();
    }

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;

    }

    public RetrofitClient(TrafficListener trafl){
        tl = trafl;
    }

    public void getResponse(double sl, double el, double slng, double elgn){
        TrafficDataI service = RetrofitClient.getRetrofitInstance().create(TrafficDataI.class);
        Call<TrafficResponse> call = service.getAllPhotos("TjrmXLYTiiibj0kKJSpl", "EK_Jgfo4gqt96u8n2g4G3Q", sl+","+slng+";"+el+","+elgn);
        call.enqueue(new Callback<TrafficResponse>() {
            @Override
            public void onResponse(Call<TrafficResponse> call, Response<TrafficResponse> response) {
                tl.onTrafficResponse(response.body());
            }

            @Override
            public void onFailure(Call<TrafficResponse> call, Throwable t) {
                tl.onTrafficFailure();
            }
        });
    }
}
