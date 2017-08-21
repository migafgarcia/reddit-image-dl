package com.migafgarcia.redditimagedownloader.utils;


import com.migafgarcia.redditimagedownloader.reddit_json.Post;
import com.migafgarcia.redditimagedownloader.reddit_json.RedditResponse;

import java.util.Iterator;
import java.util.List;

public class Utils {

    public static void processPosts(RedditResponse response) {

        List<Post> posts = response.getData().getPosts();

        Iterator<Post> itr = posts.iterator();

        while(itr.hasNext()) {
            Post curr = itr.next();

            if (curr.getData().getPostHint() == null || !curr.getData().getPostHint().equals("image"))
                itr.remove();
        }
    }
}
