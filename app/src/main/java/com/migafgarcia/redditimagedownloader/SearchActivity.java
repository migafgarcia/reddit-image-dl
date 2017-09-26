package com.migafgarcia.redditimagedownloader;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.migafgarcia.redditimagedownloader.model.Listing;
import com.migafgarcia.redditimagedownloader.model.Subreddit;
import com.migafgarcia.redditimagedownloader.model.Thing;
import com.migafgarcia.redditimagedownloader.services.RedditApi;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchActivity extends AppCompatActivity {

    private static final String TAG = SearchActivity.class.getName();
    @BindView(R.id.et_search)
    EditText searchEditText;
    @BindView(R.id.listview_search)
    ListView resultsListView;
    @BindView(R.id.srl_search)
    SwipeRefreshLayout swipeRefreshLayout;

    ArrayAdapter<Subreddit> adapter;

    final int TYPING_TIMEOUT = 1000; // 5 seconds timeout
    final Handler timeoutHandler = new Handler();
    final Runnable typingTimeout = new Runnable() {
        public void run() {
            search();
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);

        resultsListView.setAdapter(adapter);

        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                timeoutHandler.removeCallbacks(typingTimeout);
                timeoutHandler.postDelayed(typingTimeout, TYPING_TIMEOUT);

            }
        });

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                search();
            }
        });

        resultsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // TODO: 19-09-2017  
                Intent intent = new Intent();
                intent.putExtra("editTextValue", "value_here");
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    private void search() {

        RedditApi redditApi = new RedditApi();

        if(searchEditText.getText().toString().length() == 0) {
            swipeRefreshLayout.setRefreshing(false);
            return;
        }

        swipeRefreshLayout.setRefreshing(true);

        redditApi.getService().searchSubreddit(searchEditText.getText().toString()).enqueue(new Callback<Thing>() {
            @Override
            public void onResponse(Call<Thing> call, Response<Thing> response) {

                swipeRefreshLayout.setRefreshing(false);

                Listing listing = (Listing) response.body().getData();

                adapter.clear();
                for (Thing t : listing.getChildren()) {
                    Subreddit s = (Subreddit) t.getData();
                    adapter.add(s);
                }

                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<Thing> call, Throwable t) {
                swipeRefreshLayout.setRefreshing(false);
                // TODO: 19-09-2017 feedback on failure
            }
        });



    }

}
