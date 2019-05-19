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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal_set);
        distanceBar = (SeekBar)findViewById(R.id.distseekb);
        confirmButton = (Button) findViewById(R.id.confirmButton);
        timeBar = (SeekBar)findViewById(R.id.timeseekb);
        distancedisplay = (TextView)findViewById(R.id.distdisplay);
        timedisplay = (TextView) findViewById(R.id.timedisplay);
        daoSession = ((App) getApplication()).getDaoSession();
        distanceBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                distance = progress;
                distancedisplay.setText("" + progress);
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
                timedisplay.setText("" + progress);
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

            }
        });
    }

}

