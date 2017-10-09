package com.migafgarcia.imagedownloaderforreddit.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.migafgarcia.imagedownloaderforreddit.R;
import com.migafgarcia.imagedownloaderforreddit.model.Link;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    private MainContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void setPresenter(MainContract.Presenter presenter) {

    }

    @Override
    public void launchPreview(Link link) {

    }

    @Override
    public void launchSettings() {

    }

    @Override
    public void launchSubredditManager() {

    }

    @Override
    public void scrollToTop(boolean smooth) {

    }
}
