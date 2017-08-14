package com.migafgarcia.redditimagedownloader.controllers;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.migafgarcia.redditimagedownloader.adapters.ListAdapter;
import com.migafgarcia.redditimagedownloader.data.Post;
import com.migafgarcia.redditimagedownloader.data.RedditResponse;

import java.util.Iterator;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Controller implements Callback<RedditResponse> {

    public static final String TAG = "Controller";

    private Context mContext;
    private ListAdapter adapter;

    public Controller(Context context, ListAdapter adapter) {
        this.mContext = context;
        this.adapter = adapter;
    }

    @Override
    public void onResponse(Call<RedditResponse> call, Response<RedditResponse> response) {
        processPosts(response.body());
        adapter.updatePosts(response.body());
    }

    @Override
    public void onFailure(Call<RedditResponse> call, Throwable t) {
        Toast.makeText(mContext, t.getMessage(), Toast.LENGTH_LONG).show();
        Log.d(TAG, t.toString());
        Log.d(TAG, call.toString());
    }

    private void processPosts(RedditResponse response) {

        List<Post> posts = response.getData().getPosts();

        Iterator<Post> itr = posts.iterator();

        while(itr.hasNext()) {
            Post curr = itr.next();

            if(curr.getData().getPostHint() == null || !curr.getData().getPostHint().equals("image")) {
                itr.remove();
                Log.d(TAG, "Item removed");
            }
        }

    }
}
