package xyz.webflutter.myandroidjetpackpro.ui.movie;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import xyz.webflutter.myandroidjetpackpro.R;
import xyz.webflutter.myandroidjetpackpro.adapter.MovieAdapter;
import xyz.webflutter.myandroidjetpackpro.utils.DummyData;
import xyz.webflutter.myandroidjetpackpro.utils.ViewModelFactory;

public class MovieFragment extends Fragment {

    private RecyclerView rvMovie;
    private ProgressBar progressBar;
    private List<MovieModels> models;
    private MovieViewModel viewModel;
    private MovieAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_movie, container, false);
        rvMovie = root.findViewById(R.id.rv_movie);
        progressBar = root.findViewById(R.id.progress_movie);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getActivity() != null){
            viewModel = obtainViewModel(getActivity());
            viewModel.getAllMovies().observe(this, movies -> {
                progressBar.setVisibility(View.GONE);
                adapter.setMovies(movies);
                adapter.notifyDataSetChanged();
            });
            adapter = new MovieAdapter(getActivity());
            rvMovie.setLayoutManager(new LinearLayoutManager(getContext()));
            rvMovie.setHasFixedSize(true);
            rvMovie.setAdapter(adapter);
        }
    }

    @NonNull
    private static MovieViewModel obtainViewModel(FragmentActivity activity) {

        ViewModelFactory factory = ViewModelFactory.getInstance(activity.getApplication());
        return ViewModelProviders.of(activity, factory).get(MovieViewModel.class);
    }
}