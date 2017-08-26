package com.migafgarcia.redditimagedownloader;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.jsibbold.zoomage.ZoomageView;
import com.migafgarcia.redditimagedownloader.presenters.PreviewPresenter;
import com.migafgarcia.redditimagedownloader.presenters.PreviewScreen;
import com.migafgarcia.redditimagedownloader.reddit_json.Post;
import com.migafgarcia.redditimagedownloader.reddit_json.Resolution;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PreviewActivity extends AppCompatActivity implements PreviewScreen {

    public static final String TAG = PreviewActivity.class.getName();
    @BindView(R.id.preview_fab)
    FloatingActionButton mFloatingActionButton;
    @BindView(R.id.preview_zoomage)
    ZoomageView mZoomageView;
    @BindView(R.id.preview_toolbar)
    Toolbar mToolbar;

    private Post mPost;

    private PreviewPresenter previewPresenter;

    private DownloadManager manager;
    private DownloadManager.Request request;

    private BroadcastReceiver onComplete;

    Uri imageUri;
    Uri downloadUri;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);
        ButterKnife.bind(this);

        previewPresenter = new PreviewPresenter();

        setSupportActionBar(mToolbar);

        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setDisplayHomeAsUpEnabled(true);
            ab.setDisplayShowTitleEnabled(false);
        }


        mFloatingActionButton.bringToFront();

        mPost = getIntent().getParcelableExtra("Post");

        List<Resolution> resolutions = mPost.getData().getPreview().getImages().get(0).getResolutions();
        int currentWidth = 0;
        Resolution current = resolutions.get(0);

        for(Resolution res : resolutions)
            if(res.getWidth() > currentWidth)
                current = res;

        // TODO: 18-08-2017 find alternative non-deprecated function
        String url = Html.fromHtml(current.getUrl()).toString();


        // TODO: 23-08-2017 load the same preview that was loaded in MainActivity due to animation
        Picasso.with(getApplicationContext()).load(url).into(mZoomageView);


        onComplete = new BroadcastReceiver() {
            public void onReceive(Context ctxt, Intent intent) {
                System.out.println();
            }
        };

        imageUri = Uri.parse(mPost.getData().getUrl());
        downloadUri = Uri.fromFile(new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), imageUri.getLastPathSegment()));

        initDownloadManager();

    }

    private void initDownloadManager() {

        request = new DownloadManager.Request(imageUri);
        request.setDescription(mPost.getData().getAuthor());
        request.setTitle(mPost.getData().getTitle());
        request.allowScanningByMediaScanner();
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationUri(downloadUri);
        request.setVisibleInDownloadsUi(true);
        manager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
        registerReceiver(onComplete, new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));

    }

    @Override
    public void downloadImage() {
        long id = manager.enqueue(request);
        IntentFilter intentFilter = new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE);

    }

    @Override
    public void setAs() {

    }

    @Override
    public void goToThread() {
        Intent intent= new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.reddit.com" + mPost.getData().getPermalink()));
        startActivity(intent);
    }

    @Override
    public void goToSubreddit() {
        Intent intent= new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.reddit.com/r/" + mPost.getData().getSubreddit()));
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_set_as:
                setAs();
                return true;
            case R.id.action_subreddit:
                goToSubreddit();
                return true;
            case R.id.action_thread:
                goToThread();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();


        unregisterReceiver(onComplete);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.preview_appbar_buttons, menu);
        return true;
    }

    @OnClick(R.id.preview_fab)
    public void onViewClicked() {
        downloadImage();
    }

}
