package com.ifupnyk.belajarmvp;

import android.app.Application;
import android.content.Context;

public class BelajarMVP extends Application {

    @SuppressWarnings("StaticFieldLeak")
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }
}
