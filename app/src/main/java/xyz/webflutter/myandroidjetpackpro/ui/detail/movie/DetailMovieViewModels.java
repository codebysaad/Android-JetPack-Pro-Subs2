package xyz.webflutter.myandroidjetpackpro.ui.detail.movie;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import xyz.webflutter.myandroidjetpackpro.data.Repository;
import xyz.webflutter.myandroidjetpackpro.ui.movie.MovieModels;
import xyz.webflutter.myandroidjetpackpro.utils.DummyData;

public class DetailMovieViewModels extends ViewModel {
    private Repository repository;
    private String id;

    public DetailMovieViewModels(Repository repository){
        this.repository = repository;
    }

    LiveData<MovieModels> getDetailMovie(){
        return repository.getDetailMovie(id);
    }

    public void setId (String id){
        this.id = id;
    }

    public String getId(){
        return id;
    }
}
