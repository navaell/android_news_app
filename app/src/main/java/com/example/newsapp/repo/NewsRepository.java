package com.example.newsapp.repo;

import com.example.newsapp.api.models.NewsModel;

import java.util.LinkedList;
import java.util.List;

public class NewsRepository {

    public List<NewsModel> fetchNewsList(){
        List<NewsModel> news = new LinkedList<>();
        news.add(new NewsModel("US Elections", "winner"));
        news.add(new NewsModel("Corona", "update"));
        return news;
    }
}
