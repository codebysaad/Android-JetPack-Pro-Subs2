package xyz.webflutter.myandroidjetpackpro.ui.tvshow;

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
import xyz.webflutter.myandroidjetpackpro.adapter.TvShowAdapter;
import xyz.webflutter.myandroidjetpackpro.utils.ViewModelFactory;

public class TvShowFragment extends Fragment {

    private RecyclerView rvTvShow;
    private ProgressBar progressBar;
    private List<TvShowModels> models;
    private TvShowViewModel viewModel;
    private TvShowAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_tv_show, container, false);
        rvTvShow = root.findViewById(R.id.rv_tv_show);
        progressBar = root.findViewById(R.id.progress_tv_show);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getActivity() != null){
            viewModel = obtainViewModel(getActivity());
            viewModel.getAllTvShows().observe(this, tvShow -> {
                progressBar.setVisibility(View.GONE);
                adapter.setTvShow(tvShow);
                adapter.notifyDataSetChanged();
            });
            adapter = new TvShowAdapter(getActivity());
            rvTvShow.setLayoutManager(new LinearLayoutManager(getContext()));
            rvTvShow.setHasFixedSize(true);
            rvTvShow.setAdapter(adapter);
        }
    }

    @NonNull
    private static TvShowViewModel obtainViewModel(FragmentActivity activity) {

        ViewModelFactory factory = ViewModelFactory.getInstance(activity.getApplication());
        return ViewModelProviders.of(activity, factory).get(TvShowViewModel.class);
    }
}