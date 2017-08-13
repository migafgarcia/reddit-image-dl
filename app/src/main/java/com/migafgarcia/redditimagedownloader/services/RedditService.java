package com.migafgarcia.redditimagedownloader.services;

import com.migafgarcia.redditimagedownloader.data.RedditResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RedditService {

    @GET("r/{subs}/hot.json")
    Call<RedditResponse> getList(@Path("subs") String subs);



}
