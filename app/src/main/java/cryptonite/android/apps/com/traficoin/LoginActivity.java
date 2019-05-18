package cryptonite.android.apps.com.traficoin;

import com.google.android.gms.location.DetectedActivity;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    TextView t, test;
    public static final String TAG = LoginActivity.class.getSimpleName();
    LocationTracker lc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        t = findViewById(R.id.tv);
        lc = new LocationTracker(this);
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
