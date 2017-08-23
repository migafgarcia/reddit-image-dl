package com.migafgarcia.redditimagedownloader;

import android.app.DownloadManager;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.jsibbold.zoomage.ZoomageView;
import com.migafgarcia.redditimagedownloader.presenters.PreviewScreen;
import com.squareup.picasso.Picasso;

public class PreviewActivity extends AppCompatActivity implements PreviewScreen {

    public static final String TAG = PreviewActivity.class.getName();

    private DownloadManager downloadManager;
    private Uri imageUri;

    private FloatingActionButton floatingActionButton;
    private ZoomageView preview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);

        floatingActionButton = (FloatingActionButton) findViewById(R.id.preview_fab);
        preview = (ZoomageView) findViewById(R.id.preview);

        floatingActionButton.bringToFront();

        Intent intent = getIntent();
        String url = intent.getStringExtra("url");

        // TODO: 23-08-2017 load the same preview that was loaded in MainActivity due to animation
        Picasso.with(getApplicationContext()).load(url).into(preview);

        downloadManager = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
        imageUri = Uri.parse(url);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW, imageUri);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        //EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        //EventBus.getDefault().unregister(this);
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
