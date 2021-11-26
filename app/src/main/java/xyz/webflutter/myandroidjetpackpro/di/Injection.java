package xyz.webflutter.myandroidjetpackpro.di;

import android.app.Application;

import xyz.webflutter.myandroidjetpackpro.data.Repository;
import xyz.webflutter.myandroidjetpackpro.data.remote.RemoteRepository;
import xyz.webflutter.myandroidjetpackpro.utils.JsonHelper;

public class Injection {
    public static Repository providersRepository(Application application){
        RemoteRepository remoteRepository = RemoteRepository.getInstance(new JsonHelper(application));
        return Repository.getInstance(remoteRepository);
    }
}
