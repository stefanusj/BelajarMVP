package com.ifupnyk.belajarmvp.view;

import com.ifupnyk.belajarmvp.model.response.Contacts;

public interface MainView {

    void showLoading();
    void hideLoading();

    void onContactsLoaded(Contacts model);
}
