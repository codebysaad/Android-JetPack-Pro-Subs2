package xyz.webflutter.myandroidjetpackpro.data;

import androidx.lifecycle.LiveData;

import java.util.List;

import xyz.webflutter.myandroidjetpackpro.ui.movie.MovieModels;
import xyz.webflutter.myandroidjetpackpro.ui.tvshow.TvShowModels;

public interface DataSource {
    LiveData<List<MovieModels>> getMovies();
    LiveData<MovieModels> getDetailMovie(String id);
    LiveData<List<TvShowModels>> getTvShows();
    LiveData<TvShowModels> getDetailTvShow(String id);
}
