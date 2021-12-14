package com.nikoslardas.nikosshopingcart.productsrecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nikoslardas.nikosshopingcart.Product;
import com.nikoslardas.nikosshopingcart.R;

import java.util.List;

public class ProductsRecyclerViewAdapter extends RecyclerView.Adapter<ProductsRecyclerViewHolder>{

    public interface Listener {
        void onItemClick(View view, Product data);
    }

    @NonNull
    private List<Product> products;
    private Listener callback;

    public ProductsRecyclerViewAdapter(List<Product> arrayData, Listener callback) {
        this.products = arrayData;
        this.callback = callback;
    }

    @NonNull
    @Override
    public ProductsRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);

        return new ProductsRecyclerViewHolder(view, callback);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductsRecyclerViewHolder holder, int position) {
        Product data = products.get(position);
        holder.bindData(data);
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.holder_product_item;
    }
}