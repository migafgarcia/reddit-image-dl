package com.migafgarcia.redditimagedownloader.services;

import com.migafgarcia.redditimagedownloader.events.ErrorGettingPostsEvent;
import com.migafgarcia.redditimagedownloader.events.GetPostsEvent;
import com.migafgarcia.redditimagedownloader.reddit_json.Post;
import com.migafgarcia.redditimagedownloader.reddit_json.RedditResponse;

import org.greenrobot.eventbus.EventBus;

import java.util.Iterator;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RedditServiceCallback implements Callback<RedditResponse> {

    public static final String TAG = RedditServiceCallback.class.getName();

    @Override
    public void onResponse(Call<RedditResponse> call, Response<RedditResponse> response) {

        if(response.isSuccessful()) {
            processPosts(response.body());
            EventBus.getDefault().post(new GetPostsEvent(response.body()));
        }
        else
            EventBus.getDefault().post(new ErrorGettingPostsEvent());
    }

    @Override
    public void onFailure(Call<RedditResponse> call, Throwable t) {
        EventBus.getDefault().post(new ErrorGettingPostsEvent());
    }

    private void processPosts(RedditResponse response) {

        List<Post> posts = response.getData().getPosts();

        Iterator<Post> itr = posts.iterator();

        while(itr.hasNext()) {
            Post curr = itr.next();

            if (curr.getData().getPostHint() == null || !curr.getData().getPostHint().equals("image"))
                itr.remove();
        }
    }
}
