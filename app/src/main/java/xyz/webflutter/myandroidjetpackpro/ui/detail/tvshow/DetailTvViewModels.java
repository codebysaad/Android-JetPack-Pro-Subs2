package xyz.webflutter.myandroidjetpackpro.ui.detail.tvshow;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import xyz.webflutter.myandroidjetpackpro.data.Repository;
import xyz.webflutter.myandroidjetpackpro.ui.tvshow.TvShowModels;
import xyz.webflutter.myandroidjetpackpro.utils.DummyData;

public class DetailTvViewModels extends ViewModel {
    private Repository repository;
    private String id;

    public DetailTvViewModels(Repository repository){
        this.repository = repository;
    }

    LiveData<TvShowModels> getAllTvShow(){
        return repository.getDetailTvShow(id);
    }

    public void setId (String id){
        this.id = id;
    }

    public String getId(){
        return id;
    }
}
