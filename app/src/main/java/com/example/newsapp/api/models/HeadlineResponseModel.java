package com.example.newsapp.api.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HeadlineResponseModel {
    @SerializedName("totalResults")
    private int totalResults;
    @SerializedName("articles")
    private List<NewsModel> news;

    public List<NewsModel> getNews() {
        return news;
    }

    public int getTotalResults() {
        return totalResults;
    }
}
