package xyz.webflutter.myandroidjetpackpro.data;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

import xyz.webflutter.myandroidjetpackpro.data.remote.RemoteRepository;
import xyz.webflutter.myandroidjetpackpro.ui.movie.MovieModels;
import xyz.webflutter.myandroidjetpackpro.ui.tvshow.TvShowModels;
import xyz.webflutter.myandroidjetpackpro.utils.ExpressoIdlingResource;

public class Repository implements DataSource {
    public volatile static Repository INSTANCE = null;
    private final RemoteRepository remoteRepository;

    public Repository(@NonNull RemoteRepository remoteRepository){
        this.remoteRepository = remoteRepository;
    }

    public static Repository getInstance(RemoteRepository remoteRepository){
        if (INSTANCE == null){
            synchronized (Repository.class){
                if (INSTANCE == null){
                    INSTANCE = new Repository(remoteRepository);
                }
            }
        }
        return INSTANCE;
    }
    @Override
    public LiveData<List<MovieModels>> getMovies() {
        ExpressoIdlingResource.increment();
        MutableLiveData<List<MovieModels>> resultMovie = new MutableLiveData<>();

        remoteRepository.getMovie(new RemoteRepository.LoadMovieCallback() {
            @Override
            public void onAllMoviesReceived(List<MovieModels> movieModels) {
                ArrayList<MovieModels> models = new ArrayList<>();
                for (int i = 0; i < movieModels.size(); i++){
                    MovieModels response = movieModels.get(i);
                    MovieModels entity = new MovieModels(
                            response.getId(), response.getTitle(), response.getOverview(), response.getRelease_date(), response.getPoster_path()
                    );
                    models.add(entity);
                }
                resultMovie.postValue(models);
                ExpressoIdlingResource.decrement();
            }
        });
        return resultMovie;
    }

    @Override
    public LiveData<MovieModels> getDetailMovie(String id) {
        MutableLiveData<MovieModels> resultDetailMovie = new MutableLiveData<>();
        ExpressoIdlingResource.increment();
        remoteRepository.getMovie(new RemoteRepository.LoadMovieCallback() {
            @Override
            public void onAllMoviesReceived(List<MovieModels> movieModels) {
                for (int i = 0; i < movieModels.size(); i++){
                    MovieModels models = movieModels.get(i);
                    if (models.getId().equals(id)){
                        MovieModels entity = new MovieModels(
                                models.getId(), models.getTitle(), models.getOverview(), models.getRelease_date(), models.getPoster_path()
                        );
                        resultDetailMovie.postValue(entity);
                        ExpressoIdlingResource.decrement();
                    }
                }
            }
        });
        return resultDetailMovie;
    }

    @Override
    public LiveData<List<TvShowModels>> getTvShows() {
        MutableLiveData<List<TvShowModels>> resultTvShow = new MutableLiveData<>();
        ExpressoIdlingResource.increment();
        remoteRepository.getTvShow(new RemoteRepository.LoadTvShowCallback() {
            @Override
            public void onAllTvShowReceived(List<TvShowModels> tvShowModels) {
                ArrayList<TvShowModels> models = new ArrayList<>();
                for (int i = 0; i < tvShowModels.size(); i++){
                    TvShowModels response = tvShowModels.get(i);
                    TvShowModels entity = new TvShowModels(
                            response.getId(), response.getName(), response.getOverview(), response.getFirst_air_date(), response.getBackdrop_path()
                    );
                    models.add(entity);
                }
                resultTvShow.postValue(models);
                ExpressoIdlingResource.decrement();
            }
        });
        return resultTvShow;
    }

    @Override
    public LiveData<TvShowModels> getDetailTvShow(String id) {
        MutableLiveData<TvShowModels> resultDetailTvShow = new MutableLiveData<>();
        ExpressoIdlingResource.increment();
        remoteRepository.getTvShow(new RemoteRepository.LoadTvShowCallback() {
            @Override
            public void onAllTvShowReceived(List<TvShowModels> tvShowModels) {
                for (int i =0; i < tvShowModels.size(); i++){
                    TvShowModels models = tvShowModels.get(i);
                    if (models.getId().equals(id)){
                        TvShowModels entity = new TvShowModels(
                                models.getId(), models.getName(), models.getOverview(), models.getFirst_air_date(), models.getBackdrop_path()
                        );
                        resultDetailTvShow.postValue(entity);
                        ExpressoIdlingResource.decrement();
                    }
                }
            }
        });
        return resultDetailTvShow;
    }
}
