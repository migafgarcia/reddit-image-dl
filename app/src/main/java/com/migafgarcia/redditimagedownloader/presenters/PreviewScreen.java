package com.migafgarcia.redditimagedownloader.presenters;


public interface PreviewScreen extends Screen {
    void downloadImage();

    void setAs();

    void goToThread();

    void goToSubreddit();
}
