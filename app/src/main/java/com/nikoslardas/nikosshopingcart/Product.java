package com.nikoslardas.nikosshopingcart;

import android.content.Context;
import android.content.res.TypedArray;

import androidx.appcompat.app.AppCompatActivity;

public class Product extends AppCompatActivity {

    private final int position;
    private final Context context;
    private String[] titles;
    private String[] descriptions;
    private TypedArray images;
    private String[] fullDescriptions;


    public Product(int position, Context context) {
        this.position = position;
        this.context = context;
    }

    public String getProductTitle() {

        titles= context.getResources().getStringArray(R.array.products);
        return titles[position];
    }

    public String getProductDescription() {

        descriptions = context.getResources().getStringArray(R.array.product_descriptions);
        return descriptions[position];
    }

    public int getProductImage() {

        images = context.getResources().obtainTypedArray(R.array.product_images);
        return images.getResourceId(position,0);
    }

    public String getProductFullDescription() {

        fullDescriptions = context.getResources().getStringArray(R.array.full_product_descriptions);
        return fullDescriptions[position];
    }
}