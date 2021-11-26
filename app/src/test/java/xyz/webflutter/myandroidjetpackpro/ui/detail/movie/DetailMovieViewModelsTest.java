package xyz.webflutter.myandroidjetpackpro.ui.detail.movie;

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
import xyz.webflutter.myandroidjetpackpro.utils.DummyData;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class DetailMovieViewModelsTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();
    private DetailMovieViewModels viewModels;
    private Repository repository = mock(Repository.class);
    private MovieModels models = DummyData.generateDataMovies().get(0);
    private String id = models.getId();

    @Before
    public void setUp() {
        viewModels = new DetailMovieViewModels(repository);
        viewModels.setId(id);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void getDetailMovie() {
        MutableLiveData<MovieModels> entities = new MutableLiveData<>();
        entities.setValue(models);
        when(repository.getDetailMovie(id)).thenReturn(entities);
        Observer<MovieModels> observer = mock(Observer.class);
        viewModels.getDetailMovie().observeForever(observer);
        verify(observer).onChanged(models);
    }
}