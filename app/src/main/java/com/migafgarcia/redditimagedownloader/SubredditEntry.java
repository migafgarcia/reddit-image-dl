package com.migafgarcia.redditimagedownloader;


public class SubredditEntry {
    private final int mId;
    private final String mSubreddit;
    private final String imageUrl;

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
