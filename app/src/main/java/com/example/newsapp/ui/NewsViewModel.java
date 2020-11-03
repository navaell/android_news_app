package com.example.newsapp.ui;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.newsapp.api.models.HeadlineResponseModel;
import com.example.newsapp.api.models.NewsModel;
import com.example.newsapp.repo.NewsRepository;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsViewModel {

    private final NewsRepository newsRepository;
    private final MutableLiveData<List<NewsModel>> newsChannel = new MutableLiveData<>();

    public NewsViewModel(final NewsRepository newsRepo) {
        newsRepository = newsRepo;
    }

    public LiveData<List<NewsModel>> getNewsChannel() {
        return newsChannel;
    }

    public void onCreate(){

        newsRepository.fetchNewsList(new Callback<HeadlineResponseModel>() {
            @Override
            public void onResponse(Call<HeadlineResponseModel> call, Response<HeadlineResponseModel> response) {
                newsChannel.setValue(response.body().getNews());
            }

            @Override
            public void onFailure(Call<HeadlineResponseModel> call, Throwable t) {
                Log.e("newsViewModel", "", t);
            }
        });

    }
}
