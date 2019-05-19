package cryptonite.android.apps.com.traficoin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;


public class shop extends AppCompatActivity {
    private Button toProductList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        toProductList = findViewById(R.id.starbucks);
        toProductList.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent openProductList = new Intent(shop.this, shop_company_products.class);
                startActivity(openProductList);
            }
        });
        //testmode


    }




}
