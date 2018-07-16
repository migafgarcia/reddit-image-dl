package com.migafgarcia.redditimagedownloader.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * mgarcia
 * 16-07-2018
 * DCC/FCUP
 */
@Database(entities = {SubredditData.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract SubredditDataDao getSubredditDataDao();
}
