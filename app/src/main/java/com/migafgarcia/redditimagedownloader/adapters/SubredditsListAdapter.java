package com.migafgarcia.redditimagedownloader.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.migafgarcia.redditimagedownloader.R;
import com.migafgarcia.redditimagedownloader.db.SubredditData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;


/**
 * mgarcia
 * 16-07-2018
 * DCC/FCUP
 */
public class SubredditsListAdapter extends RecyclerView.Adapter<SubredditViewHolder> {

    private static final String TAG = SubredditsListAdapter.class.getSimpleName();

    private OnSubredditClickListener onSubredditClickListener;

    public SubredditsListAdapter(OnSubredditClickListener onSubredditClickListener) {
        this.onSubredditClickListener = onSubredditClickListener;
    }

    private List<SubredditData> subredditList = new ArrayList<>();

    public void update(List<SubredditData> subreddits)  {
        subredditList.clear();
        subredditList.addAll(subreddits);
        notifyDataSetChanged();
        Log.d(TAG, "SUBREDDITS: " + Arrays.asList(subredditList));
    }

    @NonNull
    @Override
    public SubredditViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.subreddit_list_item, parent, false);
        return new SubredditViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SubredditViewHolder holder, int position) {
        SubredditData subredditData = subredditList.get(position);
        holder.subredditTextView.setText(subredditData.name);
//        holder.itemView.setOnClickListener(view -> onSubredditClickListener.onClick(subredditData));
        holder.itemView.setOnLongClickListener(view -> {
            onSubredditClickListener.onClick(subredditData);
            return false;
        });
    }

    @Override
    public int getItemCount() {
        return subredditList.size();
    }
}
