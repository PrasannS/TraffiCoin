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

    ArrayList<Integer> sampleX = new ArrayList<>();
    ArrayList<Integer> sampleY1 = new ArrayList<>();
    ArrayList<Integer> sampleY2 = new ArrayList<>();
    ArrayList<Integer> sampleY3 = new ArrayList<>();

    public DaoSession daoSession;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);
        daoSession = ((App)getApplication()).getDaoSession();
        LineChart distanceChart = (LineChart) findViewById(R.id.distanceChart);
        loadChart("distance chart", distanceChart, genList(2),incList(7));
        LineChart timeChart = (LineChart) findViewById(R.id.timeChart);
        loadChart("time chart", timeChart, genList(1),incList(7));
        LineChart nonDrivingChart = (LineChart) findViewById(R.id.nonDrivingTimeChart);
        loadChart("non driving chart", nonDrivingChart, genList(3),incList(7));
        for(int i = 1; i < 10; i++){
            sampleX.add(i);
        }
        sampleY1.add(50);
        sampleY1.add(45);
        sampleY1.add(47);
        sampleY1.add(42);
        sampleY1.add(41);
        sampleY1.add(37);
        sampleY1.add(40);
        sampleY1.add(40);
        sampleY1.add(36);
        sampleY1.add(38);

        sampleY2.add(50);
        sampleY2.add(45);
        sampleY2.add(47);
        sampleY2.add(40);
        sampleY2.add(45);
        sampleY2.add(42);
        sampleY2.add(42);
        sampleY2.add(40);
        sampleY2.add(36);
        sampleY2.add(38);

        sampleY3.add(36);
        sampleY3.add(38);
        sampleY3.add(43);
        sampleY3.add(40);
        sampleY3.add(40);
        sampleY3.add(43);
        sampleY3.add(37);
        sampleY3.add(50);
        sampleY3.add(45);
        sampleY3.add(47);

        loadChart("distance chart", distanceChart,sampleX, sampleY1);
        loadChart("time chart", timeChart,sampleX, sampleY2);
        loadChart("non driving chart",nonDrivingChart,sampleX, sampleY3);




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


    private void loadChart(String label, LineChart chart, List<Integer> x, List<Integer> y){
        List<Entry> entries = new ArrayList<>();
        for(int i = 0; i < x.size(); i++){
            entries.add(new Entry(x.get(i), y.get(i)));
        }
        LineDataSet dataSet = new LineDataSet(entries, label);
        dataSet.setColor(R.color.redchartcolor);
        dataSet.setValueTextColor(R.color.redchartcolor);
        LineData lineData = new LineData(dataSet);
        chart.setData(lineData);
        chart.setTouchEnabled(false);

        chart.invalidate();

    }
}
