package com.example.ricardo.bppmobiletest.features.login.model;

public interface LoginRepository {

    interface OnLoginListener {
        void onRequestSuccess(Login login);

        void onRequestError();

        void onRequestFail();
    }

    void login(String email, String password, OnLoginListener listener);

}
