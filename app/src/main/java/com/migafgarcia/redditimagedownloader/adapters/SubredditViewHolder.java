package com.migafgarcia.redditimagedownloader.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.migafgarcia.redditimagedownloader.R;

/**
 * mgarcia
 * 16-07-2018
 * DCC/FCUP
 */
public class SubredditViewHolder extends RecyclerView.ViewHolder {
    TextView subredditTextView;

    public SubredditViewHolder(View view) {
        super(view);
        this.subredditTextView = view.findViewById(R.id.subreddit_item_textView);
    }
}
