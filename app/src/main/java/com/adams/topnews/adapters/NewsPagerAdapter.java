package com.adams.topnews.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.adams.topnews.models.Article;
import com.adams.topnews.ui.NewsDetailFragment;

import java.util.List;

public class NewsPagerAdapter extends FragmentPagerAdapter {
    private List<Article> mNews;

    public NewsPagerAdapter(@NonNull FragmentManager fm, int behavior, List<Article> mNews) {
        super(fm, behavior);
        this.mNews = mNews;
    }

    @Override
    public Fragment getItem(int position) {
        return NewsDetailFragment.newInstance(mNews.get(position));
    }

    @Override
    public int getCount() {
        return mNews.size();
    }
    @Override
    public CharSequence getPageTitle(int position){
        return mNews.get(position).getAuthor();
    }
}
