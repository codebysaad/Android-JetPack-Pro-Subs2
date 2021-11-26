package xyz.webflutter.myandroidjetpackpro.ui.detail.tvshow;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.List;

import xyz.webflutter.myandroidjetpackpro.data.Repository;
import xyz.webflutter.myandroidjetpackpro.ui.movie.MovieModels;
import xyz.webflutter.myandroidjetpackpro.ui.tvshow.TvShowModels;
import xyz.webflutter.myandroidjetpackpro.ui.tvshow.TvShowViewModel;
import xyz.webflutter.myandroidjetpackpro.utils.DummyData;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class DetailTvViewModelsTest {
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();
    private DetailTvViewModels viewModels;
    private Repository repository = mock(Repository.class);
    private TvShowModels models = DummyData.generateDataTvShow().get(0);
    private String id = models.getId();

    @Before
    public void setUp() {
        viewModels = new DetailTvViewModels(repository);
        viewModels.setId(id);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void getDetailTvShow() {
        MutableLiveData<TvShowModels> entities = new MutableLiveData<>();
        entities.setValue(models);
        when(repository.getDetailTvShow(id)).thenReturn(entities);
        Observer<TvShowModels> observer = mock(Observer.class);
        viewModels.getAllTvShow().observeForever(observer);
        verify(observer).onChanged(models);
    }
}