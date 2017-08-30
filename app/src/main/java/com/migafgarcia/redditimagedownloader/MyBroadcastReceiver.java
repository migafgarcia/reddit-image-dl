package com.migafgarcia.redditimagedownloader;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.migafgarcia.redditimagedownloader.reddit_json.Post;

/**
 * Created by mgarcia on 29-08-2017.
 */

public abstract class MyBroadcastReceiver extends BroadcastReceiver {

    private Post mPost;

    public MyBroadcastReceiver(Post mPost) {
        this.mPost = mPost;
    }
}
