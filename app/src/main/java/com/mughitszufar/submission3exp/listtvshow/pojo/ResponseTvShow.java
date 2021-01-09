package com.mughitszufar.submission3exp.listtvshow.pojo;

import java.util.List;

import com.androidnetworking.error.ANError;
import com.google.gson.annotations.SerializedName;

public class ResponseTvShow{

	private ANError anError;

	public ResponseTvShow(ANError anError) {
		this.anError = anError;
	}

	public ResponseTvShow() {
	}

	public ANError getAnError() {
		return anError;
	}


	@SerializedName("page")
	private int page;

	@SerializedName("total_pages")
	private int totalPages;

	@SerializedName("results")
	private List<ResultsItem> results;

	@SerializedName("total_results")
	private int totalResults;


	public List<ResultsItem> getResults(){
		return results;
	}

	@Override
 	public String toString(){
		return 
			"ResponseTvShow{" + 
			"page = '" + page + '\'' + 
			",total_pages = '" + totalPages + '\'' + 
			",results = '" + results + '\'' + 
			",total_results = '" + totalResults + '\'' + 
			"}";
		}

}