package com.migafgarcia.redditimagedownloader.presenters;


import com.migafgarcia.redditimagedownloader.events.ErrorGettingPostsEvent;
import com.migafgarcia.redditimagedownloader.events.GetPostsEvent;
import com.migafgarcia.redditimagedownloader.events.LaunchPreviewEvent;
import com.migafgarcia.redditimagedownloader.events.MorePostsEvent;
import com.migafgarcia.redditimagedownloader.reddit_json.Post;
import com.migafgarcia.redditimagedownloader.reddit_json.RedditResponse;
import com.migafgarcia.redditimagedownloader.services.RedditApi;
import com.migafgarcia.redditimagedownloader.utils.Utils;

import org.greenrobot.eventbus.EventBus;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter implements MainScreen {

    private RedditApi redditApi;

    public MainPresenter(RedditApi redditApi) {
        this.redditApi = redditApi;
    }

    @Override
    public void getPosts() {
        // TODO: 21-08-2017 fetch subreddits from sqlite
        redditApi.getService().getList("EarthPorn").enqueue(new Callback<RedditResponse>() {
            @Override
            public void onResponse(Call<RedditResponse> call, Response<RedditResponse> response) {
                if(response.isSuccessful()) {
                    Utils.processPosts(response.body());
                    EventBus.getDefault().post(new GetPostsEvent(response.body()));
                }
                else
                    EventBus.getDefault().post(new ErrorGettingPostsEvent());
            }

            @Override
            public void onFailure(Call<RedditResponse> call, Throwable t) {
                EventBus.getDefault().post(new ErrorGettingPostsEvent());
            }
        });
    }

    @Override
    public void morePosts(String after) {
        redditApi.getService().getListAfter("EarthPorn", after).enqueue(new Callback<RedditResponse>() {
            @Override
            public void onResponse(Call<RedditResponse> call, Response<RedditResponse> response) {
                if(response.isSuccessful()) {
                    Utils.processPosts(response.body());
                    EventBus.getDefault().post(new MorePostsEvent(response.body()));
                }
                else
                    EventBus.getDefault().post(new ErrorGettingPostsEvent());
            }

            @Override
            public void onFailure(Call<RedditResponse> call, Throwable t) {
                EventBus.getDefault().post(new ErrorGettingPostsEvent());
            }
        });
    }

    @Override
    public void launchPreview(Post post) {
        EventBus.getDefault().post(new LaunchPreviewEvent(post));
    }

    @Override
    public void scrollToStart() {

    }
}
