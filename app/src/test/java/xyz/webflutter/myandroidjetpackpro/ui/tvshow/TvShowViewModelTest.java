package xyz.webflutter.myandroidjetpackpro.ui.tvshow;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import xyz.webflutter.myandroidjetpackpro.data.Repository;
import xyz.webflutter.myandroidjetpackpro.utils.DummyData;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

public class TvShowViewModelTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();
    private TvShowViewModel viewModel;
    private Repository repository = mock(Repository.class);

    @Before
    public void setUp(){
        viewModel = new TvShowViewModel(repository);
    }

    @Test
    public void getTvShows() {
        ArrayList<TvShowModels> dummyTvShow = DummyData.generateDataTvShow();
        MutableLiveData<List<TvShowModels>> tvShow = new MutableLiveData<>();
        tvShow.setValue(dummyTvShow);

        when(repository.getTvShows()).thenReturn(tvShow);
        Observer<List<TvShowModels>> observer = mock(Observer.class);
        viewModel.getAllTvShows().observeForever(observer);
        verify(observer).onChanged(dummyTvShow);
    }
}