package com.ifupnyk.belajarmvp.presenter;

import com.ifupnyk.belajarmvp.ApiClient;
import com.ifupnyk.belajarmvp.ApiInterface;
import com.ifupnyk.belajarmvp.model.response.ContactModel;
import com.ifupnyk.belajarmvp.view.MainView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter {

    private MainView view;

    public MainPresenter(MainView view) {
        this.view = view;
    }

    public void loadContacts() {
        view.showLoading();

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

        Call<ContactModel> call = apiInterface.getContacts();

        call.enqueue(new Callback<ContactModel>() {
            @Override
            public void onResponse(Call<ContactModel> call, Response<ContactModel> response) {
                ContactModel model = response.body();
                view.onContactsLoaded(model);
                view.hideLoading();
            }

            @Override
            public void onFailure(Call<ContactModel> call, Throwable t) {
                t.printStackTrace();
                view.hideLoading();
            }
        });
    }
}
