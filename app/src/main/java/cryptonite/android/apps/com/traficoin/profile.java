package cryptonite.android.apps.com.traficoin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class profile extends AppCompatActivity {

    private Button toPurchaseHistory;
    private Button tripHistorybtn;

    private TextView averageTime;
    private TextView averageMile;
    private TextView averageCoin;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        averageTime = (TextView)findViewById(R.id.averageTime);
        CoinGeneratorClient cg = new CoinGeneratorClient(getApplication());

        averageMile = (TextView)findViewById(R.id.averageMile);
        toPurchaseHistory = (Button)findViewById(R.id.purchaseHistory);
        toPurchaseHistory.setOnClickListener(new View.OnClickListener() {
            //opening up the company_products activity
            @Override
            public void onClick(View view) {
                Intent openPurchaseHistory = new Intent(profile.this, purchase_history.class);
                startActivity(openPurchaseHistory);
            }
        });
        tripHistorybtn = (Button)findViewById(R.id.tripHistory);
        tripHistorybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openTripHistory = new Intent(getApplicationContext(), TripHistoryActivity.class);
                startActivity(openTripHistory);
            }
        });
        averageMile.setText("avg/m"+cg.getAverage(true));
        averageTime.setText("avg/t"+cg.getAverage(false));

    }
}
