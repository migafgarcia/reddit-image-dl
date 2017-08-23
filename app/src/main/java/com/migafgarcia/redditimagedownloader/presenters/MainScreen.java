package com.migafgarcia.redditimagedownloader.presenters;


import com.migafgarcia.redditimagedownloader.reddit_json.Post;

public interface MainScreen {
    void getPosts();
    void morePosts(String after);

    void scrollToStart();
    void launchPreview(Post post);
    void launchSettings();
    void launchManageSubreddits();


}
