package com.example.retrofitwithlocalhost;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class ApiHitter {
    public static Retrofit retrofit=null;
    public static String baseURL="http://10.0.3.2/";



    public static ApiInterface ApiHitter() {
        retrofit = new Retrofit.Builder().baseUrl(baseURL).addConverterFactory(GsonConverterFactory.create()).build();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        return apiInterface;

    }

    public interface ApiInterface {
        @GET("login.php")
        Call<User> getLoginDetaiuls(@Query("username") String username,@Query("password") String password);

        @GET("register.php")
        Call<User> getRegistrationDetails(@Query("username") String username,@Query("email") String email,@Query("password") String password);
    }
}
