package com.mughitszufar.submission3exp.listmovies.detailmovies;

import androidx.lifecycle.ViewModel;

import com.mughitszufar.submission3exp.listmovies.pojo.ResultsItems;

public class DetailMovieViewModel extends ViewModel {
    private ResultsItems resultsItem;

    public ResultsItems getResultsItem() {
        return resultsItem;
    }

    public void setResultsItem(ResultsItems resultsItem) {
        this.resultsItem = resultsItem;
    }
}
