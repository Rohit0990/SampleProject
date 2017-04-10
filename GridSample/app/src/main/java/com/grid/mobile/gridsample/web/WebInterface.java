package com.grid.mobile.gridsample.web;

import com.grid.mobile.gridsample.model.NavigationProp;

import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;


/**
 * Created by Mobile on 4/7/2017.
 */

public interface WebInterface {


    @GET("returnCategories.php")
    Call<NavigationProp> getcategory();
}

