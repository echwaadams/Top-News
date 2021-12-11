package com.adams.topnews.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.adams.topnews.R;
import com.adams.topnews.models.Article;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsListAdapter extends RecyclerView.Adapter<NewsListAdapter.NewsViewHolder> {
    private List<Article> mNews;
    private Context mContext;

    public NewsListAdapter(List<Article> mNews, Context mContext) {
        this.mNews = mNews;
        this.mContext = mContext;
    }
    @Override
    public NewsListAdapter.NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_list_item, parent,false);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(NewsListAdapter.NewsViewHolder holder, int position){
        holder.bindNews(mNews.get(position));
    }

    @Override
    public int getItemCount(){
        return mNews.size();
    }
    public class NewsViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.newsImageView)
        ImageView mNewsImageView;
        @BindView(R.id.categoryTextView)
        TextView mCategoryTextView;
        @BindView(R.id.newsNameTextView) TextView mNewsNameTextView;
        @BindView(R.id.recyclerCategory) RecyclerView mRecyclerCategory;


        private Context mContext;

        public NewsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        public void bindNews(Article news) {
            Picasso.get().load(news.getUrlToImage()).into(mNewsImageView);

            mNewsNameTextView.setText(news.getAuthor());
            mCategoryTextView.setText(news.getSource().getSystemId());
        }
    }
}
