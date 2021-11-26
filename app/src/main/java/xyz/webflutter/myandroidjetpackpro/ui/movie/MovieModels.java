package xyz.webflutter.myandroidjetpackpro.ui.movie;

import android.os.Parcel;
import android.os.Parcelable;

public class MovieModels implements Parcelable {
    private String id, poster_path, title, overview, release_date;

    public MovieModels(String id, String title, String overview, String release_date, String poster_path) {
        this.poster_path = poster_path;
        this.title = title;
        this.overview = overview;
        this.release_date = release_date;
        this.id = id;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getRelease_date() {
        return release_date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.poster_path);
        dest.writeString(this.title);
        dest.writeString(this.overview);
        dest.writeString(this.release_date);
        dest.writeString(this.id);
    }

    protected MovieModels(Parcel in) {
        this.poster_path = in.readString();
        this.title = in.readString();
        this.overview = in.readString();
        this.release_date = in.readString();
        this.id = in.readString();
    }

    public static final Creator<MovieModels> CREATOR = new Creator<MovieModels>() {
        @Override
        public MovieModels createFromParcel(Parcel source) {
            return new MovieModels(source);
        }

        @Override
        public MovieModels[] newArray(int size) {
            return new MovieModels[size];
        }
    };
}