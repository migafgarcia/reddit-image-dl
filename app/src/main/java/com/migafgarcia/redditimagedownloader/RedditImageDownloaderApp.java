package com.migafgarcia.redditimagedownloader;


import android.app.Application;
import android.content.Context;

public class RedditImageDownloaderApp extends Application {
    public static RedditImageDownloaderApp get(Context context) {
        return (RedditImageDownloaderApp) context.getApplicationContext();
    }
}
