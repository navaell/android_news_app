package com.example.newsapp.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.newsapp.R;
import com.example.newsapp.api.models.NewsModel;

import java.util.LinkedList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<NewsModel> news;

    public MyAdapter() {
        news = new LinkedList<>();
    }

    public void setNews(List<NewsModel> news) {
        this.news = news;
        notifyDataSetChanged();
    }

    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_news_article, parent, false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.title.setText(news.get(position).getTitle());
        holder.subtitle.setText(news.get(position).getAuthor());
    }

    @Override
    public int getItemCount() {
        return news.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView subtitle;

        public MyViewHolder(View v) {
            super(v);
            title = v.findViewById(R.id.item_news_title);
            subtitle = v.findViewById(R.id.item_news_subtitle);
        }
    }
}
