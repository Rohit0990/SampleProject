package com.grid.mobile.gridsample.view;

import com.grid.mobile.gridsample.web.WebHandling;

/**
 * Created by Mobile on 4/7/2017.
 */

public class Application extends android.app.Application {


    public static Application mInstance;

    // public static List<String> idsList ;
    @Override
    public void onCreate() {
        super.onCreate();

        mInstance = this;
        new WebHandling();
        new ImageLoaderClass(this);
        // idsList=  new ArrayList<>();
    }

    public static synchronized Application getInstance() {
        return mInstance;
    }

}