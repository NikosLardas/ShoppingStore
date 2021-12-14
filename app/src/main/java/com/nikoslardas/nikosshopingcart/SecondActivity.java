package com.nikoslardas.nikosshopingcart;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.nikoslardas.nikosshopingcart.productsrecyclerview.ProductsRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;


public class SecondActivity extends AbstractActivity {

    @Override
    int getLayout() {
        return R.layout.activity_second_shopping_list;
    }

    @Override
    void uiSetup() {

        Button btnLogout = findViewById(R.id.second_shoplist_btn_logout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        RecyclerView recyclerView = findViewById(R.id.products_recycler_view_list);

        ProductsRecyclerViewAdapter adapter = new ProductsRecyclerViewAdapter(getDataList(), new ProductsRecyclerViewAdapter.Listener() {

            @Override
            public void onItemClick(View view, Product data) {

                TextView title = view.findViewById(R.id.product_item_title_txt);
                String productTitle = title.getText().toString();

                int imgSrc = data.getProductImage();

                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                intent.putExtra("title",productTitle);
                intent.putExtra("image", imgSrc);
                intent.putExtra("full_description",data.getProductFullDescription());
                startActivity(intent);
            }
        });

        recyclerView.setAdapter(adapter);
    }

    private List<Product> getDataList() {

        List<Product> products = new ArrayList<>();

        for(int i = 0; i < 5; i++) {
            Product prod = new Product(i,this);
            products.add(prod);
        }

        return products;
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this,"Please press the Logout button if you wish to log out from your account",Toast.LENGTH_SHORT).show();
    }

    @Override
    void startOperations() {

    }

    @Override
    void stopOperations() {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}