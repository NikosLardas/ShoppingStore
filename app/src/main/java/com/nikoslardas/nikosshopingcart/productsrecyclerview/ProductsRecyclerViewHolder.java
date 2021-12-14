package com.nikoslardas.nikosshopingcart.productsrecyclerview;

import android.content.res.TypedArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nikoslardas.nikosshopingcart.R;

public class ProductsRecyclerViewHolder extends RecyclerView.ViewHolder {

    private ProductsRecyclerViewAdapter.Listener callback;

    public ProductsRecyclerViewHolder(@NonNull View itemView, ProductsRecyclerViewAdapter.Listener callback) {
        super(itemView);
        this.callback = callback;
    }

    public void bindData(String data) {
        String[] productDescriptions = itemView.getResources().getStringArray(R.array.product_descriptions);
        TypedArray productImages = itemView.getResources().obtainTypedArray(R.array.product_images);

        TextView productTitle = itemView.findViewById(R.id.product_item_title_txt);
        productTitle.setText(data);

        TextView productDescription = itemView.findViewById(R.id.product_item_description_txt);
        productDescription.setText(productDescriptions[getAdapterPosition()]);

        ImageView productImage = itemView.findViewById(R.id.product_item_img);
        productImage.setImageResource(productImages.getResourceId(getAdapterPosition(),0));
        productImage.setTag(productImages.getResourceId(getAdapterPosition(),0));

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                callback.onItemClick(v, data);
            }
        });
    }
}