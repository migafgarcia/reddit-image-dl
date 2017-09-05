package com.migafgarcia.redditimagedownloader.services;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RedditApi {

    private final RedditService service = new Retrofit.Builder()
            .baseUrl("https://reddit.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(RedditService.class);

    public RedditService getService() {
        return service;
    }

}
