package com.migafgarcia.redditimagedownloader.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.migafgarcia.redditimagedownloader.R;
import com.migafgarcia.redditimagedownloader.reddit_json.Post;

class ListItemViewHolder extends RecyclerView.ViewHolder {

    public static final String TAG = ListItemViewHolder.class.getName();

    TextView title, subreddit, user;
    ImageView preview;

    ListItemViewHolder(View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.title_textview);
        subreddit = itemView.findViewById(R.id.subreddit_textview);
        user = itemView.findViewById(R.id.user_textview);
        preview = itemView.findViewById(R.id.thumbnail_imageview);
    }

}
