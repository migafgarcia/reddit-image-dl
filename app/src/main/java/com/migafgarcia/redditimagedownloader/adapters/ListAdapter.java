package com.migafgarcia.redditimagedownloader.adapters;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.migafgarcia.redditimagedownloader.R;
import com.migafgarcia.redditimagedownloader.controllers.Controller;
import com.migafgarcia.redditimagedownloader.reddit_json.Post;
import com.migafgarcia.redditimagedownloader.reddit_json.RedditResponse;
import com.migafgarcia.redditimagedownloader.reddit_json.Resolution;
import com.migafgarcia.redditimagedownloader.services.RedditService;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

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

        final Post post = posts.get(position);

        if (position == getItemCount() - 1 && getItemCount() > 0)
            service.getListAfter(context.getString(R.string.multireddit), after).
                    enqueue(new Controller(context, this));

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

        // TODO: 18-08-2017 temporary solution
        holder.preview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(post.getData().getUrl()));
                i.setFlags(FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public void updatePosts(RedditResponse response) {

        for(Post p : response.getData().getPosts())
            Log.d("LINKS", p.getData().getUrl());

        posts.addAll(response.getData().getPosts());
        after = response.getData().getAfter();
        notifyDataSetChanged();
    }


}
