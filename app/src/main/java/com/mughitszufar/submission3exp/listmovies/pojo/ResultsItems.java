package com.mughitszufar.submission3exp.listmovies.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResultsItems implements Parcelable {

	@SerializedName("overview")
	private String overview;

	@SerializedName("original_language")
	private String originalLanguage;

	@SerializedName("original_title")
	private String originalTitle;

	@SerializedName("video")
	private boolean video;

	@SerializedName("title")
	private String title;

	@SerializedName("genre_ids")
	private List<Integer> genreIds;

	@SerializedName("poster_path")
	private String posterPath;

	@SerializedName("backdrop_path")
	private String backdropPath;

	@SerializedName("release_date")
	private String releaseDate;

	@SerializedName("popularity")
	private double popularity;

	@SerializedName("vote_average")
	private double voteAverage;

	@SerializedName("id")
	private int id;

	@SerializedName("adult")
	private boolean adult;

	@SerializedName("vote_count")
	private int voteCount;


	public String getReleaseDate() {
		return releaseDate;
	}

	public String getOverview() {
		return overview;
	}

	public String getOriginalLanguage() {
		return originalLanguage;
	}

	public String getTitle() {
		return title;
	}

	public String getPosterPath() {
		return posterPath;
	}

	public int getVoteCount() {
		return voteCount;
	}

	@Override
	public String toString() {
		return
				"ResultsItems{" +
						"overview = '" + overview + '\'' +
						",original_language = '" + originalLanguage + '\'' +
						",original_title = '" + originalTitle + '\'' +
						",video = '" + video + '\'' +
						",title = '" + title + '\'' +
						",genre_ids = '" + genreIds + '\'' +
						",poster_path = '" + posterPath + '\'' +
						",backdrop_path = '" + backdropPath + '\'' +
						",release_date = '" + releaseDate + '\'' +
						",popularity = '" + popularity + '\'' +
						",vote_average = '" + voteAverage + '\'' +
						",id = '" + id + '\'' +
						",adult = '" + adult + '\'' +
						",vote_count = '" + voteCount + '\'' +
						"}";
	}

	private ResultsItems(Parcel in) {
		this.overview = in.readString();
		this.originalLanguage = in.readString();
		this.originalTitle = in.readString();
		this.video = in.readByte() != 0;
		this.title = in.readString();
		this.genreIds = new ArrayList<>();
		in.readList(this.genreIds, Integer.class.getClassLoader());
		this.posterPath = in.readString();
		this.backdropPath = in.readString();
		this.releaseDate = in.readString();
		this.popularity = in.readDouble();
		this.voteAverage = in.readDouble();
		this.id = in.readInt();
		this.adult = in.readByte() != 0;
		this.voteCount = in.readInt();
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.overview);
		dest.writeString(this.originalLanguage);
		dest.writeString(this.originalTitle);
		dest.writeByte(this.video ? (byte) 1 : (byte) 0);
		dest.writeString(this.title);
		dest.writeList(this.genreIds);
		dest.writeString(this.posterPath);
		dest.writeString(this.backdropPath);
		dest.writeString(this.releaseDate);
		dest.writeDouble(this.popularity);
		dest.writeDouble(this.voteAverage);
		dest.writeInt(this.id);
		dest.writeByte(this.adult ? (byte) 1 : (byte) 0);
		dest.writeInt(this.voteCount);

	}

	public static final Parcelable.Creator<ResultsItems> CREATOR = new Parcelable.Creator<ResultsItems>() {
		@Override
		public ResultsItems createFromParcel(Parcel source) {
			return new ResultsItems(source);
		}

		@Override
		public ResultsItems[] newArray(int size) {
			return new ResultsItems[size];
		}

	};
}