package com.ifupnyk.belajarmvp.presenter;

import com.ifupnyk.belajarmvp.model.response.Contacts;
import com.ifupnyk.belajarmvp.service.ApiClient;
import com.ifupnyk.belajarmvp.service.ApiInterface;
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

        Call<Contacts> call = apiInterface.getContacts();

        call.enqueue(new Callback<Contacts>() {
            @Override
            public void onResponse(Call<Contacts> call, Response<Contacts> response) {
                Contacts model = response.body();
                view.onContactsLoaded(model);
                view.hideLoading();
            }

            @Override
            public void onFailure(Call<Contacts> call, Throwable t) {
                t.printStackTrace();
                view.hideLoading();
            }
        });
    }
}
