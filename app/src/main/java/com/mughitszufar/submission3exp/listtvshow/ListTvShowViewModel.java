package com.mughitszufar.submission3exp.listtvshow;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.mughitszufar.submission3exp.MovieCatalog;
import com.mughitszufar.submission3exp.listtvshow.pojo.ResponseTvShow;
import com.mughitszufar.submission3exp.listtvshow.pojo.ResultsItem;

import java.util.List;

public class ListTvShowViewModel extends ViewModel {
    private MutableLiveData<List<ResultsItem>> responseTvShows = new MutableLiveData<>();

    public MutableLiveData getMovies(){
        if (responseTvShows==null){
            setResponseTvShows();
        }

        return responseTvShows;

    }

    public void setResponseTvShows() {
        AndroidNetworking.get("https://api.themoviedb.org/3/discover/tv")
                .addQueryParameter("api_key", MovieCatalog.MOVIE_DB_API_KEY)
                .addQueryParameter("language", "en-US")
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsObject(ResponseTvShow.class, new ParsedRequestListener<ResponseTvShow>() {

                    @Override
                    public void onResponse(ResponseTvShow response) {
                        responseTvShows.postValue(response.getResults());
                        Log.d("ViewModelTv", "onResponse" + response.toString());
                    }

                    @Override
                    public void onError(ANError anError) {
                        Log.d("ViewModelTv", "onError" + anError.getMessage());
                    }
                });
    }
}
