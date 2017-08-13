package com.migafgarcia.redditimagedownloader.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.migafgarcia.redditimagedownloader.R;
import com.migafgarcia.redditimagedownloader.data.Post;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListItemViewHolder> {

    public static final String TAG = "ListAdapter";

    private List<Post> posts;
    private Context mContext;

    public ListAdapter(Context context, List<Post> posts) {
        this.posts = posts;
        mContext = context;
    }

    @Override
    public ListItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);

        return new ListItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ListItemViewHolder holder, int position) {
        holder.title.setText(posts.get(position).data.title);
        holder.subreddit.setText(posts.get(position).data.subreddit);
        holder.user.setText(posts.get(position).data.author);
        Picasso.with(mContext).load(posts.get(position).data.thumbnail).into(holder.preview);
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

}
