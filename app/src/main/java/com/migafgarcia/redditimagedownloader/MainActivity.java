package com.migafgarcia.redditimagedownloader;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.migafgarcia.redditimagedownloader.adapters.ListAdapter;
import com.migafgarcia.redditimagedownloader.presenters.MainPresenter;
import com.migafgarcia.redditimagedownloader.presenters.MainScreen;
import com.migafgarcia.redditimagedownloader.reddit_json.Post;
import com.migafgarcia.redditimagedownloader.reddit_json.RedditResponse;
import com.migafgarcia.redditimagedownloader.services.RedditApi;


public class MainActivity extends AppCompatActivity implements MainScreen {

    public static final String TAG = MainActivity.class.getName();

    private MainPresenter mMainPresenter;

    private Toolbar mToolbar;
    private RecyclerView mRecyclerView;
    private FloatingActionButton mFloatingActionButton;
    private SwipeRefreshLayout mSwipeRefreshLayout;

    private RecyclerView.LayoutManager mLayoutManager;
    private ListAdapter mListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMainPresenter = new MainPresenter(this, new RedditApi());

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mRecyclerView = (RecyclerView) findViewById(R.id.main_recyclerview);
        mFloatingActionButton = (FloatingActionButton) findViewById(R.id.list_fab);
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.list_swiperefreshlayout);

        setSupportActionBar(mToolbar);

        initRecyclerView();

        mFloatingActionButton.bringToFront();
        mFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scrollToStart();
            }
        });

        mSwipeRefreshLayout.setOnRefreshListener(
                new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        mMainPresenter.getPosts();
                    }
                }
        );

        mMainPresenter.getPosts();
    }

    private void initRecyclerView() {
        mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        ListAdapter.ItemClickCallback itemClickCallback = new ListAdapter.ItemClickCallback() {
            @Override
            public void onItemClick(Post post) {
                launchPreview(post);
            }
        };

        ListAdapter.MorePostsCallback morePostsCallback = new ListAdapter.MorePostsCallback() {
            @Override
            public void onMorePosts(String after) {
                mMainPresenter.morePosts(after);
            }
        };

        mListAdapter = new ListAdapter(getApplicationContext(), itemClickCallback, morePostsCallback);
        mRecyclerView.setAdapter(mListAdapter);
    }

    @Override
    public void getPosts(RedditResponse response) {
        mListAdapter.getPosts(response);
    }

    @Override
    public void morePosts(RedditResponse response) {
        mListAdapter.morePosts(response);
    }

    @Override
    public void showToast(String error) {
        Toast.makeText(getApplicationContext(), error, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showLoading() {
        mSwipeRefreshLayout.setRefreshing(true);
    }

    @Override
    public void hideLoading() {
        mSwipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void showGetRetry() {
        Snackbar mySnackbar = Snackbar.make(findViewById(R.id.main_coordinator_layout),
                "Error getting posts", Snackbar.LENGTH_INDEFINITE);
        mySnackbar.setAction("Retry", new RetryGetListener());
        mySnackbar.show();
    }

    @Override
    public void showMoreRetry(String after) {
        Snackbar mySnackbar = Snackbar.make(findViewById(R.id.main_coordinator_layout),
                "Error getting posts", Snackbar.LENGTH_INDEFINITE);
        mySnackbar.setAction("Retry", new RetryMoreListener(after));
        mySnackbar.show();

    }

    @Override
    public void launchPreview(Post post) {
        Intent i = new Intent(getApplicationContext(), PreviewActivity.class);
        i.putExtra("url", post.getData().getUrl());
        ActivityOptionsCompat options = ActivityOptionsCompat.
                makeSceneTransitionAnimation(this, findViewById(R.id.preview), "preview");
        startActivity(i, options.toBundle());
    }

    @Override
    public void launchSettings() {
        startActivity(new Intent(getApplicationContext(), SettingsActivity.class));
    }

    @Override
    public void launchManageSubreddits() {
        startActivity(new Intent(getApplicationContext(), ManageSubredditsActivity.class));
    }

    @Override
    public void scrollToStart() {
        mRecyclerView.smoothScrollToPosition(0);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                launchSettings();
                return true;
            case R.id.action_manage_subreddits:
                launchManageSubreddits();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_appbar_buttons, menu);
        return true;
    }

    @Override
    public Context getContext() {
        return getApplicationContext();
    }

    // TODO: 23-08-2017 use snackbar with retry action
    private class RetryGetListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            mMainPresenter.getPosts();
        }
    }

    // TODO: 23-08-2017 use snackbar with retry action
    private class RetryMoreListener implements View.OnClickListener {

        private String after;

        RetryMoreListener(String after) {
            this.after = after;
        }

        @Override
        public void onClick(View v) {
            mMainPresenter.morePosts(after);
        }
    }
}
