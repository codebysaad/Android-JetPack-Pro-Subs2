package xyz.webflutter.myandroidjetpackpro.ui.detail.tvshow;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;
import java.util.Objects;

import xyz.webflutter.myandroidjetpackpro.R;
import xyz.webflutter.myandroidjetpackpro.adapter.TvShowAdapter;
import xyz.webflutter.myandroidjetpackpro.ui.detail.movie.DetailMovieViewModels;
import xyz.webflutter.myandroidjetpackpro.ui.tvshow.TvShowModels;
import xyz.webflutter.myandroidjetpackpro.utils.DummyData;
import xyz.webflutter.myandroidjetpackpro.utils.ViewModelFactory;

public class DetailTvShowActivity extends AppCompatActivity {
    public static final String EXTRA_ID = "EXTRA_ID_TV_SHOW";
    private TextView title, releaseDate, overview;
    private ImageView ivPoster;
    private List<TvShowModels> models;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tv_show );
        Toolbar toolbar = findViewById(R.id.toolbar_tv_show);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        title = findViewById(R.id.title_movie_detail);
        releaseDate = findViewById(R.id.release_date);
        overview = findViewById(R.id.overview_movie_detail);
        ivPoster = findViewById(R.id.image_poster);
        progressBar = findViewById(R.id.progress_detail);
        DetailTvViewModels viewModels = obtainViewModel(this);
        TvShowAdapter adapter = new TvShowAdapter(this);
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            String id = bundle.getString(EXTRA_ID);
            if (id != null){
                viewModels.setId(id);
                adapter.setTvShow(models);
                viewModels.getAllTvShow().observe(this, entity -> {
                    if (entity != null){
                        progressBar.setVisibility(View.GONE);
                        initializePopulate(entity);
                    }
                });
            }
        }
    }
    private void initializePopulate(TvShowModels entity){
        Glide.with(getApplicationContext())
                .load(DummyData.baseImageUrl + entity.getBackdrop_path())
                .error(R.drawable.ic_broken_image_black)
                .into(ivPoster);
        title.setText(entity.getName());
        releaseDate.setText(entity.getFirst_air_date());
        overview.setText(entity.getOverview());
    }

    @NonNull
    private static DetailTvViewModels obtainViewModel(AppCompatActivity activity) {

        ViewModelFactory factory = ViewModelFactory.getInstance(activity.getApplication());

        return ViewModelProviders.of(activity, factory).get(DetailTvViewModels.class);
    }
}
