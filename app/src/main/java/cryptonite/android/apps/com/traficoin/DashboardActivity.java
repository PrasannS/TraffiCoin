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
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Date;

import cryptonite.android.apps.com.traficoin.Models.DaoSession;
import cryptonite.android.apps.com.traficoin.Models.Day;
import cryptonite.android.apps.com.traficoin.Models.Goal;
import cryptonite.android.apps.com.traficoin.Models.GoalDao;

public class DashboardActivity extends AppCompatActivity {
    TextView coins, goalDesc, todaysTime, todaysDist;
    Button distButton;
    LocationTracker lc;
    DaoSession mDaoSession;
    CoinGeneratorClient c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        lc = new LocationTracker(getApplicationContext(),getApplicationContext());
        c = new CoinGeneratorClient(getApplication());
        mDaoSession = ((App)getApplication()).getDaoSession();
        coins = (TextView) findViewById(R.id.coindisplay);
        todaysTime = (TextView) findViewById(R.id.tdtimedisplay);
        todaysDist = (TextView) findViewById(R.id.tddistdisplay);
        goalDesc = (TextView) findViewById(R.id.goalDesc);
        distButton = (Button) findViewById(R.id.setDistanceGoalBtn);

        distButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), GoalSetActivity.class);
                startActivity(i);
            }
        });
        long starttime = (new Date()).getTime();
        lc.setText(todaysTime,todaysDist,c);
        coins.setText(String.valueOf((int) c.getCoinBalance()));
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
                    case R.id.shop:
                        Intent inten = new Intent(getApplicationContext(), shop.class);
                        startActivity(inten);
                        break;
                }
                return true;
            }
        });
        if(getLatestGoal(0)!=null)
            goalDesc.setText("Distance Goal: \n" + getLatestGoal(0).getValue() + " miles" + "\n\n\nTime Goal: " + getLatestGoal(1).getValue() + " mins");
        lc.addTrip(60.16571,45.9479,60.12235, 41.52351, 10,2,16,12,"In_Vehicle",starttime, (new Date()).getTime());
        lc.update();

    }
    @Override
    protected void onStart() {
        super.onStart();
        startService(new Intent(this, ActivityDetectionService.class));
        lc.start(this);
    }
    public Goal getLatestGoal(int ind){
        if(mDaoSession.getGoalDao().loadAll().size()==0)
            return null;
        return mDaoSession.getGoalDao().queryBuilder().orderDesc(GoalDao.Properties.Timestamp).list().get(ind);

    }
}
