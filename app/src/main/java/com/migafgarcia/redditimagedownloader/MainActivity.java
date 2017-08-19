package com.migafgarcia.redditimagedownloader;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.migafgarcia.redditimagedownloader.adapters.ListAdapter;

public class MainActivity extends Activity {

    public static final String TAG = "MainActivity";

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private ListAdapter listAdapter;
    private FloatingActionButton floatingActionButton;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.main_recyclerview);
        floatingActionButton = findViewById(R.id.list_fab);
        swipeRefreshLayout = findViewById(R.id.list_swiperefreshlayout);
        
        mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        listAdapter = new ListAdapter(getApplicationContext());
        recyclerView.setAdapter(listAdapter);

        floatingActionButton.bringToFront();
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recyclerView.smoothScrollToPosition(0);
            }
        });

        swipeRefreshLayout.setOnRefreshListener(
                new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        listAdapter = new ListAdapter(getApplicationContext());
                        recyclerView.setAdapter(listAdapter);
                        swipeRefreshLayout.setRefreshing(false);
                    }
                }
        );


    }

}
