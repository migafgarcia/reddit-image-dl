package com.migafgarcia.redditimagedownloader.adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;

import android.view.ViewGroup;
import android.widget.CheckBox;

import com.migafgarcia.redditimagedownloader.SubredditEntry;

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
        return new ViewHolder(new CheckBox(mContext));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTextView.setText(mSubreddits.get(position).getmSubreddit());
    }

    @Override
    public int getItemCount() {
        return mSubreddits.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        CheckBox mTextView;

        public ViewHolder(CheckBox v) {
            super(v);
            mTextView = v;
        }
    }
}
