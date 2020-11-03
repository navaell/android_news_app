package com.example.newsapp.repo;

import com.example.newsapp.api.NewsNetworkingService;
import com.example.newsapp.api.models.HeadlineResponseModel;
import com.example.newsapp.api.models.NewsModel;

import java.util.LinkedList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsRepository {
    private static final String API_KEY = "ed5ec511bd2041ab9f8cbb1a7638b085";
    private static final String COUNTRY = "US";
    private final NewsNetworkingService service;


    public NewsRepository(final NewsNetworkingService service) {
        this.service = service;
    }

    public void fetchNewsList(final Callback<HeadlineResponseModel> callback){
        service.listHeadlines(API_KEY, COUNTRY).enqueue(callback);
    }
}
