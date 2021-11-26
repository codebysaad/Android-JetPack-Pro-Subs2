package xyz.webflutter.myandroidjetpackpro.utils;

import android.app.Application;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import xyz.webflutter.myandroidjetpackpro.ui.movie.MovieModels;
import xyz.webflutter.myandroidjetpackpro.ui.tvshow.TvShowModels;

public class JsonHelper {
    private Application application;
    public JsonHelper(Application application){
        this.application = application;
    }
    private String parsingFileJson(String fileName){
        try {
            InputStream inputStream = application.getAssets().open(fileName);
            byte[] buffer = new byte[inputStream.available()];
            inputStream.read(buffer);
            inputStream.close();
            return new String(buffer);
        }catch (IOException i){
            i.printStackTrace();
            return null;
        }
    }
    public List<MovieModels> loadMovies(){
        ArrayList<MovieModels> models = new ArrayList<>();
        try {
            JSONObject responseObject = new JSONObject(parsingFileJson("Movies.json"));
            JSONArray listArray = responseObject.getJSONArray("results");
            for (int i = 0; i < listArray.length(); i++) {
                JSONObject course = listArray.getJSONObject(i);

                String poster_path = course.getString("poster_path");
                String id = course.getString("id");
                String title = course.getString("title");
                String overview = course.getString("overview");
                String release_date = course.getString("release_date");

                MovieModels response = new MovieModels(
                        id,title,overview,release_date,poster_path
                );
                models.add(response);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return models;
    }
    public List<TvShowModels> loadTvShows() {
        ArrayList<TvShowModels> list = new ArrayList<>();

        try {
            JSONObject responseObject = new JSONObject(parsingFileJson("TvShow.json"));
            JSONArray listArray = responseObject.getJSONArray("results");
            for (int i = 0; i < listArray.length(); i++) {
                JSONObject course = listArray.getJSONObject(i);

                String name = course.getString("name");
                String first_air_date = course.getString("first_air_date");
                String backdrop_path = course.getString("backdrop_path");
                String id = course.getString("id");
                String overview = course.getString("overview");

                TvShowModels courseResponse = new TvShowModels(
                        id, name,overview,first_air_date,backdrop_path
                );
                list.add(courseResponse);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }
}
