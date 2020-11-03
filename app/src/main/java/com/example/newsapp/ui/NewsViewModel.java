package com.example.newsapp.ui;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.newsapp.api.models.NewsModel;
import com.example.newsapp.repo.NewsRepository;

import java.util.List;

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

        newsChannel.setValue(newsRepository.fetchNewsList());

    }
}
