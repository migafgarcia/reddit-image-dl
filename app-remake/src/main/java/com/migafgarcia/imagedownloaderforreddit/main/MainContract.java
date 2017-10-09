package com.migafgarcia.imagedownloaderforreddit.main;

import com.migafgarcia.imagedownloaderforreddit.BasePresenter;
import com.migafgarcia.imagedownloaderforreddit.BaseView;
import com.migafgarcia.imagedownloaderforreddit.model.Link;


public interface MainContract {

    interface View extends BaseView<Presenter> {

        void launchPreview(Link link);

        void launchSettings();

        void launchSubredditManager();

        void scrollToTop(boolean smooth);

    }

    interface Presenter extends BasePresenter {



    }

}
