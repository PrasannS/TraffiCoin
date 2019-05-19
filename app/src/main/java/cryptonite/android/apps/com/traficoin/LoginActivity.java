package cryptonite.android.apps.com.traficoin;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class LoginActivity extends Activity {
    TextView t, test;
    public static final String TAG = LoginActivity.class.getSimpleName();
    LocationTracker lc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        t = findViewById(R.id.tv);
        lc = new LocationTracker(this,getApplication());
        test = findViewById(R.id.record);
        lc.setTextView(t, test);
    }
    // register the RX and start up the ActivityDetectionService service
    @Override
    protected void onStart() {
        super.onStart();
        startService(new Intent(this, ActivityDetectionService.class));
        lc.start(this);
    }

}
