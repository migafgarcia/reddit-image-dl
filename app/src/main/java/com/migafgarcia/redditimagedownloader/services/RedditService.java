package com.migafgarcia.redditimagedownloader.services;

import com.migafgarcia.redditimagedownloader.data.ListItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RedditService {

    @GET("r/{subs}/hot.json")
    Call<ListItem> getList(@Path("subs") String subs);



}
