package com.migafgarcia.redditimagedownloader.presenters;


import com.migafgarcia.redditimagedownloader.reddit_json.Post;
import com.migafgarcia.redditimagedownloader.reddit_json.RedditResponse;

public interface MainScreen extends Screen {

    void getPosts(RedditResponse response);
    void morePosts(RedditResponse response);
    void showToast(String error); // TODO: 23-08-2017 change to use a string ID instead
    void showLoading();
    void hideLoading();
    void showGetRetry();
    void showMoreRetry(String after);
    void scrollToStart();
    void launchPreview(Post post);
    void launchSettings();
    void launchManageSubreddits();

}
