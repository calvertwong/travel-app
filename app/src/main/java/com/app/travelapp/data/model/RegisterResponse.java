package com.app.travelapp.data.model;

import com.google.gson.annotations.SerializedName;

public class RegisterResponse {
    @SerializedName("response")
    String response;

    public RegisterResponse(String response) {
        this.response = response;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
