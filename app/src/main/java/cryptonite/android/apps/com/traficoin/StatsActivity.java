package cryptonite.android.apps.com.traficoin;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import cryptonite.android.apps.com.traficoin.Models.DaoSession;
import cryptonite.android.apps.com.traficoin.Models.Day;
import cryptonite.android.apps.com.traficoin.Models.DayDao;

public class StatsActivity extends AppCompatActivity {

    public DaoSession daoSession;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);
        daoSession = ((App)getApplication()).getDaoSession();
        LineChart distanceChart = (LineChart) findViewById(R.id.distanceChart);
        loadChart(distanceChart, genList(2),incList(7));
        LineChart timeChart = (LineChart) findViewById(R.id.timeChart);
        loadChart(timeChart, genList(1),incList(7));
        LineChart nonDrivingChart = (LineChart) findViewById(R.id.nonDrivingTimeChart);
        loadChart(nonDrivingChart, genList(3),incList(7));

        ViewPager viewPager = findViewById(R.id.viewPager);
        viewPager.setOffscreenPageLimit(1);
        SwipeAdapter swipeAdapter = new SwipeAdapter(getSupportFragmentManager());
        viewPager.setAdapter(swipeAdapter);
        viewPager.setCurrentItem(0);
    }

    public List<Integer>genList(int code){
        List<Day>days = daoSession.getDayDao().queryBuilder().orderDesc(DayDao.Properties.Id).list();
        List<Integer> ans = new ArrayList<>();
        if(days.size()>=7){
            for(int i = 6; i>=0;i--){
                if(code == 1)
                    ans.add((int)days.get(i).getMinutes());
                else if (code ==2){
                    ans.add((int)days.get(i).getMiles());
                }
                else if (code ==3){
                    ans.add((int)days.get(i).getBminutes());
                }
            }
        }
        else{
            for(int i = days.size()-1; i>=0;i--){
                if(code == 1)
                    ans.add((int)days.get(i).getMinutes());
                else if (code ==2){
                    ans.add((int)days.get(i).getMiles());
                }
                else if (code ==3){
                    ans.add((int)days.get(i).getBminutes());
                }
            }
        }
        return ans;
    }

    public List<Integer>incList(int l){
        List<Integer> ans = new ArrayList<>();
        for(int i =0;i<l;i++){
            ans.add(i);
        }
        return ans;
    }


    private void loadChart(LineChart chart, List<Integer> x, List<Integer> y){
        List<Entry> entries = new ArrayList<>();
        for(int i = 0; i < x.size(); i++){
            entries.add(new Entry(x.get(i), y.get(i)));
        }
        LineDataSet dataSet = new LineDataSet(entries, "Label");
        LineData lineData = new LineData(dataSet);
        chart.setData(lineData);
        dataSet.setColor(1);
        dataSet.setValueTextColor(1);
        chart.invalidate();

    }
}
