package cryptonite.android.apps.com.traficoin;


import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.TextView;

import static cryptonite.android.apps.com.traficoin.LocationTracker.MY_PERMISSIONS_REQUEST_LOCATION;

public class LoginActivity extends Activity {

    TextView welcome;
    Button signIn;



    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
        welcome = (TextView) findViewById(R.id.welcomeTxt);
        Animation in = new AlphaAnimation(0.0f, 1.0f);
        in.setDuration(3000);
        welcome.startAnimation(in);
        signIn = (Button)findViewById(R.id.signInBtn);
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), DashboardActivity.class);
                startActivity(i);
            }
        });
        register = (Button) findViewById(R.id.toRegister);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), RegistrationActivity.class);
                startActivity(in);
            }
        });
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions((Activity) this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    MY_PERMISSIONS_REQUEST_LOCATION);
        }
    }

}
