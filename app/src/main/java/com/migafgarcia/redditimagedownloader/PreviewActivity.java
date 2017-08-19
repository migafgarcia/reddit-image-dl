package com.migafgarcia.redditimagedownloader;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jsibbold.zoomage.ZoomageView;
import com.squareup.picasso.Picasso;

public class PreviewActivity extends AppCompatActivity {

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
}
