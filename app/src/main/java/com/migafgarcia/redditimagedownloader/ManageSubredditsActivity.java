package com.migafgarcia.redditimagedownloader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        ArrayList<SubredditEntry> subreddits = new ArrayList<>();
        for(int i = 0; i < 100; i++)
            subreddits.add(new SubredditEntry(i, "asd" + i + "dfg"));

        mAdapter = new SubredditListAdapter(getApplicationContext(), subreddits);
        mRecyclerView.setAdapter(mAdapter);
    }
}
