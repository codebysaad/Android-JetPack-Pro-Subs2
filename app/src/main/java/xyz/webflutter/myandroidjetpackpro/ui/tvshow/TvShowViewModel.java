package xyz.webflutter.myandroidjetpackpro.ui.tvshow;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import xyz.webflutter.myandroidjetpackpro.data.Repository;
import xyz.webflutter.myandroidjetpackpro.utils.DummyData;

public class TvShowViewModel extends ViewModel {
    private Repository repository;
    public TvShowViewModel(Repository repository){
        this.repository = repository;
    }
    LiveData<List<TvShowModels>> getAllTvShows(){
        return repository.getTvShows();
    }
}