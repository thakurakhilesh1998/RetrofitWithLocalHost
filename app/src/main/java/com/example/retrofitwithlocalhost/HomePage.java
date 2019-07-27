package com.example.retrofitwithlocalhost;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class HomePage extends AppCompatActivity implements View.OnClickListener {
    Button btnLogin, btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);
        btnLogin.setOnClickListener(this);
        btnRegister.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.btnLogin:
                onLogin();
                break;
            case R.id.btnRegister:
                onRegister();
        }
    }

    private void onRegister() {
        startActivity(new Intent(getApplicationContext(),RegisterPage.class));

    }

    private void onLogin() {
        startActivity(new Intent(getApplicationContext(),MainActivity.class));

    }
}
