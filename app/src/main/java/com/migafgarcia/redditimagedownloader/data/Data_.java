
package com.migafgarcia.redditimagedownloader.data;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data_ {

    @SerializedName("thumbnail_width")
    @Expose
    public Integer thumbnailWidth;

    @SerializedName("subreddit")
    @Expose
    public String subreddit;

    @SerializedName("id")
    @Expose
    public String id;

    @SerializedName("title")
    @Expose
    public String title;

    @SerializedName("score")
    @Expose
    public String score;

    @SerializedName("over_18")
    @Expose
    public Boolean over18;

    @SerializedName("thumbnail")
    @Expose
    public String thumbnail;

    @SerializedName("subreddit_id")
    @Expose
    public String subredditId;

    @SerializedName("post_hint")
    @Expose
    public String postHint;

    @SerializedName("thumbnail_height")
    @Expose
    public Integer thumbnailHeight;

    @SerializedName("permalink")
    @Expose
    public String permalink;

    @SerializedName("locked")
    @Expose
    public Boolean locked;

    @SerializedName("created")
    @Expose
    public Float created;

    @SerializedName("url")
    @Expose
    public String url;

    @SerializedName("author")
    @Expose
    public String author;

    @SerializedName("created_utc")
    @Expose
    public Float createdUtc;
}