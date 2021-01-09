package com.mughitszufar.submission3exp.listtvshow.detailtvshow;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.mughitszufar.submission3exp.R;
import com.mughitszufar.submission3exp.databinding.ActivityDetailTvShowsBinding;
import com.mughitszufar.submission3exp.listtvshow.pojo.ResultsItem;

import java.util.Objects;

public class DetailTvShows extends AppCompatActivity {

    public static final String SELECTED_TV_SHOWS = "selected_tv_shows";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        DetailTvShowViewModel viewModel = ViewModelProviders.of(this).get(DetailTvShowViewModel.class);
        ActivityDetailTvShowsBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_detail_tv_shows);
        ResultsItem movieModel = getIntent().getParcelableExtra(SELECTED_TV_SHOWS);
        viewModel.setResultsItem(movieModel);

        Glide.with(this).load("https://image.tmdb.org/t/p/w185/"+movieModel.getPosterPath()).into(binding.imgPoster);
        setTitle(viewModel.getResultsItem().getName());

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}

