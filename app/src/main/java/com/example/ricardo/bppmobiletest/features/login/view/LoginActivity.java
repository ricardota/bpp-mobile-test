package com.example.ricardo.bppmobiletest.features.login.view;

import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ricardo.bppmobiletest.R;
import com.example.ricardo.bppmobiletest.features.login.LoginContract;
import com.example.ricardo.bppmobiletest.features.login.presenter.LoginPresenter;

public class LoginActivity extends AppCompatActivity implements LoginContract.View {

    private AutoCompleteTextView emailView;
    private EditText passwordView;
    private View progressView;
    private View loginFormView;
    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailView = findViewById(R.id.email);
        passwordView = findViewById(R.id.password);
        loginFormView = findViewById(R.id.login_form);
        progressView = findViewById(R.id.login_progress);
        Button signInButton = findViewById(R.id.email_sign_in_button);

        presenter = new LoginPresenter(this);

        passwordView.setOnEditorActionListener((textView, id, keyEvent) -> {
            if (id == EditorInfo.IME_ACTION_DONE || id == EditorInfo.IME_NULL) {
                attemptLogin();
                return true;
            }
            return false;
        });

        signInButton.setOnClickListener(view -> attemptLogin());
    }

    private void attemptLogin() {
        String email = emailView.getText().toString();
        String password = passwordView.getText().toString();

        presenter.attemptLogin(email, password);

    }

    @Override
    public void resetErrors() {
        emailView.setError(null);
        passwordView.setError(null);
    }

    @Override
    public void setEmailError() {
        emailView.setError(getString(R.string.error_field_required));
        emailView.requestFocus();
    }

    @Override
    public void setPasswordError() {
        passwordView.setError(getString(R.string.error_field_required));
        passwordView.requestFocus();
    }

    @Override
    public void showProgressView() {
        progressView.setVisibility(View.VISIBLE);
        loginFormView.setVisibility(View.INVISIBLE);
    }

    @Override
    public void hideProgressView() {
        progressView.setVisibility(View.INVISIBLE);
        loginFormView.setVisibility(View.VISIBLE);
    }

    @Override
    public void openTimeline() {
        // TODO: open timeline
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showError(@StringRes int resourceString) {
        Toast.makeText(this, resourceString, Toast.LENGTH_SHORT).show();
    }
}

