package cryptonite.android.apps.com.traficoin;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class TripHistoryRVAdapter extends RecyclerView.Adapter<TripHistoryRVAdapter.ViewHolder>{

    private ArrayList<String> distances = new ArrayList<>();
    private ArrayList<String> times = new ArrayList<>();
    private Context context;

    public TripHistoryRVAdapter (Context context, ArrayList<String> distances, ArrayList<String> times){
        this.context = context;
        this.distances = distances;
        this.times = times;
    }


    @NonNull
    @Override
    public TripHistoryRVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.triphistory_layout, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull TripHistoryRVAdapter.ViewHolder holder, final int position) {
        holder.distance.setText(distances.get(position));
        holder.time.setText((times.get(position)));

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, distances.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return distances.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView distance;
        TextView time;
        RelativeLayout parentLayout;

        public ViewHolder(View itemView){
            super(itemView);
            distance = itemView.findViewById(R.id.distttraveled);
            time = itemView.findViewById(R.id.timetraveled);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }
}
