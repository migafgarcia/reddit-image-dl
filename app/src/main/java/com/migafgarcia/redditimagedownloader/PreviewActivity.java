package com.migafgarcia.redditimagedownloader;

import android.Manifest;
import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.jsibbold.zoomage.ZoomageView;
import com.migafgarcia.redditimagedownloader.db.*;
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

    private DownloadsDbHelper helper;

    private Uri localFileUri;

    private long downloadId = -1;

    private BroadcastReceiver onDownloadComplete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);
        ButterKnife.bind(this);


        helper = new DownloadsDbHelper(getApplicationContext());

        logDb();

        previewPresenter = new PreviewPresenter();

        setSupportActionBar(mToolbar);

        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setDisplayHomeAsUpEnabled(true);
            ab.setDisplayShowTitleEnabled(false);
        }


        mFloatingActionButton.bringToFront();

        mPost = getIntent().getParcelableExtra("Post");

        loadPreview();

        String location = getLocation();

        if(location != null)
            localFileUri = Uri.parse(location);
        else
            localFileUri = null;



        onDownloadComplete = new MyBroadcastReceiver(mPost) {
            @Override
            public void onReceive(Context context, Intent intent) {

                Long dwnId = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, -1);
                if(dwnId == downloadId)
                    Log.d(TAG, "SAME ACTIVITY");
                else
                    Log.d(TAG, "DIFFERENT ACTIVITY");

                SQLiteDatabase db = helper.getReadableDatabase();
                ContentValues download = new ContentValues();
                download.put(DownloadEntry.COLUMN_NAME_POST_ID, mPost.getData().getId());
                download.put(DownloadEntry.COLUMN_NAME_LOCATION, localFileUri.toString());
                download.put(DownloadEntry.COLUMN_NAME_URL, mPost.getData().getUrl());
                db.insert(DownloadEntry.TABLE_NAME, null, download);
                db.close();

                downloadId = -1;
            }
        };


        /*

        imageUri = Uri.parse(mPost.getData().getUrl());

        downloadFileUri = Uri.fromFile(new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), imageUri.getLastPathSegment()));

        downloadContentUri = FileProvider.getUriForFile(
                this,
                getApplicationContext()
                        .getPackageName() + ".provider", new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), imageUri.getLastPathSegment()));


        */

    }

    private void loadPreview() {
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
    }

    private void logDb() {

        SQLiteDatabase db = helper.getReadableDatabase();

        String[] projection = {
                DownloadEntry.COLUMN_NAME_POST_ID,
                DownloadEntry.COLUMN_NAME_LOCATION,
                DownloadEntry.COLUMN_NAME_URL
        };



        Cursor cursor = db.query(
                DownloadEntry.TABLE_NAME,                     // The table to query
                projection,                               // The columns to return
                null,                                // The columns for the WHERE clause
                null,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                null                                 // The sort order
        );

        StringBuilder str = new StringBuilder();
        while(cursor.moveToNext()) {
            String id = cursor.getString(cursor.getColumnIndexOrThrow(DownloadEntry.COLUMN_NAME_POST_ID));
            String location = cursor.getString(cursor.getColumnIndexOrThrow(DownloadEntry.COLUMN_NAME_LOCATION));
            String url = cursor.getString(cursor.getColumnIndexOrThrow(DownloadEntry.COLUMN_NAME_URL));
            str.append("ID = " + id + "; LOCATION = " + location + "; URL = " + url + ";\n");
        }
        Log.d(TAG, str.toString());
        cursor.close();
        db.close();
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(onDownloadComplete);

    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(onDownloadComplete, new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));
    }

    @Override
    public void downloadImage() {

        if(downloadId != -1) {
            Toast.makeText(this, "Already downloading...", Toast.LENGTH_SHORT).show();
            return;
        }
        Uri imageUri = Uri.parse(mPost.getData().getUrl());

        DownloadManager.Request request = new DownloadManager.Request(imageUri);
        request.setDescription(mPost.getData().getAuthor());
        request.setTitle(mPost.getData().getTitle());
        request.allowScanningByMediaScanner();
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);


        if(localFileUri != null)
            request.setDestinationUri(localFileUri);
        else {
            localFileUri = Uri.fromFile(new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), imageUri.getLastPathSegment()));
            request.setDestinationUri(localFileUri);
        }
        request.setVisibleInDownloadsUi(true);
        DownloadManager manager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);

        if(isStoragePermissionGranted()) {
            downloadId = manager.enqueue(request);
            Toast.makeText(this, "Downloading image...", Toast.LENGTH_SHORT).show();
            /*
            SQLiteDatabase db = helper.getReadableDatabase();
            ContentValues download = new ContentValues();
            download.put(DownloadEntry.COLUMN_NAME_POST_ID, mPost.getData().getId());
            download.put(DownloadEntry.COLUMN_NAME_LOCATION, localFileUri.toString());
            download.put(DownloadEntry.COLUMN_NAME_URL, mPost.getData().getUrl());
            db.insert(DownloadEntry.TABLE_NAME, null, download);
            db.close();
            */
        }
    }

    @Override
    public void setAs() {

        if(localFileUri == null) {
            Toast.makeText(this, "Download image first", Toast.LENGTH_LONG).show();
            return;
        }

        Uri downloadContentUri = FileProvider.getUriForFile(
                this,
                getApplicationContext()
                        .getPackageName() + ".provider", new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), Uri.parse(mPost.getData().getUrl()).getLastPathSegment()));

        File file = new File(localFileUri.getPath());

        if(file.exists()) {
            Intent intent = new Intent(Intent.ACTION_ATTACH_DATA);
            intent.addCategory(Intent.CATEGORY_DEFAULT);
            intent.setDataAndType(downloadContentUri, "image/*");
            intent.putExtra("mimeType", "image/*");
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            intent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
            startActivity(Intent.createChooser(intent, "Set as:"));
        }
        else
            Log.d(TAG, "DOESN'T EXISTS");

    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
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

    public boolean isStoragePermissionGranted() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED)
                return true;
            else {
                Log.v(TAG, "Permission is revoked");
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                return false;
            }
        }
        else
            return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(grantResults[0]== PackageManager.PERMISSION_GRANTED){
            downloadImage();
        }
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

    public String getLocation() {

        if(helper == null)
            Log.d(TAG, "IS NULL YO");

        SQLiteDatabase db = helper.getReadableDatabase();

        String[] projection = {
                DownloadEntry.COLUMN_NAME_LOCATION,
        };

        String selection = DownloadEntry.COLUMN_NAME_POST_ID+ " = ?";

        String[] selectionArgs = {mPost.getData().getId()};


        Cursor cursor = db.query(
                DownloadEntry.TABLE_NAME,                     // The table to query
                projection,                               // The columns to return
                selection,                                // The columns for the WHERE clause
                selectionArgs,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                null                                 // The sort order
        );

        cursor.moveToFirst();

        String location = null;
        if(cursor.getCount() > 0)
            location = cursor.getString(cursor.getColumnIndexOrThrow(DownloadEntry.COLUMN_NAME_LOCATION));


        Log.d(TAG, "Image in DB: " + location);
        cursor.close();
        db.close();

        return location;
    }
}
