package com.ifupnyk.belajarmvp.view;

import com.ifupnyk.belajarmvp.model.response.ContactModel;

public interface MainView {

    void showLoading();
    void hideLoading();
    void onContactsLoaded(ContactModel model);
}
