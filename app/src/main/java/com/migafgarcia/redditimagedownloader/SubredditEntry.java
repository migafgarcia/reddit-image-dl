package com.migafgarcia.redditimagedownloader;


public class SubredditEntry {
    private int mId;
    private String mSubreddit;

    public SubredditEntry(int mId, String mSubreddit) {
        this.mId = mId;
        this.mSubreddit = mSubreddit;
    }

    public int getmId() {
        return mId;
    }

    public String getmSubreddit() {
        return mSubreddit;
    }
}
