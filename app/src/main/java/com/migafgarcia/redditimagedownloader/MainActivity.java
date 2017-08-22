package com.migafgarcia.redditimagedownloader;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.Toast;

import com.migafgarcia.redditimagedownloader.adapters.ListAdapter;
import com.migafgarcia.redditimagedownloader.events.ErrorGettingPostsEvent;
import com.migafgarcia.redditimagedownloader.events.GetPostsEvent;
import com.migafgarcia.redditimagedownloader.events.LaunchPreviewEvent;
import com.migafgarcia.redditimagedownloader.events.MorePostsEvent;
import com.migafgarcia.redditimagedownloader.presenters.MainPresenter;
import com.migafgarcia.redditimagedownloader.presenters.MainScreen;
import com.migafgarcia.redditimagedownloader.reddit_json.Post;
import com.migafgarcia.redditimagedownloader.services.RedditApi;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity implements MainScreen {

    public static final String TAG = MainActivity.class.getName();

    private MainPresenter mainPresenter;

    private RecyclerView recyclerView;
    private Toolbar toolbar;

    private RecyclerView.LayoutManager mLayoutManager;
    private ListAdapter listAdapter;
    private FloatingActionButton floatingActionButton;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.main_recyclerview);
        floatingActionButton = (FloatingActionButton) findViewById(R.id.list_fab);
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.list_swiperefreshlayout);

        mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        listAdapter = new ListAdapter(getApplicationContext(), this);
        recyclerView.setAdapter(listAdapter);

        floatingActionButton.bringToFront();
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scrollToStart();
            }
        });

        mainPresenter = new MainPresenter(new RedditApi());

        swipeRefreshLayout.setOnRefreshListener(
                new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        getPosts();
                    }
                }
        );


        getPosts();
    }

    private void hideViews() {
        toolbar.animate().translationY(-toolbar.getHeight()).setInterpolator(new AccelerateInterpolator(2));
    }

    private void showViews() {
        toolbar.animate().translationY(0).setInterpolator(new DecelerateInterpolator(2));
    }

    private void initRecyclerView() {

    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void getPosts() {
        swipeRefreshLayout.setRefreshing(true);
        mainPresenter.getPosts();
    }

    @Override
    public void morePosts(String after) {
        swipeRefreshLayout.setRefreshing(true);
        mainPresenter.morePosts(after);
    }

    @Override
    public void launchPreview(Post post) {
        mainPresenter.launchPreview(post);
    }

    @Override
    public void scrollToStart() {
        recyclerView.smoothScrollToPosition(0);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(GetPostsEvent getPostsEvent) {
        listAdapter.getPosts(getPostsEvent.getResponse());
        swipeRefreshLayout.setRefreshing(false);
        Toast.makeText(getApplicationContext(), "Posts refreshed", Toast.LENGTH_LONG).show();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(MorePostsEvent morePostsEvent) {
        listAdapter.morePosts(morePostsEvent.getResponse());
        swipeRefreshLayout.setRefreshing(false);
        Toast.makeText(getApplicationContext(), "Posts refreshed", Toast.LENGTH_LONG).show();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(ErrorGettingPostsEvent error) {
        // TODO: 21-08-2017 display better error message
        swipeRefreshLayout.setRefreshing(false);
        Toast.makeText(getApplicationContext(), "Error getting posts", Toast.LENGTH_LONG).show();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(LaunchPreviewEvent event) {
        Intent i = new Intent(getApplicationContext(), PreviewActivity.class);
        i.putExtra("url", event.getPost().getData().getUrl());
        startActivity(i);
    }
}
