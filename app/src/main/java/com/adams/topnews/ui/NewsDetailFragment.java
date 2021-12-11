package com.adams.topnews.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Parcel;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.adams.topnews.R;
import com.adams.topnews.models.Article;
import com.adams.topnews.models.Source;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NewsDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NewsDetailFragment extends Fragment {
    @BindView(R.id.saveNewsButton)
    Button mSaveNewsButton;
    @BindView(R.id.newsNameTextView)
    TextView mNewsNameTextView;
    @BindView(R.id.newsImageView)
    ImageView mNewsImageview;

    private Article mArticle;

    private static final String ARG_PARAM1 = "Article";
    private static final String ARG_PARAM2 = "news";

    // TODO: Rename and change types of parameters
    private String mArticles;
    private String mNews;

    public NewsDetailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     *
     * @return A new instance of fragment NewsDetailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NewsDetailFragment newInstance(String Article, String news) {
        NewsDetailFragment newsDetailFragment = new NewsDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("news", Parcels.wrap(news));
        newsDetailFragment.setArguments(args);
        return newsDetailFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        assert getArguments() != null;
        mNews = Parcels.unwrap(getArguments().getParcelable("news"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_news_detail, container, false);
        ButterKnife.bind(this, view);
        Picasso.get().load(mArticle.getUrlToImage()).into(mNewsImageview);

        List<String> source = new ArrayList<>();

        for (Source sources: mArticle.getSource()) sources.getName();
        return  view;
    }
}