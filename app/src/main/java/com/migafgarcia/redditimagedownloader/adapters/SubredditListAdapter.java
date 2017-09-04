package com.migafgarcia.redditimagedownloader.adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.migafgarcia.redditimagedownloader.R;
import com.migafgarcia.redditimagedownloader.SubredditEntry;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SubredditListAdapter extends RecyclerView.Adapter<SubredditListAdapter.ViewHolder> {

    private Context mContext;
    private List<SubredditEntry> mSubreddits;

    public SubredditListAdapter(Context mContext, List<SubredditEntry> mSubreddits) {
        this.mContext = mContext;
        this.mSubreddits = mSubreddits;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.ms_list_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Picasso.with(mContext).load(mSubreddits.get(position).getImageUrl()).into(holder.imageView);
        holder.textView.setText(mSubreddits.get(position).getmSubreddit());
    }

    @Override
    public int getItemCount() {
        return mSubreddits.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        CheckBox checkbox;

        ViewHolder(View v) {
            super(v);
            imageView = v.findViewById(R.id.subreddit_imageview);
            textView = v.findViewById(R.id.subreddit_textview);
            checkbox = v.findViewById(R.id.subreddit_checkbox);
        }
    }
}
