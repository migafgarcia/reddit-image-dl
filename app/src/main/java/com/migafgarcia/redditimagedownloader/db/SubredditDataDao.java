package com.migafgarcia.redditimagedownloader.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.Collection;
import java.util.List;

/**
 * mgarcia
 * 16-07-2018
 * DCC/FCUP
 */
@android.arch.persistence.room.Dao
public interface SubredditDataDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(SubredditData subredditData);

    @Delete
    void delete(SubredditData subredditData);

    @Query("SELECT * FROM subredditdata")
    LiveData<List<SubredditData>> getLiveSubreddits();


}
