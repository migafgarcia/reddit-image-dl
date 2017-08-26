package com.migafgarcia.redditimagedownloader.db;

import android.provider.BaseColumns;

public final class SubredditEntry implements BaseColumns {

    public static final String TABLE_NAME = "subreddits";
    public static final String COLUMN_NAME_NAME = "name";
    public static final String COLUMN_NAME_URL = "url";
    public static final String COLUMN_NAME_ACTIVATED = "activated";
    private SubredditEntry() {}

}
