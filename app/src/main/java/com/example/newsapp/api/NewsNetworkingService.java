package com.example.newsapp.api;

import com.example.newsapp.api.models.HeadlineResponseModel;
import com.example.newsapp.api.models.NewsModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsNetworkingService {
    @GET("/v2/top-headlines")
    Call<HeadlineResponseModel> listHeadlines(@Query("apiKey") String value,
                                                         @Query("country") String country);
}
