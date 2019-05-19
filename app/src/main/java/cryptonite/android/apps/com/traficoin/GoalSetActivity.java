package cryptonite.android.apps.com.traficoin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import cryptonite.android.apps.com.traficoin.Models.Goal;

public class GoalSetActivity extends AppCompatActivity {

    SeekBar distanceBar;
    SeekBar timeBar;
    int distance;
    int time;
    TextView distancedisplay;
    TextView timedisplay;
    Goal dailyDistGoal, dailyTimeGoal;
    Button confirmBut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal_set);
        distanceBar = (SeekBar)findViewById(R.id.distseekb);
        confirmBut = (Button) findViewById(R.id.confirmbutton);
        distanceBar.setMax(39);
        timeBar = (SeekBar)findViewById(R.id.timeseekb);
        timeBar.setMax(57);
        distancedisplay = (TextView)findViewById(R.id.distdisplay);
        timedisplay = (TextView) findViewById(R.id.timedisplay);
        dailyDistGoal = new Goal();
        dailyTimeGoal = new Goal();
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
        confirmBut.setOnClickListener();
    }
    
}
