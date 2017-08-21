package com.migafgarcia.redditimagedownloader.events;


import com.migafgarcia.redditimagedownloader.reddit_json.Post;

public class LaunchPreviewEvent {

    private Post post;

    public LaunchPreviewEvent(Post post) {
        this.post = post;
    }

    public Post getPost() {
        return post;
    }
}
