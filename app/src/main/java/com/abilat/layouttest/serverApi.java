package com.abilat.layouttest;

import retrofit2.Call;
import retrofit2.http.GET;

public interface serverApi {

    @GET("activity")
    Call<pojo> messages();
}

