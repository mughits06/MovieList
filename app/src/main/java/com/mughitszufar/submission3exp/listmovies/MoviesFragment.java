package com.mughitszufar.submission3exp.listmovies;


import android.content.DialogInterface;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.mughitszufar.submission3exp.R;
import com.mughitszufar.submission3exp.listmovies.detailmovies.DetailMovie;
import com.mughitszufar.submission3exp.listmovies.pojo.ResponseMovie;
import com.mughitszufar.submission3exp.listmovies.pojo.ResultsItems;

import java.util.List;

public class MoviesFragment extends Fragment {

    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private AlertDialog alertDialog;
    private ListMoviesAdapter mAdapterMovie;

    private Observer<List<ResultsItems>> getMovies = new Observer<List<ResultsItems>>() {
        @Override
        public void onChanged(List<ResultsItems> resultsItems) {
            if (resultsItems != null) {
//                if(resultsItems.getAnError()==null){


                mAdapterMovie.setData(resultsItems);


            } else {
                alertDialog.setMessage(getContext().getString(R.string.server_error));
                alertDialog.show();
            }
            progressBar.setVisibility(View.GONE);

        }
    };



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.fragment_movies, container, false);
        return getView() != null ? getView() : inflater.inflate(R.layout.fragment_movies, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ListMoviesViewModel mViewModel = ViewModelProviders.of(this).get(ListMoviesViewModel.class);
        mViewModel.getMovies().observe(this,getMovies);

        recyclerView = view.findViewById(R.id.recycler_view);
        progressBar = view.findViewById(R.id.progressBar);

        alertDialog = new AlertDialog.Builder(view.getContext()).setTitle(getString(R.string.failure)).setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        }).create();

        mAdapterMovie = new ListMoviesAdapter();
        mAdapterMovie.notifyDataSetChanged();
        mViewModel.setResponseMovies();
        showlistdata();

    }

    void showlistdata (){
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        mAdapterMovie.SetOnItemClickListener(new ListMoviesAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, ResultsItems model) {
                Intent goToDetailMovie = new Intent(view.getContext(), DetailMovie.class);
                goToDetailMovie.putExtra(DetailMovie.SELECTED_MOVIE,model);
                startActivity(goToDetailMovie);
            }
        });

        recyclerView.setAdapter(mAdapterMovie);
    }

}
