package com.example.mymovie;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitInterface {
    @GET("searchDailyBoxOfficeList.json")
    Call<Result>
    getData(@Query("key") String pageNo, @Query("targetDt") String targetDt);
}

