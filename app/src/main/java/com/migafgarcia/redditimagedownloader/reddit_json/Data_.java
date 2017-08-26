
package com.migafgarcia.redditimagedownloader.reddit_json;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data_ implements Parcelable {

    public static final String TAG = Data_.class.getName();

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.thumbnailWidth);
        dest.writeString(this.subreddit);
        dest.writeString(this.id);
        dest.writeString(this.title);
        dest.writeString(this.score);
        dest.writeValue(this.over18);
        dest.writeString(this.thumbnail);
        dest.writeString(this.subredditId);
        dest.writeString(this.postHint);
        dest.writeValue(this.thumbnailHeight);
        dest.writeString(this.permalink);
        dest.writeValue(this.locked);
        dest.writeValue(this.created);
        dest.writeString(this.url);
        dest.writeString(this.author);
        dest.writeValue(this.createdUtc);
        dest.writeParcelable(this.preview, flags);
    }

    public Data_() {
    }

    protected Data_(Parcel in) {
        this.thumbnailWidth = (Integer) in.readValue(Integer.class.getClassLoader());
        this.subreddit = in.readString();
        this.id = in.readString();
        this.title = in.readString();
        this.score = in.readString();
        this.over18 = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.thumbnail = in.readString();
        this.subredditId = in.readString();
        this.postHint = in.readString();
        this.thumbnailHeight = (Integer) in.readValue(Integer.class.getClassLoader());
        this.permalink = in.readString();
        this.locked = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.created = (Float) in.readValue(Float.class.getClassLoader());
        this.url = in.readString();
        this.author = in.readString();
        this.createdUtc = (Float) in.readValue(Float.class.getClassLoader());
        this.preview = in.readParcelable(Preview.class.getClassLoader());
    }

    public static final Parcelable.Creator<Data_> CREATOR = new Parcelable.Creator<Data_>() {
        @Override
        public Data_ createFromParcel(Parcel source) {
            return new Data_(source);
        }

        @Override
        public Data_[] newArray(int size) {
            return new Data_[size];
        }
    };
}