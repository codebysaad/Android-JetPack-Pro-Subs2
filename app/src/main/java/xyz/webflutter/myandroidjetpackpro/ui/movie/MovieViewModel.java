package xyz.webflutter.myandroidjetpackpro.ui.movie;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import xyz.webflutter.myandroidjetpackpro.data.Repository;
import xyz.webflutter.myandroidjetpackpro.utils.DummyData;

public class MovieViewModel extends ViewModel {

    private Repository repository;

    public MovieViewModel(Repository repository){
        this.repository = repository;
    }

    LiveData<List<MovieModels>> getAllMovies(){
        return repository.getMovies();
    }
}