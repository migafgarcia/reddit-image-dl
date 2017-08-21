package com.migafgarcia.redditimagedownloader.events;

import com.migafgarcia.redditimagedownloader.reddit_json.RedditResponse;

public class GetPostsEvent {

    private RedditResponse response;

    public GetPostsEvent(RedditResponse response) {
        this.response = response;
    }

    public RedditResponse getResponse() {
        return response;
    }
}
