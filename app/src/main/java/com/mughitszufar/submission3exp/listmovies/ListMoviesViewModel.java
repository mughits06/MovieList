package com.mughitszufar.submission3exp.listmovies;


import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.mughitszufar.submission3exp.MovieCatalog;
import com.mughitszufar.submission3exp.listmovies.pojo.ResponseMovie;
import com.mughitszufar.submission3exp.listmovies.pojo.ResultsItems;

import java.util.List;

public class ListMoviesViewModel extends ViewModel {

    private MutableLiveData<List<ResultsItems>> responseMovies = new MutableLiveData<>();


    public MutableLiveData getMovies(){
        if(responseMovies==null){
            setResponseMovies();
        }
        return responseMovies;
    }

    public void setResponseMovies(){
        AndroidNetworking.get("https://api.themoviedb.org/3/discover/movie")
                .addQueryParameter("api_key", MovieCatalog.MOVIE_DB_API_KEY)
                .addQueryParameter("language","en-US")
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsObject(ResponseMovie.class, new ParsedRequestListener<ResponseMovie>() {
                    @Override
                    public void onResponse(ResponseMovie response) {
                        responseMovies.postValue(response.getResults());
                        Log.d("ViewModelMovie", "onResponse: " + response.toString());
                    }

                    @Override
                    public void onError(ANError anError) {
                        Log.d("ViewModelMovie", "onError: " + anError.getMessage());
                    }
                });
    }

}
