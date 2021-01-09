package com.mughitszufar.submission3exp.listtvshow;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mughitszufar.submission3exp.R;
import com.mughitszufar.submission3exp.listtvshow.detailtvshow.DetailTvShows;
import com.mughitszufar.submission3exp.listtvshow.pojo.ResponseTvShow;
import com.mughitszufar.submission3exp.listtvshow.pojo.ResultsItem;

import java.util.List;


public class TvShowFragment extends Fragment {

    private RecyclerView recyclerView;
    private AlertDialog alertDialog;
    private ProgressBar progressBar;
    private ListTvShowsAdapter mAdapterTv;

    private Observer<List<ResultsItem>> getTvshow = new Observer<List<ResultsItem>>() {
        @Override
        public void onChanged(List<ResultsItem> resultsItems) {
            if (resultsItems != null) {
//                if (resultsItems.getAnError() == null) {


                mAdapterTv.setData(resultsItems);


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
        return getView() != null ? getView() : inflater.inflate(R.layout.fragment_tv_show, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ListTvShowViewModel mViewModel = ViewModelProviders.of(this).get(ListTvShowViewModel.class);
        mViewModel.getMovies().observe(this, getTvshow);

        recyclerView = view.findViewById(R.id.recycler_view);
        progressBar = view.findViewById(R.id.progressBar);

        alertDialog = new AlertDialog.Builder(view.getContext()).setTitle(getString(R.string.failure))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).create();

        mAdapterTv = new ListTvShowsAdapter();
        mAdapterTv.notifyDataSetChanged();
        mViewModel.setResponseTvShows();
        showlistdata();


    }

    void showlistdata() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        mAdapterTv.SetOnItemClickListener(new ListTvShowsAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, ResultsItem model) {
                Intent goToDetailTvshows = new Intent(view.getContext(), DetailTvShows.class);
                goToDetailTvshows.putExtra(DetailTvShows.SELECTED_TV_SHOWS, model);
                startActivity(goToDetailTvshows);
            }
        });

        recyclerView.setAdapter(mAdapterTv);
    }

}

