package cryptonite.android.apps.com.traficoin;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class shop_company_products extends AppCompatActivity{

    private RecyclerView productRecycler;
    private RecyclerView.Adapter myAdapter;
    private RecyclerView.LayoutManager myLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_company_products);

        ArrayList<companyProduct> productList = new ArrayList<>();
        productList.add(new companyProduct(R.drawable.starbucks_example, "Javachip Frappu", 6900));
        productList.add(new companyProduct(R.drawable.starbucks_example, "Javachip Frappu", 6900));
        productList.add(new companyProduct(R.drawable.starbucks_example, "Javachip Frappu", 6900));
        productList.add(new companyProduct(R.drawable.starbucks_example, "Javachip Frappu", 6900));
        productList.add(new companyProduct(R.drawable.starbucks_example, "Javachip Frappu", 6900));
        productList.add(new companyProduct(R.drawable.starbucks_example, "Javachip Frappu", 6900));
        productList.add(new companyProduct(R.drawable.starbucks_example, "Javachip Frappu", 6900));
        productList.add(new companyProduct(R.drawable.starbucks_example, "Javachip Frappu", 6900));
        productList.add(new companyProduct(R.drawable.starbucks_example, "Javachip Frappu", 6900));
        productList.add(new companyProduct(R.drawable.starbucks_example, "Javachip Frappu", 6900));





    }
}
