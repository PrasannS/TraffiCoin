package cryptonite.android.apps.com.traficoin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import cryptonite.android.apps.com.traficoin.Models.DaoSession;

public class product_purchase extends AppCompatActivity {

    Button button;
    DaoSession daoSession;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_purchase);
        button = findViewById(R.id.purchaseProduct);
        final CoinGeneratorClient cg = new CoinGeneratorClient( getApplication());
        daoSession = ((App)getApplication()).getDaoSession();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cg.runTransaction(-6900);
            }
        });
    }
}
