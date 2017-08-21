package com.migafgarcia.redditimagedownloader;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jsibbold.zoomage.ZoomageView;
import com.migafgarcia.redditimagedownloader.presenters.PreviewScreen;
import com.squareup.picasso.Picasso;

import org.greenrobot.eventbus.EventBus;

public class PreviewActivity extends AppCompatActivity implements PreviewScreen {

    public static final String TAG = PreviewActivity.class.getName();

    private FloatingActionButton floatingActionButton;
    private ZoomageView preview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);

        floatingActionButton = (FloatingActionButton) findViewById(R.id.preview_fab);
        preview = (ZoomageView) findViewById(R.id.preview_imageview);

        floatingActionButton.bringToFront();

        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        Picasso.with(getApplicationContext()).load(url).into(preview);
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void downloadImage() {

    }

    @Override
    public void setAs() {

    }

    @Override
    public void goToThread() {

    }

    @Override
    public void goToSubreddit() {

    }



}
