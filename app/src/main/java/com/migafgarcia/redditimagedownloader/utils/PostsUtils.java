package com.migafgarcia.redditimagedownloader.utils;


import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.migafgarcia.redditimagedownloader.model.Link;
import com.migafgarcia.redditimagedownloader.model.Listing;
import com.migafgarcia.redditimagedownloader.model.Thing;

import java.util.Iterator;
import java.util.List;

public class PostsUtils {

    public static void processPosts(Context context, Listing response) {

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);

        List<Thing> posts = response.getChildren();

        Iterator<Thing> itr = posts.iterator();

        while (itr.hasNext()) {
            Link curr = (Link) itr.next().getData();
            if (!prefs.getBoolean("nsfw_switch", false) && curr.getOver18())
                itr.remove();
            else if (curr.getPostHint() == null || !curr.getPostHint().equals("image"))
                itr.remove();
        }
    }
}
