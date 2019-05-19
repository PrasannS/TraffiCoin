package cryptonite.android.apps.com.traficoin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class GoalSetActivity extends AppCompatActivity {

    SeekBar distanceBar;
    SeekBar timeBar;
    int distance;
    int time;
    Button confirmButton;
    TextView distancedisplay;
    TextView timedisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal_set);
        distanceBar = (SeekBar)findViewById(R.id.distseekb);
        confirmButton = (Button) findViewById(R.id.confirmButton);
        timeBar = (SeekBar)findViewById(R.id.timeseekb);
        distancedisplay = (TextView)findViewById(R.id.distdisplay);
        timedisplay = (TextView) findViewById(R.id.timedisplay);
        distanceBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                distance = progress;
                distancedisplay.setText("" + progress);
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
                timedisplay.setText("" + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
