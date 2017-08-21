package com.migafgarcia.redditimagedownloader.presenters;


import com.migafgarcia.redditimagedownloader.services.RedditApi;
import com.migafgarcia.redditimagedownloader.services.RedditServiceCallback;

public class MainPresenter {

    private RedditApi redditApi;

    public MainPresenter(RedditApi redditApi) {
        this.redditApi = redditApi;
    }

    public void getPosts() {
        // TODO: 21-08-2017 fetch subreddits from sqlite
        redditApi.getService().getList("EarthPorn").enqueue(new RedditServiceCallback());
    }

    public void morePosts() {
        // TODO: 21-08-2017  
    }
}
