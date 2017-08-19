package com.migafgarcia.redditimagedownloader.reddit_json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RedditResponse {

    public static final String TAG = RedditResponse.class.getName();

    @SerializedName("kind")
    @Expose
    private String kind;

    @SerializedName("data")
    @Expose
    private Data data;

    public String getKind() {
        return kind;
    }

    public Data getData() {
        return data;
    }
}