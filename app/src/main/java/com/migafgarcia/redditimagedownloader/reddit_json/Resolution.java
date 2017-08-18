package com.migafgarcia.redditimagedownloader.reddit_json;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Resolution {

    @SerializedName("url")
    @Expose
    private String url;

    @SerializedName("width")
    @Expose
    private Integer width;

    @SerializedName("height")
    @Expose
    private Integer height;

    public String getUrl() {
        return url;
    }

    public Integer getWidth() {
        return width;
    }

    public Integer getHeight() {
        return height;
    }
}