package com.migafgarcia.redditimagedownloader;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.migafgarcia.redditimagedownloader.adapters.ListAdapter;
import com.migafgarcia.redditimagedownloader.db.AppDatabase;
import com.migafgarcia.redditimagedownloader.db.SubredditData;
import com.migafgarcia.redditimagedownloader.db.SubredditDataDao;
import com.migafgarcia.redditimagedownloader.model.Link;
import com.migafgarcia.redditimagedownloader.model.Thing;
import com.migafgarcia.redditimagedownloader.presenters.MainPresenter;
import com.migafgarcia.redditimagedownloader.presenters.MainScreen;
import com.migafgarcia.redditimagedownloader.services.RedditApi;
import com.tonyodev.fetch.Fetch;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity implements MainScreen {

    private static final String TAG = MainActivity.class.getName();

    @BindView(R.id.rv_main)
    RecyclerView mRecyclerView;
    @BindView(R.id.srl_main)
    SwipeRefreshLayout mSwipeRefreshLayout;
    @BindView(R.id.fab_main)
    FloatingActionButton mFloatingActionButton;
    @BindView(R.id.tb_main)
    Toolbar mToolbar;

    private MainPresenter mMainPresenter;

    private ListAdapter mListAdapter;

    private AppDatabase appDatabase;

    private static final int OPEN_SETTINGS_ACTIVITY = 1;
    private static final int OPEN_MANAGE_SUBREDDITS_ACTIVITY = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        appDatabase = Room
                .databaseBuilder(getApplicationContext(), AppDatabase.class, "reddit-image-dl")
                .allowMainThreadQueries()
                .build();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        if (!prefs.getBoolean("firstTime", false)) {

            new Thread(() -> {
                for (String subreddit : SubredditDataDao.DEFAULT_SUBREDDITS)
                    appDatabase.getSubredditDataDao().insert(new SubredditData(subreddit));
            }).start();

            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean("firstTime", true);
            editor.apply();
        }


        mMainPresenter = new MainPresenter(this, new RedditApi(), appDatabase);

        setSupportActionBar(mToolbar);

        ActionBar ab = getSupportActionBar();

        if(ab!= null) {
            ab.setIcon(R.mipmap.ic_launcher);
            ab.setDisplayShowTitleEnabled(false);
        }

        initRecyclerView();

        mFloatingActionButton.bringToFront();

        mSwipeRefreshLayout.setOnRefreshListener(() -> mMainPresenter.getPosts());

        mMainPresenter.getPosts();

        deleteDownloads();



    }

    private void initRecyclerView() {
        if (mRecyclerView == null)
            Log.e(TAG, "RecyclerView is null");
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        ListAdapter.ItemClickCallback itemClickCallback = this::launchPreview;

        ListAdapter.MorePostsCallback morePostsCallback = after -> mMainPresenter.morePosts(after);

        mListAdapter = new ListAdapter(getApplicationContext(), itemClickCallback, morePostsCallback);
        mRecyclerView.setAdapter(mListAdapter);
    }

    @Override
    public void getPosts(Thing response) {
        mListAdapter.clear();
        mListAdapter.updatePosts(response);
        Log.d(TAG, "Get Posts");
    }

    @Override
    public void morePosts(Thing response) {
        mListAdapter.updatePosts(response);
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
        Snackbar mySnackbar = Snackbar.make(findViewById(R.id.cl_main),
                "Error getting posts", Snackbar.LENGTH_INDEFINITE);
        mySnackbar.setAction("Retry", new RetryGetListener());
        mySnackbar.show();
    }

    @Override
    public void showMoreRetry(String after) {
        Snackbar mySnackbar = Snackbar.make(findViewById(R.id.cl_main),
                "Error getting posts", Snackbar.LENGTH_INDEFINITE);
        mySnackbar.setAction("Retry", new RetryMoreListener(after));
        mySnackbar.show();

    }

    @Override
    public void launchPreview(Link post) {
        Bundle b = new Bundle();
        b.putParcelable("Post", post);
        Intent intent = new Intent(MainActivity.this, PreviewActivity.class);
        intent.putExtra("bundle", b);
        startActivity(intent);
    }


    @Override
    public void launchSettings() {
        startActivityForResult(new Intent(getApplicationContext(), SettingsActivity.class), OPEN_SETTINGS_ACTIVITY);
    }

    @Override
    public void launchManageSubreddits() {
        startActivityForResult(new Intent(getApplicationContext(), SubredditActivity.class), OPEN_MANAGE_SUBREDDITS_ACTIVITY);
    }

    @Override
    public void clearDownloads() {
        DialogInterface.OnClickListener dialogClickListener = (dialog, which) -> {
            switch (which) {
                case DialogInterface.BUTTON_POSITIVE:
                    deleteDownloads();
                    break;
                case DialogInterface.BUTTON_NEGATIVE:
                    break;
            }
        };

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Delete downloaded pictures?").setPositiveButton("Yes", dialogClickListener)
                .setNegativeButton("No", dialogClickListener).show();


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == OPEN_SETTINGS_ACTIVITY) {
            mListAdapter.reprocessPosts();
        }
        else if(requestCode == OPEN_MANAGE_SUBREDDITS_ACTIVITY) {
            mListAdapter.reprocessPosts();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mListAdapter.notifyDataSetChanged();
    }

    private void deleteDownloads() {
        Fetch fetch = Fetch.newInstance(this);
        fetch.removeRequests();
        fetch.release();
        // Toast.makeText(this, "Downloads deleted", Toast.LENGTH_SHORT).show();
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
            case R.id.action_clear_downloads:
                clearDownloads();
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

    @OnClick(R.id.fab_main)
    public void onFloatingActionButtonClicked() {
        scrollToStart();
    }

    private class RetryGetListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            mMainPresenter.getPosts();
        }
    }

    private class RetryMoreListener implements View.OnClickListener {

        private final String after;

        RetryMoreListener(String after) {
            this.after = after;
        }

        @Override
        public void onClick(View v) {
            mMainPresenter.morePosts(after);
        }
    }
}
