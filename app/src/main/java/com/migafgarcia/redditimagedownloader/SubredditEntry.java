package com.migafgarcia.redditimagedownloader;


public class SubredditEntry {
    private int mId;
    private String mSubreddit;
    private String imageUrl;

    public SubredditEntry(int mId, String mSubreddit, String imageUrl) {
        this.mId = mId;
        this.mSubreddit = mSubreddit;
        this.imageUrl = imageUrl;

    }

    public String getImageUrl() {
        return imageUrl;
    }

    public int getmId() {
        return mId;
    }

    public String getmSubreddit() {
        return mSubreddit;
    }
}
