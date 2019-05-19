package cryptonite.android.apps.com.traficoin;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;

public class FragmentPage extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view;
        Bundle bundle = getArguments();
        int pageNumber = bundle.getInt("pageNumber");

        view = inflater.inflate(R.layout.page_fragment_layout,container,false);
        LineChart distanceChart = view.findViewById(R.id.distanceChart);
        LineChart timeChart = view.findViewById(R.id.timeChart);
        LineChart nonDrivingTImeChart = view.findViewById(R.id.nonDrivingTimeChart);
        LineChart coinsChart = view.findViewById(R.id.coinsChart);

        return view;

    }
}
