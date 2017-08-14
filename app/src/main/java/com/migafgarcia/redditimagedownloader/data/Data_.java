
package com.migafgarcia.redditimagedownloader.data;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data_ {

    @SerializedName("thumbnail_width")
    @Expose
    private Integer thumbnailWidth;

    @SerializedName("subreddit")
    @Expose
    private String subreddit;

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("score")
    @Expose
    private String score;

    @SerializedName("over_18")
    @Expose
    private Boolean over18;

    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;

    @SerializedName("subreddit_id")
    @Expose
    private String subredditId;

    @SerializedName("post_hint")
    @Expose
    private String postHint;

    @SerializedName("thumbnail_height")
    @Expose
    private Integer thumbnailHeight;

    @SerializedName("permalink")
    @Expose
    private String permalink;

    @SerializedName("locked")
    @Expose
    private Boolean locked;

    @SerializedName("created")
    @Expose
    private Float created;

    @SerializedName("url")
    @Expose
    private String url;

    @SerializedName("author")
    @Expose
    private String author;

    @SerializedName("created_utc")
    @Expose
    private Float createdUtc;

    @SerializedName("preview")
    @Expose
    private Preview preview;

    public Integer getThumbnailWidth() {
        return thumbnailWidth;
    }

    public String getSubreddit() {
        return subreddit;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getScore() {
        return score;
    }

    public Boolean getOver18() {
        return over18;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public String getSubredditId() {
        return subredditId;
    }

    public String getPostHint() {
        return postHint;
    }

    public Integer getThumbnailHeight() {
        return thumbnailHeight;
    }

    public String getPermalink() {
        return permalink;
    }

    public Boolean getLocked() {
        return locked;
    }

    public Float getCreated() {
        return created;
    }

    public String getUrl() {
        return url;
    }

    public String getAuthor() {
        return author;
    }

    public Float getCreatedUtc() {
        return createdUtc;
    }

    public Preview getPreview() {
        return preview;
    }
}