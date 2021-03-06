package com.adams.topnews.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.adams.topnews.R;
import com.adams.topnews.adapters.NewsListAdapter;
import com.adams.topnews.models.Article;
import com.adams.topnews.models.News;
import com.adams.topnews.network.NewsApiInterface;
import com.adams.topnews.network.NewsClient;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsListActivity extends AppCompatActivity {
    private static final String TAG = NewsListActivity.class.getSimpleName();

    @BindView(R.id.titleCategory)
    TextView mTitleCategory;
    @BindView(R.id.errorTextView) TextView mErrorTextView;
    @BindView(R.id.progressBar)
    ProgressBar mProgressBar;
    @BindView(R.id.recyclerCategory)
    RecyclerView mRecyclerCategory;

    private NewsListAdapter mAdapter;

    public List<Article> mNews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        //Binding views
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String country = intent.getStringExtra("country");


        NewsApiInterface client = NewsClient.getNewsClient();

        Call<News> call = client.getNews(country, "news");

        call.enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {

                hideProgressBar();

                if (response.isSuccessful()) {
                    mNews = response.body().getArticles();
                    mAdapter = new NewsListAdapter(mNews,NewsListActivity.this);
                    mRecyclerCategory.setAdapter(mAdapter);
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(NewsListActivity.this);
                    mRecyclerCategory.setLayoutManager(layoutManager);
                    mRecyclerCategory.setHasFixedSize(true);

                    showNews();
                } else {
                    showUnsuccessfulMessage();
                }
            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {
                hideProgressBar();
                showFailureMessage();
            }
        });
    }
    private void showFailureMessage(){
        mErrorTextView.setText("SOmething went wrong. Please check your Internet connection and try again later");
        mErrorTextView.setVisibility(View.VISIBLE);
    }
    private void showUnsuccessfulMessage(){
        mErrorTextView.setText("Something went wrong. Please try again later");
        mErrorTextView.setVisibility(View.VISIBLE);
    }
    private void showNews(){
        mRecyclerCategory.setVisibility(View.VISIBLE);
    }
    private void hideProgressBar(){
        mProgressBar.setVisibility(View.GONE);
    }
}