package com.example.newsapp;

import android.app.Application;

import com.example.newsapp.api.NewsNetworkingService;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NewsApplication extends Application {

    private Retrofit retrofit;
    private NewsNetworkingService newsNetworkingService;

    @Override
    public void onCreate() {
        super.onCreate();
        setupRetrofit();
    }

    private void setupRetrofit(){
        retrofit = new Retrofit.Builder()
                .baseUrl("https://newsapi.org")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        newsNetworkingService = retrofit.create(NewsNetworkingService.class);
    }

    public NewsNetworkingService getNewsNetworkingService() {
        return newsNetworkingService;
    }
}
