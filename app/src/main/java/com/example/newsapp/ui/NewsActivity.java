package com.example.newsapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.newsapp.R;
import com.example.newsapp.api.models.NewsModel;
import com.example.newsapp.repo.NewsRepository;

import java.util.LinkedList;
import java.util.List;

public class NewsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MyAdapter mAdapter;
    private NewsViewModel viewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);


        viewModel = new NewsViewModel(new NewsRepository());

        viewModel.onCreate();
        mAdapter = new MyAdapter();

        recyclerView = (RecyclerView) findViewById(R.id.news_recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(mAdapter);

        viewModel.getNewsChannel().observe(this, new Observer<List<NewsModel>>() {

            @Override
            public void onChanged(List<NewsModel> newsModels) {
                mAdapter.setNews(newsModels);
            }
        });



    }

}