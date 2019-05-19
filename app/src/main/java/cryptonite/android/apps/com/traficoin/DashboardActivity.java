package cryptonite.android.apps.com.traficoin;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class DashboardActivity extends AppCompatActivity {

    Button distButton;
    Button timeButton;
    LocationTracker lc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        lc = new LocationTracker();
        distButton = (Button) findViewById(R.id.setDistanceGoalBtn);
        timeButton = (Button) findViewById(R.id.setTimeGoalBtn);
        distButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), GoalSetActivity.class);
                startActivity(i);
            }
        });
        timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), GoalSetActivity.class);
                startActivity(i);
            }
        });

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomBar);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.dashboard:
                        Intent i = new Intent(getApplicationContext(), DashboardActivity.class);
                        startActivity(i);
                        break;
                    case R.id.statistics:
                        Intent in = new Intent(getApplicationContext(), StatsActivity.class);
                        startActivity(in);
                        break;
                    case R.id.profile:
                        Intent inte = new Intent(getApplicationContext(), profile.class);
                        startActivity(inte);
                        break;
                }
                return true ;
            }
        });

    }
    @Override
    protected void onStart() {
        super.onStart();
        startService(new Intent(this, ActivityDetectionService.class));
        lc.start(this);
    }
}
