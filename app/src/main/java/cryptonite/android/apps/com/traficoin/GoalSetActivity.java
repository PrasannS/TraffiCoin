package cryptonite.android.apps.com.traficoin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import cryptonite.android.apps.com.traficoin.Models.DaoSession;
import cryptonite.android.apps.com.traficoin.Models.Goal;

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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal_set);
        distanceBar = (SeekBar)findViewById(R.id.distseekb);
        confirmButton = (Button) findViewById(R.id.confirmButton);
        timeBar = (SeekBar)findViewById(R.id.timeseekb);
        distancedisplay = (TextView)findViewById(R.id.distdisplay);
        cg = new CoinGeneratorClient(this);
        timedisplay = (TextView) findViewById(R.id.timedisplay);
        daoSession = ((App) getApplication()).getDaoSession();
        final double distAvg = cg.getAverage(true), timeAvg = cg.getAverage(false);
        distanceBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                distance = progress;
                distancedisplay.setText("Today's Goal: " + progress + " miles\nYou will earn " + cg.avgDist(distAvg, progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
5
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        timeBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                time = progress;
                distancedisplay.setText("Today's Goal: " + progress + " minutes\nYou will earn " + cg.avgDist(timeAvg, progress))
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
                timeGoal = new Goal();
                distGoal = new Goal();
                timeGoal.setDistance(false); timeGoal.setValue(time);
                distGoal.setDistance(true); distGoal.setValue(distance);
                daoSession.getGoalDao().insert(timeGoal);
                daoSession.getGoalDao().insert(distGoal);
            }
        });
    }

}

