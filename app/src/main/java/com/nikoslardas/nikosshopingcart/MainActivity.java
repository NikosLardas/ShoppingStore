package com.nikoslardas.nikosshopingcart;

import androidx.annotation.Nullable;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AbstractActivity {

    @Override
    int getLayout() {
        return R.layout.activity_main_login;
    }

    @Override
    void uiSetup() {

        Button btnLogin = findViewById(R.id.main_login_btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText username = findViewById(R.id.main_login_edit_txt_username);
                EditText password = findViewById(R.id.main_login_edit_txt_password);

                if((username.getText().toString().equals("Admin") || username.getText().toString().equals("admin@gmail.com"))
                && (password.getText().toString().equals("pass1234"))) {

                    Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(v.getContext(),"Please enter a valid admin Username or Email and Password",Toast.LENGTH_SHORT).show();
                }
            }
        });

        TextView forgotPassword = findViewById(R.id.main_login_txt_forgot_password);
        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"Please contact the Main Administrator to reset your password",Toast.LENGTH_SHORT).show();
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

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
    }
}