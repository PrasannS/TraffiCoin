package cryptonite.android.apps.com.traficoin;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends Activity {
    TextView t, test;
    public static final String TAG = LoginActivity.class.getSimpleName();
    LocationTracker lc;
    Button signIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        lc = new LocationTracker(this,getApplication());
        signIn = (Button)findViewById(R.id.signInBtn);
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), DashboardActivity.class);
                startActivity(i);
            }
        });
    }
    // register the RX and start up the ActivityDetectionService service
    @Override
    protected void onStart() {
        super.onStart();
        startService(new Intent(this, ActivityDetectionService.class));
        startService(new Intent(getBaseContext(), BackgroundService.class));
        lc.start(this);
    }

}
