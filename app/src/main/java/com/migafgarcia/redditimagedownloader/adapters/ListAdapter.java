package com.migafgarcia.redditimagedownloader.adapters;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
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

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
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

        Post post = posts.get(position);

        if (position == getItemCount() - 1 && getItemCount() > 0) {
            service.getListAfter(context.getString(R.string.multireddit), after).enqueue(new Controller(context, this));
        }

        holder.title.setText(post.getData().getTitle());
        holder.subreddit.setText(post.getData().getSubreddit());
        holder.user.setText(post.getData().getAuthor());

        Picasso.with(context).load(post.getData().getThumbnail()).placeholder(R.color.cardview_dark_background).into(holder.preview);


    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public void updatePosts(RedditResponse response) {
        posts.addAll(response.getData().getPosts());
        after = response.getData().getAfter();
        notifyDataSetChanged();
    }

}
