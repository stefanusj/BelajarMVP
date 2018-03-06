package com.ifupnyk.belajarmvp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.ifupnyk.belajarmvp.R;
import com.ifupnyk.belajarmvp.adapter.ContactsAdapter;
import com.ifupnyk.belajarmvp.listener.ContactListener;
import com.ifupnyk.belajarmvp.model.response.Contacts;
import com.ifupnyk.belajarmvp.presenter.MainPresenter;
import com.ifupnyk.belajarmvp.view.MainView;

public class MainActivity extends AppCompatActivity implements MainView, ContactListener {

    private ProgressBar pbLoading;
    private RecyclerView rvContacts;

    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        presenter = new MainPresenter(this);

        pbLoading = findViewById(R.id.pbLoading);
        rvContacts = findViewById(R.id.rvContacts);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rvContacts.setLayoutManager(layoutManager);

        DividerItemDecoration itemDecoration = new DividerItemDecoration(this, layoutManager.getOrientation());
        rvContacts.addItemDecoration(itemDecoration);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.loadContacts();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        switch (id) {
            case R.id.actionReload:
                presenter.loadContacts();
                break;
            case android.R.id.home:
                onBackPressed();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    /********/
    /**View**/
    /********/
    @Override
    public void showLoading() {
        pbLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        pbLoading.setVisibility(View.GONE);
    }

    @Override
    public void onContactsLoaded(Contacts model) {
        rvContacts.setAdapter(new ContactsAdapter(model, this));
    }

    /*******************/
    /**ContactListener**/
    /*******************/
    @Override
    public void onContactClicked(Contacts.Contact contact) {
        Intent intentToDetail = new Intent(MainActivity.this, DetailActivity.class);
        intentToDetail.putExtra("name", contact.getName());
        intentToDetail.putExtra("phone", contact.getPhone().getMobile());
        startActivity(intentToDetail);
    }
}
