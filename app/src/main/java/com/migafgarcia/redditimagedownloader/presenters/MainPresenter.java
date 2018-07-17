package com.migafgarcia.redditimagedownloader.presenters;

import android.arch.lifecycle.LiveData;
import android.util.Log;

import com.migafgarcia.redditimagedownloader.db.AppDatabase;
import com.migafgarcia.redditimagedownloader.db.SubredditData;
import com.migafgarcia.redditimagedownloader.model.Thing;
import com.migafgarcia.redditimagedownloader.services.RedditApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter {

    private static final String TAG = MainPresenter.class.getName();
    private final MainScreen mainScreen;
    private final RedditApi redditApi;
    private final AppDatabase appDatabase;

    private String multireddit;


    public MainPresenter(MainScreen mainScreen, RedditApi redditApi, AppDatabase appDatabase) {
        this.mainScreen = mainScreen;
        this.redditApi = redditApi;
        this.appDatabase = appDatabase;
    }

    public void getPosts() {

        mainScreen.showLoading();

        StringBuilder stringBuilder = new StringBuilder();

        for (SubredditData data : appDatabase.getSubredditDataDao().getSubreddits()) {
            stringBuilder.append(data.name);
            stringBuilder.append('+');
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        multireddit = stringBuilder.toString();

        redditApi.getService().getList(multireddit).enqueue(new Callback<Thing>() {
            @Override
            public void onResponse(Call<Thing> call, Response<Thing> response) {
                if (response.isSuccessful()) {
                    mainScreen.getPosts(response.body());
                } else
                    mainScreen.showGetRetry();

                mainScreen.hideLoading();
            }

            @Override
            public void onFailure(Call<Thing> call, Throwable t) {
                mainScreen.showGetRetry();
                mainScreen.hideLoading();

            }
        });
    }


    public void morePosts(final String after) {
        mainScreen.showLoading();
        redditApi.getService().getListAfter(multireddit, after).enqueue(new Callback<Thing>() {
            @Override
            public void onResponse(Call<Thing> call, Response<Thing> response) {
                if (response.isSuccessful()) {
                    mainScreen.morePosts(response.body());
                } else
                    mainScreen.showMoreRetry(after);

                mainScreen.hideLoading();
            }

            @Override
            public void onFailure(Call<Thing> call, Throwable t) {
                mainScreen.showMoreRetry(after);
                mainScreen.hideLoading();

            }
        });
    }
}
