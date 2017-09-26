package com.migafgarcia.redditimagedownloader.presenters;


import com.migafgarcia.redditimagedownloader.model.Link;
import com.migafgarcia.redditimagedownloader.model.Thing;

public interface MainScreen extends Screen {

    void getPosts(Thing response);

    void morePosts(Thing response);

    void showToast(String error); // TODO: 23-08-2017 change to use a string ID instead

    void showLoading();

    void hideLoading();

    void showGetRetry();

    void showMoreRetry(String after);

    void scrollToStart();

    void launchPreview(Link post);

    void launchSettings();

    void launchManageSubreddits();

    void clearDownloads();

}
