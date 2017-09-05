package com.migafgarcia.redditimagedownloader;

import android.app.Application;

import com.tonyodev.fetch.Fetch;

public class RedditImageDownloaderApp extends Application {

    private Fetch fetch;

    @Override
    public void onCreate() {
        super.onCreate();

        fetch = Fetch.newInstance(this);
    }

    public Fetch getFetch() {
        return fetch;
    }
}
