package com.migafgarcia.redditimagedownloader;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.jsibbold.zoomage.ZoomageView;
import com.migafgarcia.redditimagedownloader.db.DownloadsDbHelper;
import com.migafgarcia.redditimagedownloader.presenters.PreviewPresenter;
import com.migafgarcia.redditimagedownloader.presenters.PreviewScreen;
import com.migafgarcia.redditimagedownloader.reddit_json.Post;
import com.migafgarcia.redditimagedownloader.reddit_json.Resolution;
import com.squareup.picasso.Picasso;
import com.tonyodev.fetch.Fetch;
import com.tonyodev.fetch.listener.FetchListener;
import com.tonyodev.fetch.request.Request;
import com.tonyodev.fetch.request.RequestInfo;

import java.io.File;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PreviewActivity extends AppCompatActivity implements PreviewScreen, FetchListener {

    private static final String TAG = PreviewActivity.class.getName();
    private static final int WRITE_EXTERNAL_STORAGE_CODE = 1234;

    @BindView(R.id.preview_fab)
    FloatingActionButton mFloatingActionButton;
    @BindView(R.id.preview_zoomage)
    ZoomageView mZoomageView;
    @BindView(R.id.preview_toolbar)
    Toolbar mToolbar;
    @BindView(R.id.preview_rl)
    RelativeLayout relativeLayout;

    private ProgressBar progressBar;

    private Post mPost;

    private PreviewPresenter previewPresenter;

    private DownloadsDbHelper helper;

    private Fetch fetch;

    private PopupWindow popupWindow;

    private long downloadId = Fetch.ENQUEUE_ERROR_ID;

    private String filePath;

    private boolean setAs = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);
        ButterKnife.bind(this);
        RedditImageDownloaderApp app = (RedditImageDownloaderApp) getApplication();

        fetch = app.getFetch();

        helper = new DownloadsDbHelper(getApplicationContext());
        previewPresenter = new PreviewPresenter();
        Bundle b = getIntent().getBundleExtra("bundle");
        mPost = b.getParcelable("Post");

        filePath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) + "/RedditImageDownloader/" + Uri.parse(mPost.getData().getUrl()).getLastPathSegment();

        loadPreview();

        initPopup();

        setSupportActionBar(mToolbar);

        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setDisplayHomeAsUpEnabled(true);
            ab.setDisplayShowTitleEnabled(false);
        }

        mFloatingActionButton.bringToFront();

        fetch.removeRequests();


        System.out.println();

    }

    @Override
    protected void onResume() {
        super.onResume();

        if (downloadId != Fetch.ENQUEUE_ERROR_ID) {

            RequestInfo info = fetch.get(downloadId);

            if (info != null) {
                popupWindow.showAtLocation(relativeLayout, Gravity.CENTER, 0, 0);
                progressBar.setProgress(info.getProgress());
                Log.d(TAG, "POPUP");
            }

            fetch.addFetchListener(this);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        fetch.removeFetchListener(this);
        popupWindow.dismiss();
    }

    private void enqueueDownload() {

        String url = mPost.getData().getUrl();

        Request request = new Request(url, filePath);

        downloadId = fetch.enqueue(request);

        if (downloadId != Fetch.ENQUEUE_ERROR_ID) {
            popupWindow.showAtLocation(relativeLayout, Gravity.CENTER, 0, 0);
            progressBar.setIndeterminate(true);
        }
        else {
            Toast.makeText(this, "Error queueing download", Toast.LENGTH_SHORT).show();
        }

        fetch.addFetchListener(this);

    }

    private void loadPreview() {
        List<Resolution> resolutions = mPost.getData().getPreview().getImages().get(0).getResolutions();
        int currentWidth = 0;
        Resolution current = resolutions.get(0);

        for (Resolution res : resolutions)
            if (res.getWidth() > currentWidth)
                current = res;

        // TODO: 18-08-2017 find alternative non-deprecated function
        String url = Html.fromHtml(current.getUrl()).toString();


        // TODO: 23-08-2017 load the same preview that was loaded in MainActivity due to animation
        Picasso.with(getApplicationContext()).load(url).into(mZoomageView);
    }

    @Override
    public void downloadImage() {

        File file = new File(filePath);

        if(file.exists()) {
            Toast.makeText(this, "Already downloaded", Toast.LENGTH_SHORT).show();
            return;
        }

        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    WRITE_EXTERNAL_STORAGE_CODE);
        }
        else {
            enqueueDownload();
        }

    }

    private void initPopup() {
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);

        // Inflate the custom layout/view
        View popupView = inflater.inflate(R.layout.download_overlay, null);

        popupWindow = new PopupWindow(
                popupView,
                LayoutParams.MATCH_PARENT,
                LayoutParams.MATCH_PARENT,
                true
        );

        if (Build.VERSION.SDK_INT >= 21) {
            popupWindow.setElevation(5.0f);
        }

        progressBar = popupView.findViewById(R.id.progressBar);
    }

    @Override
    public void setAs() {
        setAs = false;

        File file = new File(filePath);

        if (file.exists()) {
            Uri downloadContentUri = FileProvider.getUriForFile(
                    this,
                    getApplicationContext()
                            .getPackageName() + ".provider", file);
            Intent intent = new Intent(Intent.ACTION_ATTACH_DATA);
            intent.addCategory(Intent.CATEGORY_DEFAULT);
            intent.setDataAndType(downloadContentUri, "image/*");
            intent.putExtra("mimeType", "image/*");
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            intent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
            startActivity(Intent.createChooser(intent, "Set as:"));
        } else {
            setAs = true;
            downloadImage();
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    public void goToThread() {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.reddit.com" + mPost.getData().getPermalink()));
        startActivity(intent);
    }

    @Override
    public void goToSubreddit() {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.reddit.com/r/" + mPost.getData().getSubreddit()));
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_share:
                share();
                return true;
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

    private void share() {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_SUBJECT, "Sharing URL");
        i.putExtra(Intent.EXTRA_TEXT, mPost.getData().getUrl());
        startActivity(Intent.createChooser(i, "Share URL"));
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

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if (requestCode == WRITE_EXTERNAL_STORAGE_CODE || grantResults.length > 0
                && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            enqueueDownload();
        } else {
            Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onUpdate(long id, int status, int progress, long downloadedBytes, long fileSize, int error) {
        if (id == downloadId) {
            switch (status) {
                case Fetch.STATUS_DONE:
                    Log.d(TAG, "STATUS_DONE");
                    downloadId = -1;
                    progressBar.setProgress(100);
                    popupWindow.dismiss();
                    downloadSuccessful();
                    if (setAs)
                        setAs();
                    break;
                case Fetch.STATUS_DOWNLOADING:
                    Log.d(TAG, "STATUS_DOWNLOADING Progress: " + progress);
                    progressBar.setIndeterminate(false);
                    progressBar.setProgress(progress);
                    break;
                case Fetch.STATUS_ERROR:
                    Log.d(TAG, "STATUS_ERROR");
                    popupWindow.dismiss();
                    downloadFailed();
                    break;
                case Fetch.STATUS_NOT_QUEUED:
                    Log.d(TAG, "STATUS_NOT_QUEUED");
                    progressBar.setIndeterminate(true);
                    break;
                case Fetch.STATUS_PAUSED:
                    Log.d(TAG, "STATUS_PAUSED");
                    progressBar.setProgress(progress);
                    break;
                case Fetch.STATUS_QUEUED:
                    Log.d(TAG, "STATUS_QUEUED");
                    progressBar.setIndeterminate(true);
                    break;
                case Fetch.STATUS_REMOVED:
                    Log.d(TAG, "STATUS_REMOVED");
                    popupWindow.dismiss();
                    downloadRemoved();
                    break;
                default:
                    Log.d(TAG, "STATUS_UNKNOWN");
                    popupWindow.dismiss();
                    downloadUnknown();
                    break;
            }
        }
    }

    private void downloadUnknown() {
        Toast.makeText(this, "Unknown error", Toast.LENGTH_LONG).show();
    }

    private void downloadRemoved() {
        Toast.makeText(this, "Download removed", Toast.LENGTH_LONG).show();
    }

    private void downloadFailed() {
        Toast.makeText(this, "Download failed", Toast.LENGTH_LONG).show();
    }

    private void downloadSuccessful() {
        Intent intent =
                new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        intent.setData(Uri.fromFile(new File(filePath)));
        sendBroadcast(intent);
        Toast.makeText(this, "Download complete", Toast.LENGTH_LONG).show();
    }

}
