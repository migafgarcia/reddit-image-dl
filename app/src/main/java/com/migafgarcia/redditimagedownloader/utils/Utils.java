package com.migafgarcia.redditimagedownloader.utils;


import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.migafgarcia.redditimagedownloader.reddit_json.Post;
import com.migafgarcia.redditimagedownloader.reddit_json.RedditResponse;

import java.util.Iterator;
import java.util.List;

public class Utils {

    public static void processPosts(Context context, RedditResponse response) {

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);

        List<Post> posts = response.getData().getPosts();

        Iterator<Post> itr = posts.iterator();

        while (itr.hasNext()) {
            Post curr = itr.next();
            if (!prefs.getBoolean("nsfw_switch", false) && curr.getData().getOver18())
                itr.remove();
            else if (curr.getData().getPostHint() == null || !curr.getData().getPostHint().equals("image"))
                itr.remove();
        }
    }
}
