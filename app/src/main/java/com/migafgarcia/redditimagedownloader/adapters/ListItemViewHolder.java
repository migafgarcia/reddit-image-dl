package com.migafgarcia.redditimagedownloader.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.migafgarcia.redditimagedownloader.R;

class ListItemViewHolder extends RecyclerView.ViewHolder {

    public static final String TAG = ListItemViewHolder.class.getName();

    final TextView title;
    final TextView subreddit;
    final TextView user;
    final ImageView preview;

    ListItemViewHolder(View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.title_textview);
        subreddit = itemView.findViewById(R.id.subreddit_textview);
        user = itemView.findViewById(R.id.user_textview);
        preview = itemView.findViewById(R.id.preview_zoomage);
    }

}
