package com.migafgarcia.redditimagedownloader.db;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import java.util.List;

/**
 * mgarcia
 * 16-07-2018
 * DCC/FCUP
 */
public class SubredditsViewModel extends ViewModel {
    private LiveData<List<SubredditData>> subredditsLiveData;

    public LiveData<List<SubredditData>> getSubredditsLiveData(SubredditDataDao dao) {
        if(subredditsLiveData == null) {
            subredditsLiveData = dao.getSubreddits();
        }
        return subredditsLiveData;
    }
}
