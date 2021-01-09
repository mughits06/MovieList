package com.mughitszufar.submission3exp.listmovies.pojo;

import java.util.List;

import com.androidnetworking.error.ANError;
import com.google.gson.annotations.SerializedName;

public class ResponseMovie {



	@SerializedName("page")
	private int page;

	@SerializedName("total_pages")
	private int totalPages;

	@SerializedName("results")
	private List<ResultsItems> results;

	@SerializedName("total_results")
	private int totalResults;

	public ResponseMovie(ANError anError) {
		this.anError = anError;

	}

	public List<ResultsItems> getResults(){
		return results;
	}

	private ANError anError;

	public ANError getAnError() {
		return anError;
	}

	@Override
 	public String toString(){
		return 
			"ResponseMovie{" +
			",page = '" + page + '\'' + 
			",total_pages = '" + totalPages + '\'' + 
			",results = '" + results + '\'' + 
			",total_results = '" + totalResults + '\'' + 
			"}";
		}
}