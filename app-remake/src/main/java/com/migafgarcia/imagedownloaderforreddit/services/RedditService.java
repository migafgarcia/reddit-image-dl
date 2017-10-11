package com.migafgarcia.imagedownloaderforreddit.services;


import com.migafgarcia.imagedownloaderforreddit.model.Thing;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RedditService {

    @GET("r/{subs}/hot.json?raw_json=1")
    Call<Thing> getListing(@Path("subs") String subs);

    @GET("r/{subs}/hot.json?raw_json=1")
    Call<Thing> getListing(@Path("subs") String subs, @Query("after") String after);

    @GET("r/{sub}/about.json?raw_json=1")
    Call<Thing> getSubredditInfo(@Path("sub") String subreddit);

    @GET("subreddits/search.json?raw_json=1&sort=relevance")
    Call<Thing> searchSubreddit(@Query("q") String query);

}
