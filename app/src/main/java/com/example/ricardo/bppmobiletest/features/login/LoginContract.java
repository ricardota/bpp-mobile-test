package com.example.ricardo.bppmobiletest.features.login;

import android.support.annotation.StringRes;

public class LoginContract {

    public interface View {
        void resetErrors();

        void setEmailError();

        void setPasswordError();

        void showProgressView();

        void hideProgressView();

        void openTimeline();

        void showError(String message);

        void showError(@StringRes int resourceString);
    }

    public interface Presenter {
        void attemptLogin(String email, String password);
    }

}
