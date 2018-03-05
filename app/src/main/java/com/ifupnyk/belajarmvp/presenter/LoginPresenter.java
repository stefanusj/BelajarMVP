package com.ifupnyk.belajarmvp.presenter;

import android.widget.Toast;

import com.ifupnyk.belajarmvp.BelajarMVP;
import com.ifupnyk.belajarmvp.model.request.Login;
import com.ifupnyk.belajarmvp.view.LoginView;

public class LoginPresenter {

    private LoginView view;

    public LoginPresenter(LoginView view) {
        this.view = view;
    }

    /**
     * Method to check if model is empty
     *
     * @param model
     * @return Boolean [True if empty]
     */
    public Boolean isEmpty(Login model) {
        return model.getUsername().isEmpty() || model.getPassword().isEmpty();
    }

    /**
     * Method to do login
     *
     * @param model
     */
    public void doLogin(Login model) {

        if (!isEmpty(model)) {
            // Model isn't empty
            if (model.getUsername().equals("stefanus") && model.getPassword().equals("12345")) {
                view.onLoginSuccess();
            } else {
                // Failed login, wrong username or password
                Toast.makeText(BelajarMVP.context, "Invalid username or password", Toast.LENGTH_SHORT).show();
            }
        } else {
            // Model empty
            Toast.makeText(BelajarMVP.context, "Username or password is empty", Toast.LENGTH_SHORT).show();
        }
    }
}
