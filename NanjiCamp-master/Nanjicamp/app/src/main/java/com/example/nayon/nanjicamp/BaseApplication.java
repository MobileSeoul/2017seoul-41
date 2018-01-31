package com.example.nayon.nanjicamp;

import android.app.Application;

import com.bumptech.glide.Glide;

/**
 * Created by nayong on 2017. 5. 4..
 */

public class BaseApplication extends Application{

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        Glide.get(this).clearMemory();
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        Glide.get(this).trimMemory(level);
    }


}
