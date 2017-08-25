package com.migafgarcia.redditimagedownloader;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.migafgarcia.redditimagedownloader.adapters.SubredditListAdapter;
import com.migafgarcia.redditimagedownloader.db.SubredditsContract;
import com.migafgarcia.redditimagedownloader.db.SubredditsDbHelper;

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


        SubredditsDbHelper helper = new SubredditsDbHelper(getApplicationContext());
        SQLiteDatabase db = helper.getReadableDatabase();

        String[] projection = {
                SubredditsContract.SubredditEntry._ID,
                SubredditsContract.SubredditEntry.COLUMN_NAME_NAME,
                SubredditsContract.SubredditEntry.COLUMN_NAME_URL,
                SubredditsContract.SubredditEntry.COLUMN_NAME_ACTIVATED
        };



        Cursor cursor = db.query(
                SubredditsContract.SubredditEntry.TABLE_NAME,                     // The table to query
                projection,                               // The columns to return
                null,                                // The columns for the WHERE clause
                null,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                null                                 // The sort order
        );

        while(cursor.moveToNext()) {
            long itemId = cursor.getLong(
                    cursor.getColumnIndexOrThrow(SubredditsContract.SubredditEntry._ID));
            String name = cursor.getString(
                    cursor.getColumnIndexOrThrow(SubredditsContract.SubredditEntry.COLUMN_NAME_NAME));
            String url = cursor.getString(
                    cursor.getColumnIndexOrThrow(SubredditsContract.SubredditEntry.COLUMN_NAME_URL));
            int activated = cursor.getInt(
                    cursor.getColumnIndexOrThrow(SubredditsContract.SubredditEntry.COLUMN_NAME_ACTIVATED));

            subreddits.add(new SubredditEntry((int) itemId, name, "https://pbs.twimg.com/profile_images/737359467742912512/t_pzvyZZ_400x400.jpg"));
        }
        cursor.close();


        mAdapter = new SubredditListAdapter(getApplicationContext(), subreddits);
        mRecyclerView.setAdapter(mAdapter);

    }
}
