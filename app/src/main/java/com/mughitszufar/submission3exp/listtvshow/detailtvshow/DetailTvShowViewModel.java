package com.mughitszufar.submission3exp.listtvshow.detailtvshow;

import androidx.lifecycle.ViewModel;

import com.mughitszufar.submission3exp.listtvshow.pojo.ResultsItem;

public class DetailTvShowViewModel extends ViewModel {

    private ResultsItem resultsItem;

    public ResultsItem getResultsItem() {
        return resultsItem;
    }

    public void setResultsItem(ResultsItem resultsItem) {
        this.resultsItem = resultsItem;
    }
}

