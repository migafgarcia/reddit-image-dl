package com.migafgarcia.redditimagedownloader.reddit_json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data {

    public static final String TAG = Data.class.getName();

    @SerializedName("modhash")
    @Expose
    private String modhash;

    @SerializedName("children")
    @Expose
    private List<Post> posts = null;

    @SerializedName("after")
    @Expose
    private String after;

    @SerializedName("before")
    @Expose
    private Object before;

    public String getModhash() {
        return modhash;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public String getAfter() {
        return after;
    }

    public Object getBefore() {
        return before;
    }
}