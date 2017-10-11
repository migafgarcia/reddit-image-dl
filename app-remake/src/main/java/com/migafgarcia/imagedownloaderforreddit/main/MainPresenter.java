package com.migafgarcia.imagedownloaderforreddit.main;

import com.migafgarcia.imagedownloaderforreddit.model.Thing;
import com.migafgarcia.imagedownloaderforreddit.services.RedditApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter implements MainContract.Presenter {

    private final MainContract.View view;
    private final RedditApi redditApi;

    public MainPresenter(MainContract.View view, RedditApi redditApi) {
        this.view = view;
        this.redditApi = redditApi;
    }

    @Override
    public void start() {

    }

    @Override
    public void loadLinks() {
        view.setLoading(true);

        String multireddit = "";

        // TODO: 21-08-2017 fetch subreddits from sqlite
        redditApi.getService().getListing(multireddit).enqueue(new Callback<Thing>() {
            @Override
            public void onResponse(Call<Thing> call, Response<Thing> response) {
                if (response.isSuccessful()) {
                    view.addPosts(response.body());
                } else
                    view.showRetry();

                view.setLoading(false);
            }

            @Override
            public void onFailure(Call<Thing> call, Throwable t) {
                view.showRetry();
                view.setLoading(false);

            }
        });
    }

    @Override
    public void loadLinks(String after) {

    }
}
