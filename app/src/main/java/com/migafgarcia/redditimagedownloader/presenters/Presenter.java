package com.migafgarcia.redditimagedownloader.presenters;


public interface Presenter<V> {
    void attachView(V view);
    void detachView();
}
