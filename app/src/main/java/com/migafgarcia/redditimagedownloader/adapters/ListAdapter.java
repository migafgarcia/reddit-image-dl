package com.migafgarcia.redditimagedownloader.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.migafgarcia.redditimagedownloader.R;
import com.migafgarcia.redditimagedownloader.controllers.Controller;
import com.migafgarcia.redditimagedownloader.data.Post;
import com.migafgarcia.redditimagedownloader.data.RedditResponse;
import com.migafgarcia.redditimagedownloader.services.RedditService;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListAdapter extends RecyclerView.Adapter<ListItemViewHolder> {

    public static final String TAG = "ListAdapter";

    private Context context;
    private RedditService service;
    private List<Post> posts;
    private String after;

    public ListAdapter(Context context) {
        this.context = context;
        posts = new ArrayList<>(0);
        after = "";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(context.getString(R.string.reddit_base_url))
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(RedditService.class);
        service.getList(context.getString(R.string.multireddit)).enqueue(new Controller(context, this));
    }

    @Override
    public ListItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_list_item, parent, false);
        return new ListItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ListItemViewHolder holder, int position) {

        if (position == getItemCount() - 1) {
            service.getListAfter(context.getString(R.string.multireddit), after).enqueue(new Controller(context, this));
        }

        holder.title.setText(posts.get(position).data.title);
        holder.subreddit.setText(posts.get(position).data.subreddit);
        holder.user.setText(posts.get(position).data.author);
        Picasso.with(context).load(posts.get(position).data.thumbnail).into(holder.preview);
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public void updatePosts(RedditResponse response) {
        posts.addAll(response.data.posts);
        after = response.data.after;
        Log.d(TAG, "After = " + response.data.after);
        notifyDataSetChanged();
    }

}
