package com.example.retrofitwithlocalhost;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterPage extends AppCompatActivity implements View.OnClickListener {
    EditText etUsername,etEmail,etPassword;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);
        findIds();
        btnSubmit.setOnClickListener(this);
    }
    private void findIds() {
    etUsername=findViewById(R.id.etUsername);
    etEmail=findViewById(R.id.etEmail);
    etPassword=findViewById(R.id.etPassword);
    btnSubmit=findViewById(R.id.btnSubmit);

    }

    @Override
    public void onClick(View view) {
       onRegisterButtonClick();
    }

    private void onRegisterButtonClick() {

        Call<User> register=ApiHitter.ApiHitter().getRegistrationDetails(etUsername.getText().toString(),etEmail.getText().toString(),etPassword.getText().toString());
        register.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Log.e("msg",response.body().getResponse());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

                Log.e("error message",t.getMessage());

            }
        });
    }
}
