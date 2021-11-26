package xyz.webflutter.myandroidjetpackpro.ui.movie;

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

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MovieViewModelTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();
    private MovieViewModel viewModel;
    private Repository repository = mock(Repository.class);

    @Before
    public void setUp(){
        viewModel = new MovieViewModel(repository);
    }

    @Test
    public void getMovies() {
        ArrayList<MovieModels> dummyMovie = DummyData.generateDataMovies();
        MutableLiveData<List<MovieModels>> movies = new MutableLiveData<>();
        movies.setValue(dummyMovie);

        when(repository.getMovies()).thenReturn(movies);
        Observer<List<MovieModels>> observer = mock(Observer.class);
        viewModel.getAllMovies().observeForever(observer);
        verify(observer).onChanged(dummyMovie);
    }
}