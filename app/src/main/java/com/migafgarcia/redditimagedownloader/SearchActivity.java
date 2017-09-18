package com.migafgarcia.redditimagedownloader;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
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

    final int TYPING_TIMEOUT = 5000; // 5 seconds timeout
    boolean isTyping;
    final Handler timeoutHandler = new Handler();
    final Runnable typingTimeout = new Runnable() {
        public void run() {
            isTyping = false;
            search();
        }
    };

    private void search() {

        RedditApi redditApi = new RedditApi();

        swipeRefreshLayout.setRefreshing(true);

        redditApi.getService().searchSubreddit(searchEditText.getText().toString()).enqueue(new Callback<Thing>() {
            @Override
            public void onResponse(Call<Thing> call, Response<Thing> response) {

                swipeRefreshLayout.setRefreshing(false);

                Listing listing = (Listing) response.body().getData();

                for (Thing t : listing.getChildren()) {
                    Subreddit s = (Subreddit) t.getData();
                    Log.d(TAG, s.getDisplayName());
                }
            }

            @Override
            public void onFailure(Call<Thing> call, Throwable t) {

            }
        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);

        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // reset the timeout
                timeoutHandler.removeCallbacks(typingTimeout);

                if (searchEditText.getText().toString().trim().length() > 0) {
                    // schedule the timeout
                    timeoutHandler.postDelayed(typingTimeout, TYPING_TIMEOUT);

                    if (!isTyping) {
                        isTyping = true;
                        search();
                    }
                }
                else {
                    isTyping = false;
                    search();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


    }
}
