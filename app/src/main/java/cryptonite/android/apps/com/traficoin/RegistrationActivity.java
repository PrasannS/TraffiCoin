package cryptonite.android.apps.com.traficoin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegistrationActivity extends AppCompatActivity {

    Button Register;
    EditText firstname;
    EditText lastname;
    EditText email;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        firstname = (EditText)findViewById(R.id.firstname);
        lastname = (EditText)findViewById(R.id.lastname);
        email = (EditText)findViewById(R.id.email);
        password = (EditText)findViewById(R.id.password);

        Register = (Button)findViewById(R.id.confirmBtn);
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), DashboardActivity.class);
                startActivity(i);
            }
        });


    }
}
