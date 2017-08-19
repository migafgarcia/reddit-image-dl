package com.migafgarcia.redditimagedownloader.reddit_json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Post {

    public static final String TAG = Post.class.getName();

    @SerializedName("kind")
    @Expose
    private String kind;

    @SerializedName("data")
    @Expose
    private Data_ data;

    public String getKind() {
        return kind;
    }

    public Data_ getData() {
        return data;
    }
}