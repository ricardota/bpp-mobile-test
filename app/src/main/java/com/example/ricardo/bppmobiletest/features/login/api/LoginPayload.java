package com.example.ricardo.bppmobiletest.features.login.api;

import com.example.ricardo.bppmobiletest.features.login.model.Login;
import com.google.gson.annotations.SerializedName;

public class LoginPayload {

    @SerializedName("status") private String status;
    @SerializedName("message") private String message;
    @SerializedName("code") private String code;

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public String getCode() {
        return code;
    }

    public Login toLogin() {
        return new Login(status, message, code);
    }
}
