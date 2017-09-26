package com.migafgarcia.redditimagedownloader.services;

import com.google.gson.GsonBuilder;
import com.migafgarcia.redditimagedownloader.model.Thing;
import com.migafgarcia.redditimagedownloader.model.ThingDeserializer;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RedditApi {

    private final RedditService service = new Retrofit.Builder()
            .baseUrl("https://reddit.com/")
            .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().registerTypeAdapter(Thing.class, new ThingDeserializer()).create()))
            .build().create(RedditService.class);

    public RedditService getService() {
        return service;
    }

}
