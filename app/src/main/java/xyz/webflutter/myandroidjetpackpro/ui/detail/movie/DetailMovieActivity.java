package xyz.webflutter.myandroidjetpackpro.ui.detail.movie;

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
import xyz.webflutter.myandroidjetpackpro.adapter.MovieAdapter;
import xyz.webflutter.myandroidjetpackpro.ui.movie.MovieModels;
import xyz.webflutter.myandroidjetpackpro.utils.DummyData;
import xyz.webflutter.myandroidjetpackpro.utils.ViewModelFactory;

public class DetailMovieActivity extends AppCompatActivity {

    public static final String EXTRA_ID = "EXTRA_ID";
    private TextView title, releaseDate, overview;
    private ImageView ivPoster;
    private List<MovieModels> models;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);
        Toolbar toolbar = findViewById(R.id.toolbar_movie);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        title = findViewById(R.id.title_movie_detail);
        releaseDate = findViewById(R.id.release_date);
        overview = findViewById(R.id.overview_movie_detail);
        ivPoster = findViewById(R.id.image_poster);
        progressBar = findViewById(R.id.progress_detail);
        DetailMovieViewModels viewModels = obtainViewModel(this);
        MovieAdapter adapter = new MovieAdapter(this);
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            String id = bundle.getString(EXTRA_ID);
            if (id != null){
                viewModels.setId(id);
                adapter.setMovies(models);
                viewModels.getDetailMovie().observe(this, entity ->{
                    if (entity != null){
                        progressBar.setVisibility(View.GONE);
                        initializePopulate(entity);
                    }
                });
            }
        }
    }
    private void initializePopulate(MovieModels entity){
        Glide.with(getApplicationContext())
                .load(DummyData.baseImageUrl + entity.getPoster_path())
                .error(R.drawable.ic_broken_image_black)
                .into(ivPoster);
        title.setText(entity.getTitle());
        releaseDate.setText(entity.getRelease_date());
        overview.setText(entity.getOverview());
    }

    @NonNull
    private static DetailMovieViewModels obtainViewModel(AppCompatActivity activity) {

        ViewModelFactory factory = ViewModelFactory.getInstance(activity.getApplication());

        return ViewModelProviders.of(activity, factory).get(DetailMovieViewModels.class);
    }
}
