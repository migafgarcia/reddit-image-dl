package com.migafgarcia.redditimagedownloader;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.migafgarcia.redditimagedownloader.db.DatabaseManager;
import com.migafgarcia.redditimagedownloader.db.SubredditOperation;
import com.migafgarcia.redditimagedownloader.model.Subreddit;
import com.migafgarcia.redditimagedownloader.model.Thing;
import com.migafgarcia.redditimagedownloader.services.RedditApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SubredditActivity extends AppCompatActivity {

    private static final String TAG = SubredditActivity.class.getName();
    private SubredditOperation operation;

    private Subreddit query;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subreddit);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        DatabaseManager.init(this);
        operation = new SubredditOperation(this);

        new RedditApi().getService().getSubredditInfo("pics").enqueue(new Callback<Thing>() {
            @Override
            public void onResponse(Call<Thing> call, Response<Thing> response) {
                Subreddit subreddit = (Subreddit) response.body().getData();
                operation.create(subreddit);
            }

            @Override
            public void onFailure(Call<Thing> call, Throwable t) {

            }
        });

        for(Subreddit s : (List<Subreddit>)(List<?>) operation.findAll()) {
            Log.d(TAG, s.toString());
        }

    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

}
