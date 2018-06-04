package com.mgarcia.imagebrowserforreddit;

import com.mgarcia.imagebrowserforreddit.model.Thing;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RedditApi {

    @GET("r/{subs}/hot.json?raw_json=1")
    Call<Thing> getList(@Path("subs") String subs);

    @GET("r/{sub}/about.json?raw_json=1")
    Call<Thing> getSubredditInfo(@Path("sub") String subreddit);

    @GET("r/{subs}/hot.json?raw_json=1")
    Call<Thing> getListAfter(@Path("subs") String subs, @Query("after") String after);

    @GET("subreddits/search.json?raw_json=1&sort=relevance")
    Call<Thing> searchSubreddit(@Query("q") String query);

}
