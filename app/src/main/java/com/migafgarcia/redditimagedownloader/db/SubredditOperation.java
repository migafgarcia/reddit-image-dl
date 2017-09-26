package com.migafgarcia.redditimagedownloader.db;


import android.content.Context;

import com.migafgarcia.redditimagedownloader.model.Subreddit;

import java.sql.SQLException;
import java.util.List;

public class SubredditOperation implements Operation {

    private DatabaseHelper databaseHelper;

    public SubredditOperation(Context context) {
        DatabaseManager.init(context);
        databaseHelper = DatabaseManager.getInstance().getHelper();
    }


    @Override
    public int create(Object item) {
        int index = -1;

        Subreddit object = (Subreddit) item;
        try {
            index = databaseHelper.getSubredditsDao().create(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return index;
    }

    @Override
    public int update(Object item) {

        int index = -1;

        Subreddit object = (Subreddit) item;

        try {
            databaseHelper.getSubredditsDao().update(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return index;
    }

    @Override
    public int delete(Object item) {
        int index = -1;

        Subreddit object = (Subreddit) item;

        try {
            databaseHelper.getSubredditsDao().delete(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return index;

    }

    @Override
    public Object findById(String id) {
        Subreddit subreddit = null;
        try {
            subreddit = databaseHelper.getSubredditsDao().queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return subreddit;
    }

    @Override
    public List<?> findAll() {
        List<Subreddit> items = null;

        try {
            items = databaseHelper.getSubredditsDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;
    }
}
