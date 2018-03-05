package com.ifupnyk.belajarmvp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ifupnyk.belajarmvp.R;
import com.ifupnyk.belajarmvp.model.request.Login;
import com.ifupnyk.belajarmvp.presenter.LoginPresenter;
import com.ifupnyk.belajarmvp.view.LoginView;

public class LoginActivity extends AppCompatActivity implements LoginView {

    private Button btnLogin;
    private EditText etUsername, etPassword;

    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        presenter = new LoginPresenter(this);

        btnLogin = findViewById(R.id.btnLogin);
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);

        btnLogin.setOnClickListener(onLoginClicked);
    }

    private View.OnClickListener onLoginClicked = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String username = etUsername.getText().toString();
            String password = etPassword.getText().toString();

            Login model = new Login();
            model.setUsername(username)
                    .setPassword(password);

            presenter.doLogin(model);
        }
    };

    @Override
    public void onLoginSuccess() {
        startActivity(new Intent(LoginActivity.this, MainActivity.class));
    }
}
