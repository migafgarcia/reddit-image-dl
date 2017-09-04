package com.migafgarcia.redditimagedownloader.db;


public class DownloadEntry {

    public static final String TABLE_NAME = "downloads";
    public static final String COLUMN_NAME_POST_ID = "post_id";
    public static final String COLUMN_NAME_LOCATION = "location";
    public static final String COLUMN_NAME_URL = "url";

    private DownloadEntry() {
    }
}
