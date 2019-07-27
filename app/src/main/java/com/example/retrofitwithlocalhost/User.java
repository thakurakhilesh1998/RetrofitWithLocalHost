package com.example.retrofitwithlocalhost;

import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("response")
    private String response;
    @SerializedName("username")
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

}
