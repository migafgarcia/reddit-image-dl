package com.migafgarcia.redditimagedownloader.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class SubredditsDbHelper extends SQLiteOpenHelper {

    private String[] defaultSubreddits = {"EarthPorn", "ExposurePorn", "ImaginaryLandscapes", "ImaginaryTechnology", "LightGraffiti", "SkyPorn", "futureporn", "lightpainting", "wallpaper", "wallpapers", "cyberpunk", "PsychedelicWallpapers", "ultrahdwallpapers"};

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + SubredditEntry.TABLE_NAME + " (" +
                    SubredditEntry._ID + " INTEGER PRIMARY KEY," +
                    SubredditEntry.COLUMN_NAME_NAME + " TEXT," +
                    SubredditEntry.COLUMN_NAME_URL + " TEXT," +
                    SubredditEntry.COLUMN_NAME_ACTIVATED + " INTEGER)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + SubredditEntry.TABLE_NAME;

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Subreddits.db";

    public SubredditsDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);
        ContentValues current = new ContentValues();
        for(String s : defaultSubreddits) {
            current.put(SubredditEntry.COLUMN_NAME_NAME, s);
            current.put(SubredditEntry.COLUMN_NAME_URL, "https://reddit.com/r/" + s);
            current.put(SubredditEntry.COLUMN_NAME_ACTIVATED, 1);
            sqLiteDatabase.insert(SubredditEntry.TABLE_NAME, null, current);
            current.clear();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(SQL_DELETE_ENTRIES);
        onCreate(sqLiteDatabase);
    }

    @Override
    public void onDowngrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        onUpgrade(sqLiteDatabase, oldVersion, newVersion);
    }
}
