package com.migafgarcia.redditimagedownloader;

import android.content.Context;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.migafgarcia.redditimagedownloader.adapters.ListAdapter;
import com.migafgarcia.redditimagedownloader.data.Post;
import com.migafgarcia.redditimagedownloader.data.RedditResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by mgarcia on 13-08-2017.
 */

public class Controller implements Callback<RedditResponse> {
    private Context mContext;
    private RecyclerView recyclerView;

    public Controller(Context context, RecyclerView recyclerView) {
        this.mContext = context;
        this.recyclerView = recyclerView;
    }

    @Override
    public void onResponse(Call<RedditResponse> call, Response<RedditResponse> response) {
        processPosts(response.body());

        recyclerView.swapAdapter(new ListAdapter(mContext, response.body().data.posts), true);


    }

    @Override
    public void onFailure(Call<RedditResponse> call, Throwable t) {
        Toast.makeText(mContext, t.getMessage(), Toast.LENGTH_LONG).show();
    }

    private void processPosts(RedditResponse response) {

        // TODO: 13-08-2017

    }
}
