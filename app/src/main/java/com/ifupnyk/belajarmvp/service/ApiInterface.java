package com.ifupnyk.belajarmvp.service;

import com.ifupnyk.belajarmvp.model.response.Contacts;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("contacts/")
    Call<Contacts> getContacts();

}
