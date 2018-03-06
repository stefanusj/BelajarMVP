package com.ifupnyk.belajarmvp.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.ifupnyk.belajarmvp.R;

public class DetailActivity extends AppCompatActivity {

    private TextView tvName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvName = findViewById(R.id.tvName);

        String name = getIntent().getStringExtra("name");
        String phone = getIntent().getStringExtra("phone");

        tvName.setText(name);
    }
}
