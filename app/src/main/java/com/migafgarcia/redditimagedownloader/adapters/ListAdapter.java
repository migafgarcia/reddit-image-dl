package com.migafgarcia.redditimagedownloader.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.migafgarcia.redditimagedownloader.R;
import com.migafgarcia.redditimagedownloader.presenters.MainScreen;
import com.migafgarcia.redditimagedownloader.reddit_json.Post;
import com.migafgarcia.redditimagedownloader.reddit_json.RedditResponse;
import com.migafgarcia.redditimagedownloader.reddit_json.Resolution;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListItemViewHolder> {

    public static final String TAG = ListAdapter.class.getName();

    private Context context;
    private MainScreen mainScreen;
    private List<Post> posts;
    private String after;

    public ListAdapter(Context context, MainScreen mainScreen) {
        this.context = context;
        this.mainScreen = mainScreen;
        posts = new ArrayList<>(0);
        after = "";
    }

    @Override
    public ListItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_list_item, parent, false);
        return new ListItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ListItemViewHolder holder, int position) {

        final Post post = posts.get(position);

        if (position == 3 * getItemCount() / 4 && getItemCount() > 0)
            mainScreen.morePosts(after);


        holder.title.setText(post.getData().getTitle());
        holder.subreddit.setText(post.getData().getSubreddit());
        holder.user.setText(post.getData().getAuthor());

        String url = post.getData().getThumbnail();

        if(post.getData().getPreview().getEnabled()) {
            List<Resolution> resolutions = post.getData().getPreview().getImages().get(0).getResolutions();
            int width = Resources.getSystem().getDisplayMetrics().widthPixels;
            Resolution current = resolutions.get(0);

            for(Resolution res : resolutions)
                if(res.getWidth() > current.getWidth() && res.getWidth() <width)
                    current = res;

            Log.d(TAG, "Position: " + position + ", " + current.getWidth() + "x" + current.getHeight());
            // TODO: 18-08-2017 find alternative non-deprecated function
            url = Html.fromHtml(current.getUrl()).toString();
        }

        Picasso.with(context).
                load(url).
                placeholder(R.color.cardview_dark_background).
                into(holder.preview);

        holder.preview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainScreen.launchPreview(post);
            }
        });

    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public void getPosts(RedditResponse response) {
        posts.clear();
        posts.addAll(response.getData().getPosts());
        after = response.getData().getAfter();
        notifyDataSetChanged();
    }

    public void morePosts(RedditResponse response) {
        posts.addAll(response.getData().getPosts());
        after = response.getData().getAfter();
        notifyDataSetChanged();
    }
}
