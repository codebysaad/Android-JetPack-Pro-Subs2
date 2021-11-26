package xyz.webflutter.myandroidjetpackpro.data.remote;

import android.os.Handler;

import java.util.List;

import xyz.webflutter.myandroidjetpackpro.ui.movie.MovieModels;
import xyz.webflutter.myandroidjetpackpro.ui.tvshow.TvShowModels;
import xyz.webflutter.myandroidjetpackpro.utils.JsonHelper;

public class RemoteRepository {
    private static RemoteRepository INSTANCE;
    private JsonHelper jsonHelper;
    private final long SERVICE_LATENCY_IN_MILES = 2000;

    private RemoteRepository(JsonHelper jsonHelper){
        this.jsonHelper = jsonHelper;
    }
    public static RemoteRepository getInstance(JsonHelper jsonHelper){
        if (INSTANCE == null){
            INSTANCE = new RemoteRepository(jsonHelper);
        }
        return INSTANCE;
    }

    public void getMovie(LoadMovieCallback movieCallback){
        Handler handler = new Handler();
        handler.postDelayed(() -> movieCallback.onAllMoviesReceived(jsonHelper.loadMovies()), SERVICE_LATENCY_IN_MILES);
    }

    public void getTvShow(LoadTvShowCallback tvShowCallback){
        Handler handler = new Handler();
        handler.postDelayed(() -> tvShowCallback.onAllTvShowReceived(jsonHelper.loadTvShows()), SERVICE_LATENCY_IN_MILES);
    }

    public interface LoadMovieCallback{
        void onAllMoviesReceived(List<MovieModels> movieModels);
    }
    public interface LoadTvShowCallback{
        void onAllTvShowReceived(List<TvShowModels> tvShowModels);
    }
}
