package com.adams.topnews.network;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsApiInterface {
    String BASE_URL = "https://newsapi.org/v2/";

    @GET("top-headlines")
    Call<MainNews> getNews(
            @Query("countries") String country,
            @Query("pageSize") int pageSize,
            @Query("apikey") String apikey
    );

    @GET("top-headlines")
    Call<MainNews> getCategory(
            @Query("countries") String country,
            @Query("category") String category,
            @Query("pageSize") int pageSize,
            @Query("apikey") String apikey
    );
}
