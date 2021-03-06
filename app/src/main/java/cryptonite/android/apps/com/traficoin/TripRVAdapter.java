package cryptonite.android.apps.com.traficoin;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static cryptonite.android.apps.com.traficoin.LocationTracker.TAG;

public class TripRVAdapter extends RecyclerView.Adapter<TripRVAdapter.ViewHolder> {

    private ArrayList<String> distances = new ArrayList<>();
    private ArrayList<String> times = new ArrayList<>();

    private Context context;

    public TripRVAdapter(Context context, ArrayList<String> dists, ArrayList<String> times){
        this.context = context;
        distances = dists;
        this.times = times;
    }

    @NonNull
    @Override
    public TripRVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.triphistory_layout, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(TripRVAdapter.ViewHolder holder, final int position) {

        holder.distanceTravelled.setText(distances.get(position));
        holder.timeTravelled.setText(times.get(position));

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return distances.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView distanceTravelled;
        TextView timeTravelled;
        RelativeLayout parentLayout;

        public ViewHolder(View itemView){
            super(itemView);
            distanceTravelled =  itemView.findViewById(R.id.distttraveled);
            timeTravelled = itemView.findViewById(R.id.timetraveled);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }


    public ArrayList<String> getDistances() {
        return distances;
    }

    public void setDistances(ArrayList<String> distances) {
        this.distances = distances;
    }

    public ArrayList<String> getTimes() {
        return times;
    }

    public void setTimes(ArrayList<String> times) {
        this.times = times;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
