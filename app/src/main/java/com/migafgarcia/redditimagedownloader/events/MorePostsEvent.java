package com.migafgarcia.redditimagedownloader.events;

import com.migafgarcia.redditimagedownloader.reddit_json.RedditResponse;

public class MorePostsEvent {

    private RedditResponse response;

    public MorePostsEvent(RedditResponse response) {
        this.response = response;
    }

    public RedditResponse getResponse() {
        return response;
    }
}
