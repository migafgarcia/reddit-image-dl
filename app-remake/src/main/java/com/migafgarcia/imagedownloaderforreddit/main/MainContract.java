package com.migafgarcia.imagedownloaderforreddit.main;

import com.migafgarcia.imagedownloaderforreddit.BasePresenter;
import com.migafgarcia.imagedownloaderforreddit.BaseView;
import com.migafgarcia.imagedownloaderforreddit.model.Link;

import java.util.List;


public interface MainContract {

    /**
     * The view is a passive interface that displays data (the model) and routes user commands
     * (events) to the presenter to act upon that data.
     */
    interface View extends BaseView<Presenter> {

        void launchPreview(Link link);

        void launchSettings();

        void launchSubredditManager();

        void scrollToTop(boolean smooth);

        void setLoading(boolean loading);

        void addPosts(List<Link> links);

        void showRetry();

        void showRetry(String after);

    }

    /**
     * The presenter acts upon the model and the view. It retrieves data from repositories
     * (the model), and formats it for display in the view.
     */
    interface Presenter extends BasePresenter {

        void loadLinks();

        void loadLinks(String after);

    }

}
