package com.grid.mobile.gridsample.web;

import com.grid.mobile.gridsample.model.NavigationProp;
import com.grid.mobile.gridsample.util.SampleConstant;
import com.grid.mobile.gridsample.view.activity.HomeActivity;
import com.grid.mobile.gridsample.web.handler.Categery;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Mobile on 4/7/2017.
 */

public class WebHandling {

    private static WebHandling webHandling;
    public static WebInterface api;


    public WebHandling() {
        webHandling = this;
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);  // <-- this is the important line!
        api = new Retrofit.Builder()
                .baseUrl(SampleConstant.baseUrl).client(httpClient.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(WebInterface.class);
    }


    public static WebHandling getInstance() {
        return webHandling;
    }

    public void getcategory(final Categery categery) {



            Call<NavigationProp> response = api.getcategory();
            response.enqueue(new Callback<NavigationProp>() {
                @Override
                public void onResponse(Call<NavigationProp> call, final Response<NavigationProp> response) {

                    categery.onResponse(response.body());
                }

                @Override
                public void onFailure(Call<NavigationProp> call, Throwable t) {
                    categery.onResponse(null);
                }
            });


        }
}