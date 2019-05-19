package cryptonite.android.apps.com.traficoin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.List;

public class StatsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);
        LineChart distanceChart = (LineChart) findViewById(R.id.distanceChart);
        List<Entry> entries = new ArrayList<Entry>();
        entries.add(new Entry(10, 10));
        entries.add(new Entry(20, 30));
        LineDataSet dataSet = new LineDataSet(entries, "Label"); // add entries to dataset
        dataSet.setColor(1);
        dataSet.setValueTextColor(1);
        LineData lineData = new LineData(dataSet);
        distanceChart.setData(lineData);
        distanceChart.invalidate();

    }
}
