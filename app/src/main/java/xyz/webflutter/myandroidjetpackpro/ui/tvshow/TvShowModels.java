package xyz.webflutter.myandroidjetpackpro.ui.tvshow;

import android.os.Parcel;
import android.os.Parcelable;

public class TvShowModels implements Parcelable {
    private String id, name, first_air_date, backdrop_path, overview;

    public TvShowModels(String id, String name, String overview, String first_air_date, String backdrop_path){
        this.id = id;
        this.name = name;
        this.overview = overview;
        this.first_air_date = first_air_date;
        this.backdrop_path = backdrop_path;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirst_air_date() {
        return first_air_date;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.name);
        dest.writeString(this.first_air_date);
        dest.writeString(this.backdrop_path);
        dest.writeString(this.overview);
    }

    private TvShowModels(Parcel in) {
        this.id = in.readString();
        this.name = in.readString();
        this.first_air_date = in.readString();
        this.backdrop_path = in.readString();
        this.overview = in.readString();
    }

    public static final Creator<TvShowModels> CREATOR = new Creator<TvShowModels>() {
        @Override
        public TvShowModels createFromParcel(Parcel source) {
            return new TvShowModels(source);
        }

        @Override
        public TvShowModels[] newArray(int size) {
            return new TvShowModels[size];
        }
    };
}
