package cryptonite.android.apps.com.traficoin;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class productListAdapter extends RecyclerView.Adapter<productListAdapter.productListViewHolder> {

    public ImageView productPicture;
    public TextView productName;
    public TextView productPrice;

    public class productListViewHolder extends RecyclerView.ViewHolder {

        public productListViewHolder(@NonNull View itemView) {
            super(itemView);
            productPicture = itemView.findViewById(R.id.productPicture);
            productName = itemView.findViewById(R.id.productName);
            productPrice = itemView.findViewById(R.id.productPrice);

        }
    }

    public productListAdapter(ArrayList<companyProduct> companyProductList) {
        
    }

    @NonNull
    @Override
    public productListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.company_products,viewGroup,false);
        productListViewHolder pLViewholder = new productListViewHolder(view);
        return pLViewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull productListViewHolder productListViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }



}
