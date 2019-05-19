package cryptonite.android.apps.com.traficoin;

//company products list
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;

public class shop_company_products extends AppCompatActivity{

    private ImageButton hide;

    private RecyclerView productRecycler;
    private productListAdapter productListAdapter;
    private RecyclerView.LayoutManager productListLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_company_products);

        ArrayList<companyProduct> productList = new ArrayList<>();
        productList.add(new companyProduct(R.drawable.starbucks_example, "Javachip Frappuccino", 6900));
        productList.add(new companyProduct(R.drawable.starbucks_example, "Javachip Frappuccino", 6900));
        productList.add(new companyProduct(R.drawable.starbucks_example, "Javachip Frappuccino", 6900));
        productList.add(new companyProduct(R.drawable.starbucks_example, "Javachip Frappuccino", 6900));
        productList.add(new companyProduct(R.drawable.starbucks_example, "Javachip Frappuccino", 6900));
        productList.add(new companyProduct(R.drawable.starbucks_example, "Javachip Frappuccino", 6900));
        productList.add(new companyProduct(R.drawable.starbucks_example, "Javachip Frappuccino", 6900));
        productList.add(new companyProduct(R.drawable.starbucks_example, "Javachip Frappuccino", 6900));
        productList.add(new companyProduct(R.drawable.starbucks_example, "Javachip Frappuccino", 6900));
        productList.add(new companyProduct(R.drawable.starbucks_example, "Javachip Frappuccino", 6900));
        productList.add(new companyProduct(R.drawable.starbucks_example, "Javachip Frappuccino", 6900));
        productList.add(new companyProduct(R.drawable.starbucks_example, "Javachip Frappuccino", 6900));
        productList.add(new companyProduct(R.drawable.starbucks_example, "Javachip Frappuccino", 6900));
        productList.add(new companyProduct(R.drawable.starbucks_example, "Javachip Frappuccino", 6900));
        productList.add(new companyProduct(R.drawable.starbucks_example, "Javachip Frappuccino", 6900));
        productList.add(new companyProduct(R.drawable.starbucks_example, "Javachip Frappuccino", 6900));

        hide = findViewById(R.id.hide);
        hide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(shop_company_products.this, product_purchase.class));
                hide.setVisibility(v.INVISIBLE);
            }
        });



        productRecycler = findViewById(R.id.productRecycler);
        productRecycler.setHasFixedSize(true);
        productListLayoutManager= new LinearLayoutManager(this);
        productListAdapter = new productListAdapter(productList);

        productRecycler.setLayoutManager(productListLayoutManager);
        productRecycler.setAdapter(productListAdapter);

        productRecycler.setOnClickListener(new View.OnClickListener() {
            //opening up the company_products activity
            @Override
            public void onClick(View view) {
                Intent openProductList = new Intent(shop_company_products.this, product_purchase.class);
                startActivity(openProductList);
            }
        });

        }

        public void buildRecyclerView(){
            productRecycler = findViewById(R.id.productRecycler);
            productRecycler.setHasFixedSize(true);
            productListLayoutManager = new LinearLayoutManager(this);

            productRecycler.setLayoutManager(productListLayoutManager);
            productRecycler.setAdapter(productListAdapter);

        }
    }
