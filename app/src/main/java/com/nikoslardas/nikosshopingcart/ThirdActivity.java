package com.nikoslardas.nikosshopingcart;

import androidx.annotation.Nullable;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class ThirdActivity extends AbstractActivity {

    @Override
    int getLayout() {
        return R.layout.activity_third_product;
    }

    @Override
    void uiSetup() {

        Intent intent = getIntent();
        String productTitle = intent.getStringExtra("title");
        int imageSource = intent.getIntExtra("image",R.drawable.product_basic);
        String fullProductDescription = intent.getStringExtra("full_description");

        TextView title = findViewById(R.id.product_info_title_txt);
        title.setText(productTitle);

        ImageView img = findViewById(R.id.product_info_img);
        img.setImageResource(imageSource);

        TextView desc = findViewById(R.id.product_info_description_txt);
        desc.setText(fullProductDescription);

        Button btnShare = findViewById(R.id.third_product_btn_share);
        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, productTitle+ ' ' + fullProductDescription);
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
            }
        });
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