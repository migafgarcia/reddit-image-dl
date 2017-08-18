package com.migafgarcia.redditimagedownloader.services;

import com.migafgarcia.redditimagedownloader.reddit_json.RedditResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RedditService {

    @GET("r/{subs}/hot.json")
    Call<RedditResponse> getList(@Path("subs") String subs);

    @GET("r/{subs}/hot.json")
    Call<RedditResponse> getListAfter(@Path("subs") String subs, @Query("after") String after);

}
