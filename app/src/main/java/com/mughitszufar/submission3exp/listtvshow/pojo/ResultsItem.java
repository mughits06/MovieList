package com.mughitszufar.submission3exp.listtvshow.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResultsItem implements Parcelable {

	//pojo tv

	@SerializedName("first_air_date")
	private String firstAirDate;

	@SerializedName("overview")
	private String overview;

	@SerializedName("original_language")
	private String originalLanguage;

	@SerializedName("genre_ids")
	private List<Integer> genreIds;

	@SerializedName("poster_path")
	private String posterPath;

	@SerializedName("origin_country")
	private List<String> originCountry;

	@SerializedName("backdrop_path")
	private String backdropPath;

	@SerializedName("original_name")
	private String originalName;

	@SerializedName("popularity")
	private double popularity;

	@SerializedName("vote_average")
	private double voteAverage;

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private int id;

	@SerializedName("vote_count")
	private int voteCount;


	public String getFirstAirDate(){
		return firstAirDate;
	}

	public String getOverview(){
		return overview;
	}

	public String getOriginalLanguage(){
		return originalLanguage;
	}

	public String getPosterPath(){
		return posterPath;
	}

	public String getName(){
		return name;
	}

	public int getVoteCount(){
		return voteCount;
	}

	@Override
	public String toString() {
		return
				"ResultsItem{" +
						"first_air_date = '" + firstAirDate + '\'' +
						",overview = '" + overview + '\'' +
						",original_language = '" + originalLanguage + '\'' +
						",genre_ids = '" + genreIds + '\'' +
						",poster_path = '" + posterPath + '\'' +
						",origin_country = '" + originCountry + '\'' +
						",backdrop_path = '" + backdropPath + '\'' +
						",original_name = '" + originalName + '\'' +
						",popularity = '" + popularity + '\'' +
						",vote_average = '" + voteAverage + '\'' +
						",name = '" + name + '\'' +
						",id = '" + id + '\'' +
						",vote_count = '" + voteCount + '\'' +
						"}";
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.firstAirDate);
		dest.writeString(this.overview);
		dest.writeString(this.originalLanguage);
		dest.writeList(this.genreIds);
		dest.writeString(this.posterPath);
		dest.writeStringList(this.originCountry);
		dest.writeString(this.backdropPath);
		dest.writeString(this.originalName);
		dest.writeDouble(this.popularity);
		dest.writeDouble(this.voteAverage);
		dest.writeString(this.name);
		dest.writeInt(this.id);
		dest.writeInt(this.voteCount);
	}


	private ResultsItem(Parcel in) {
		this.firstAirDate = in.readString();
		this.overview = in.readString();
		this.originalLanguage = in.readString();
		this.genreIds = new ArrayList<>();
		in.readList(this.genreIds, Integer.class.getClassLoader());
		this.posterPath = in.readString();
		this.originCountry = in.createStringArrayList();
		this.backdropPath = in.readString();
		this.originalName = in.readString();
		this.popularity = in.readDouble();
		this.voteAverage = in.readDouble();
		this.name = in.readString();
		this.id = in.readInt();
		this.voteCount = in.readInt();
	}

	public static final Parcelable.Creator<ResultsItem> CREATOR = new Parcelable.Creator<ResultsItem>() {
		@Override
		public ResultsItem createFromParcel(Parcel in) {
			return new ResultsItem(in);
		}

		@Override
		public ResultsItem[] newArray(int size) {
			return new ResultsItem[size];
		}
	};
}