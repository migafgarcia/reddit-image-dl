package com.migafgarcia.redditimagedownloader;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.jsibbold.zoomage.ZoomageView;
import com.migafgarcia.redditimagedownloader.presenters.PreviewScreen;
import com.squareup.picasso.Picasso;

public class PreviewActivity extends AppCompatActivity implements PreviewScreen {

    public static final String TAG = PreviewActivity.class.getName();

    private Uri mImageUri;

    private Toolbar mToolbar;
    private ZoomageView mPreview;
    private FloatingActionButton mFloatingActionButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);

        mToolbar = (Toolbar) findViewById(R.id.preview_toolbar);
        mPreview = (ZoomageView) findViewById(R.id.preview);
        mFloatingActionButton = (FloatingActionButton) findViewById(R.id.preview_fab);


        setSupportActionBar(mToolbar);

        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setDisplayHomeAsUpEnabled(true);
            ab.setDisplayShowTitleEnabled(false);
        }


        mFloatingActionButton.bringToFront();

        Intent intent = getIntent();
        String url = intent.getStringExtra("url");

        // TODO: 23-08-2017 load the same mPreview that was loaded in MainActivity due to animation
        Picasso.with(getApplicationContext()).load(url).into(mPreview);

        mImageUri = Uri.parse(url);

        mFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW, mImageUri);
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            default:
                return super.onOptionsItemSelected(item);

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.preview_appbar_buttons, menu);
        return true;
    }

}
