package com.example.newsapp.api.models;

import com.google.gson.annotations.SerializedName;

public class NewsModel {
    @SerializedName("author")
    private String author;
    @SerializedName("title")
    private String title;

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }
}