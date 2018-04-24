package com.example.ricardo.bppmobiletest.features.login.presenter;

import android.text.TextUtils;

import com.example.ricardo.bppmobiletest.R;
import com.example.ricardo.bppmobiletest.common.RequestStatus;
import com.example.ricardo.bppmobiletest.features.login.LoginContract;
import com.example.ricardo.bppmobiletest.features.login.model.Login;
import com.example.ricardo.bppmobiletest.features.login.model.LoginRepository;
import com.example.ricardo.bppmobiletest.features.login.model.RemoteLoginRepository;

public class LoginPresenter implements LoginContract.Presenter, LoginRepository.OnLoginListener {

    private final LoginContract.View view;

    public LoginPresenter(LoginContract.View view) {
        this.view = view;
    }

    @Override
    public void attemptLogin(String email, String password) {
        view.resetErrors();

        if (TextUtils.isEmpty(email)) {
            view.setEmailError();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            view.setPasswordError();
            return;
        }

        view.showProgressView();

        LoginRepository repository = new RemoteLoginRepository();
        repository.login(email, password, this);
    }

    @Override
    public void onRequestSuccess(Login login) {
        if (RequestStatus.SUCCESS.equals(login.getCode())) {
            view.openTimeline();
        } else {
            view.hideProgressView();
            view.showError(login.getMessage());
        }
    }

    @Override
    public void onRequestError() {
        view.hideProgressView();
        view.showError(R.string.request_error);
    }

    @Override
    public void onRequestFail() {
        view.hideProgressView();
        view.showError(R.string.request_fail);
    }
}
