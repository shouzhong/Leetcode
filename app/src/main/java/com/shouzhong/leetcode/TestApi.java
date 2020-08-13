package com.shouzhong.leetcode;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TestApi {
    @GET("a/b")
    Call<String> a(@Query("a") String a);
}
