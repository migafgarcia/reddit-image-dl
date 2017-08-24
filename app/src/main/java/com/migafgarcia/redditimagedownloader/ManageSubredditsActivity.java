package com.migafgarcia.redditimagedownloader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.migafgarcia.redditimagedownloader.adapters.SubredditListAdapter;

import java.util.ArrayList;

public class ManageSubredditsActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_subreddits);

        mRecyclerView = (RecyclerView) findViewById(R.id.ms_recyclerview);

        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new GridLayoutManager(this, 2);
        mRecyclerView.setLayoutManager(mLayoutManager);

        ArrayList<SubredditEntry> subreddits = new ArrayList<>();
        for(int i = 0; i < 100; i++)
            subreddits.add(new SubredditEntry(i, "/r/wallpaper", "https://pbs.twimg.com/profile_images/737359467742912512/t_pzvyZZ_400x400.jpg"));

        mAdapter = new SubredditListAdapter(getApplicationContext(), subreddits);
        mRecyclerView.setAdapter(mAdapter);
    }
}
