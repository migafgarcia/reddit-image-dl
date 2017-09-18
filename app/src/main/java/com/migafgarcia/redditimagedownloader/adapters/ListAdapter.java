package com.migafgarcia.redditimagedownloader.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.migafgarcia.redditimagedownloader.R;
import com.migafgarcia.redditimagedownloader.model.Link;
import com.migafgarcia.redditimagedownloader.model.Listing;
import com.migafgarcia.redditimagedownloader.model.Resolution;
import com.migafgarcia.redditimagedownloader.model.Thing;
import com.migafgarcia.redditimagedownloader.utils.PostsUtils;
import com.squareup.picasso.Picasso;


import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListItemViewHolder> {

    private static final String TAG = ListAdapter.class.getName();

    private final Context context;
    private final ItemClickCallback itemClickCallback;
    private final MorePostsCallback morePostsCallback;
    private Listing posts;

    public ListAdapter(Context context, ItemClickCallback itemClickCallback, MorePostsCallback morePostsCallback) {
        this.context = context;
        this.itemClickCallback = itemClickCallback;
        this.morePostsCallback = morePostsCallback;
        posts = new Listing();
    }

    @Override
    public ListItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.thumbnail_list_item, parent, false);
        return new ListItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ListItemViewHolder holder, int position) {

        final Link post = (Link) posts.getChildren().get(position).getData();


        if (position == 3 * getItemCount() / 4 && getItemCount() > 0) {
            morePostsCallback.onMorePosts(posts.getAfter());
        }

        holder.title.setText(post.getTitle());
        holder.subreddit.setText(post.getSubreddit());
        holder.user.setText(post.getAuthor());

        List<Resolution> resolutions = post.getPreview().getImages().get(0).getResolutions();
        Resolution current = resolutions.get(0);
        if (post.getPreview().getEnabled()) {

            int width = Resources.getSystem().getDisplayMetrics().widthPixels;


            for (Resolution res : resolutions)
                if (res.getWidth() > current.getWidth() && res.getWidth() < width)
                    current = res;

            Log.d(TAG, "Position: " + position + ", " + current.getWidth() + "x" + current.getHeight());

            Picasso.with(context).
                    load(current.getUrl()).
                    placeholder(R.color.cardview_dark_background).
                    into(holder.preview);
        }
        else {
            Picasso.with(context).
                    load(post.getThumbnail()).
                    placeholder(R.color.cardview_dark_background).
                    into(holder.preview);
        }

        holder.preview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemClickCallback.onItemClick(post);
            }
        });

    }

    @Override
    public int getItemCount() {
        return posts.getChildren().size();
    }

    public void updatePosts(Thing response) {
        Listing listing = (Listing) response.getData();
        PostsUtils.processPosts(context, listing);

        this.posts.setAfter(listing.getAfter());
        this.posts.setBefore(listing.getBefore());
        this.posts.getChildren().addAll(listing.getChildren());
        this.posts.setModhash(listing.getModhash());

        notifyDataSetChanged();
    }

    public interface ItemClickCallback {
        void onItemClick(Link post);
    }

    public interface MorePostsCallback {
        void onMorePosts(String after);
    }
}
