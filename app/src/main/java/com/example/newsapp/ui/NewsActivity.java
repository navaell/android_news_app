package com.example.newsapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.newsapp.R;
import com.example.newsapp.api.models.NewsModel;

import java.util.LinkedList;
import java.util.List;

public class NewsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        recyclerView = (RecyclerView) findViewById(R.id.news_recyclerview);

        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        List<NewsModel> news = new LinkedList<>();
        news.add(new NewsModel("US Elections", "winner"));
        news.add(new NewsModel("Corona", "update"));

        mAdapter = new MyAdapter(news);
        recyclerView.setAdapter(mAdapter);
    }

}