package com.nikoslardas.nikosshopingcart.productsrecyclerview;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nikoslardas.nikosshopingcart.Product;
import com.nikoslardas.nikosshopingcart.R;

public class ProductsRecyclerViewHolder extends RecyclerView.ViewHolder {

    private ProductsRecyclerViewAdapter.Listener callback;

    public ProductsRecyclerViewHolder(@NonNull View itemView, ProductsRecyclerViewAdapter.Listener callback) {
        super(itemView);
        this.callback = callback;
    }

    public void bindData(Product data) {

        TextView productTitle = itemView.findViewById(R.id.product_item_title_txt);
        productTitle.setText(data.getProductTitle());

        TextView productDescription = itemView.findViewById(R.id.product_item_description_txt);
        productDescription.setText(data.getProductDescription());

        ImageView productImage = itemView.findViewById(R.id.product_item_img);

        productImage.setImageResource(data.getProductImage());

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                callback.onItemClick(v, data);
            }
        });
    }
}