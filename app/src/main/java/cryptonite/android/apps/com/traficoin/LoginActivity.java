package cryptonite.android.apps.com.traficoin;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends Activity {

    TextView welcome;
    Button signIn;
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
    }

}
