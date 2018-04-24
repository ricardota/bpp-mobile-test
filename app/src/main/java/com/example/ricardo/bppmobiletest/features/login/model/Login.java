package com.example.ricardo.bppmobiletest.features.login.model;

public class Login {

    private String status;
    private String message;
    private String code;

    public Login(String status, String message, String code) {
        this.status = status;
        this.message = message;
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public String getCode() {
        return code;
    }
}
