package com.migafgarcia.redditimagedownloader.presenters;

import com.migafgarcia.redditimagedownloader.reddit_json.RedditResponse;
import com.migafgarcia.redditimagedownloader.services.RedditApi;
import com.migafgarcia.redditimagedownloader.utils.Utils;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter implements Presenter<MainScreen> {

    private MainScreen mainScreen;
    private RedditApi redditApi;

    public MainPresenter(MainScreen mainScreen, RedditApi redditApi) {
        this.mainScreen = mainScreen;
        this.redditApi = redditApi;
    }

    public void getPosts() {

        mainScreen.showLoading();

        // TODO: 21-08-2017 fetch subreddits from sqlite
        redditApi.getService().getList("wallpaper").enqueue(new Callback<RedditResponse>() {
            @Override
            public void onResponse(Call<RedditResponse> call, Response<RedditResponse> response) {
                if(response.isSuccessful()) {
                    Utils.processPosts(response.body());
                    mainScreen.getPosts(response.body());
                }
                else
                    mainScreen.showGetRetry();

                mainScreen.hideLoading();
            }

            @Override
            public void onFailure(Call<RedditResponse> call, Throwable t) {
                mainScreen.showGetRetry();
                mainScreen.hideLoading();
            }
        });
    }

    public void morePosts(final String after) {
        mainScreen.showLoading();
        redditApi.getService().getListAfter("wallpaper", after).enqueue(new Callback<RedditResponse>() {
            @Override
            public void onResponse(Call<RedditResponse> call, Response<RedditResponse> response) {
                if(response.isSuccessful()) {
                    Utils.processPosts(response.body());
                    mainScreen.morePosts(response.body());
                }
                else
                    mainScreen.showMoreRetry(after);

                mainScreen.hideLoading();
            }

            @Override
            public void onFailure(Call<RedditResponse> call, Throwable t) {
                mainScreen.showMoreRetry(after);
                mainScreen.hideLoading();
            }
        });
    }

    @Override
    public void attachView(MainScreen mainScreen) {
        this.mainScreen = mainScreen;

    }

    @Override
    public void detachView() {
        this.mainScreen = null;
    }
}
