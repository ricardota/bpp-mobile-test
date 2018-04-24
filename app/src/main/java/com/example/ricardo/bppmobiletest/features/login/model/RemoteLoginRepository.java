package com.example.ricardo.bppmobiletest.features.login.model;

import android.support.annotation.NonNull;
import android.util.Base64;

import com.example.ricardo.bppmobiletest.common.BaseRepository;
import com.example.ricardo.bppmobiletest.features.login.api.LoginEndpoint;
import com.example.ricardo.bppmobiletest.features.login.api.LoginPayload;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RemoteLoginRepository extends BaseRepository<LoginEndpoint> implements LoginRepository {

    @Override
    public void login(String email, String password, OnLoginListener listener) {
        String encodedPassword = Base64.encodeToString(password.getBytes(), Base64.NO_WRAP);
        Call<LoginPayload> call = getApi().login(email, encodedPassword);
        call.enqueue(new Callback<LoginPayload>() {
            @Override
            public void onResponse(@NonNull Call<LoginPayload> call, @NonNull Response<LoginPayload> response) {
                if (response.isSuccessful() && response.body() != null) {
                    listener.onRequestSuccess(response.body().toLogin());
                } else {
                    listener.onRequestError();
                }
            }

            @Override
            public void onFailure(@NonNull Call<LoginPayload> call, @NonNull Throwable t) {
                listener.onRequestFail();

            }
        });
    }

    @Override
    protected Class<LoginEndpoint> getEndpointClass() {
        return LoginEndpoint.class;
    }
}
