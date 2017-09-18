package com.migafgarcia.redditimagedownloader.services;

import com.migafgarcia.redditimagedownloader.model.Thing;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RedditService {

    @GET("r/{subs}/hot.json")
    Call<Thing> getList(@Path("subs") String subs);

    @GET("r/{sub}/about.json")
    Call<Thing> getSubredditInfo(@Path("sub") String subreddit);

    @GET("r/{subs}/hot.json")
    Call<Thing> getListAfter(@Path("subs") String subs, @Query("after") String after);


}
