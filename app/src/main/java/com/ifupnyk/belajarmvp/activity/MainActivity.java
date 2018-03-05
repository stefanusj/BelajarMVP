package com.ifupnyk.belajarmvp.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ifupnyk.belajarmvp.ContactsAdapter;
import com.ifupnyk.belajarmvp.R;
import com.ifupnyk.belajarmvp.model.response.ContactModel;
import com.ifupnyk.belajarmvp.presenter.MainPresenter;
import com.ifupnyk.belajarmvp.view.MainView;

public class MainActivity extends AppCompatActivity implements MainView {

    private RecyclerView rvContacts;

    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainPresenter(this);

        rvContacts = findViewById(R.id.rvContacts);
        rvContacts.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.loadContacts();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void onContactsLoaded(ContactModel model) {
        rvContacts.setAdapter(new ContactsAdapter(model));
    }
}
