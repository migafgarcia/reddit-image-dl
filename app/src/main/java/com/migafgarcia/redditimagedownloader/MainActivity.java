package com.migafgarcia.redditimagedownloader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.migafgarcia.redditimagedownloader.data.Child;
import com.migafgarcia.redditimagedownloader.data.ListItem;
import com.migafgarcia.redditimagedownloader.services.RedditService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(TAG, "HELLO");
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://reddit.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RedditService service = retrofit.create(RedditService.class);

        service.getList(getString(R.string.multireddit)).enqueue(new Callback<ListItem>() {
            @Override
            public void onResponse(Call<ListItem> call, Response<ListItem> response) {
                ListItem res = response.body();

                for(Child c : res.data.children) {
                    Log.i(TAG, c.data.subreddit);
                }

            }

            @Override
            public void onFailure(Call<ListItem> call, Throwable t) {
                Log.e(TAG, t.getMessage());
            }
        });




    }
}
