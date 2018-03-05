package com.ifupnyk.belajarmvp;

import com.ifupnyk.belajarmvp.model.response.ContactModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("contacts/")
    Call<ContactModel> getContacts();

}
