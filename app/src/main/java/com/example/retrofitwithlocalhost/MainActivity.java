package com.example.retrofitwithlocalhost;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    EditText etUsername, etPassword;
    Button btnSubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findIds();

        btnSubmit.setOnClickListener(this);
    }

    private void findIds() {

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnSubmit=findViewById(R.id.btnSubmit);


    }

    @Override

    public void onClick(View view) {
        onLogin();
    }

    private void onLogin() {



        Call<User> getLoginStatus = ApiHitter.ApiHitter().getLoginDetaiuls(etUsername.getText().toString().trim(), etPassword.getText().toString().trim());
        getLoginStatus.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                etUsername.setText("");
                etPassword.setText("");
            Log.e("msg",response.body().getUsername());
            Log.e("response",response.body().getResponse());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
            Log.e("exception",t.getMessage());
            }
        });


    }
}
