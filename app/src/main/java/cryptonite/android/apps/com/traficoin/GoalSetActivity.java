package cryptonite.android.apps.com.traficoin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import cryptonite.android.apps.com.traficoin.Models.DaoSession;
import cryptonite.android.apps.com.traficoin.Models.Goal;
import cryptonite.android.apps.com.traficoin.Models.GoalDao;

public class GoalSetActivity extends AppCompatActivity {

    SeekBar distanceBar;
    SeekBar timeBar;
    int distance;
    int time;
    Button confirmButton;
    TextView distancedisplay;
    TextView timedisplay;
    public Goal distGoal, timeGoal;
    public DaoSession daoSession;
    private CoinGeneratorClient cg;
    public LocationTracker lt;

    public String getDay(long ts){
        Date date = new Date(ts);
        // format of the date
        SimpleDateFormat jdf = new SimpleDateFormat("yyyy-MM-dd");
        jdf.setTimeZone(TimeZone.getTimeZone("GMT-4"));
        String java_date = jdf.format(date);
        return java_date;
    }

    public Goal getLatestGoal(int ind){
        if(daoSession.getGoalDao().loadAll().size()==0)
            return null;
        return daoSession.getGoalDao().queryBuilder().orderDesc(GoalDao.Properties.Timestamp).list().get(ind);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal_set);
        distanceBar = (SeekBar)findViewById(R.id.distseekb);
        confirmButton = (Button) findViewById(R.id.confirmButton);
        timeBar = (SeekBar)findViewById(R.id.timeseekb);
        distancedisplay = (TextView)findViewById(R.id.distdisplay);

        lt = new LocationTracker(this,getApplication());
        distanceBar.setMax(39);
        timeBar.setMax(57);
        cg = new CoinGeneratorClient(getApplication());

        timedisplay = (TextView) findViewById(R.id.timedisplay);
        daoSession = ((App) getApplication()).getDaoSession();
        final double distAvg = cg.getAverage(true), timeAvg = cg.getAverage(false);
        //TODO This is where the minutes from rush hour will go
        distanceBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                distance = progress;
                distancedisplay.setText("Today's Goal: " + progress + " miles\nYou will earn " + (int) (cg.avgDist(distAvg, progress) * 100) / 100.0 + " coins");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        timeBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                time = progress;
                timedisplay.setText("Today's Goal: " + progress + " minutes\nYou will earn " + (int) (cg.avgDist(timeAvg, progress) * 100) / 100.0 + " coins");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean f = true;
                Goal g = getLatestGoal(0);
                if(g!=null){
                    if(getDay((new Date()).getTime()).equals(getDay(g.getTimestamp()))){
                        f = false;
                    }
                }

                if(f) {
                    timeGoal = new Goal();
                    distGoal = new Goal();
                    timeGoal.setDistance(false);
                    timeGoal.setValue(time);
                    distGoal.setDistance(true);
                    distGoal.setValue(distance);
                    distGoal.setTimestamp((new Date()).getTime());
                    timeGoal.setTimestamp((new Date()).getTime());
                    daoSession.getGoalDao().insert(timeGoal);
                    daoSession.getGoalDao().insert(distGoal);
                    cg.getCoins(getLatestGoal(1).getValue(), getLatestGoal(0).getValue(), lt.getRushMinutes());
                }
                else
                    Toast.makeText(GoalSetActivity.this, "Sorry, you have already set a goal today.", Toast.LENGTH_LONG).show();

                Intent intent = new Intent(GoalSetActivity.this, DashboardActivity.class);
                startActivity(intent);
            }
        });
    }

}

