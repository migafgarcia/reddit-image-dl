package com.migafgarcia.redditimagedownloader;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.migafgarcia.redditimagedownloader.adapters.SubredditsListAdapter;
import com.migafgarcia.redditimagedownloader.db.AppDatabase;
import com.migafgarcia.redditimagedownloader.db.SubredditData;
import com.migafgarcia.redditimagedownloader.db.SubredditDataDao;
import com.migafgarcia.redditimagedownloader.db.SubredditsViewModel;

import java.util.ArrayList;
import java.util.Collection;

public class SubredditActivity extends AppCompatActivity {

    private static final String TAG = SubredditActivity.class.getName();

    private static final String subredditNameRegex = "[A-Za-z0-9][A-Za-z0-9_]{2,20}";

    private AppDatabase appDatabase;
    private RecyclerView recyclerView;
    private SubredditsListAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subreddit);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Manage Subreddits");
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> showAddDialog());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        appDatabase = Room
                .databaseBuilder(getApplicationContext(), AppDatabase.class, "reddit-image-dl")
                .build();

        recyclerView = findViewById(R.id.subreddits_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        adapter = new SubredditsListAdapter();

        recyclerView.setAdapter(adapter);



        ViewModelProviders.of(this)
                .get(SubredditsViewModel.class)
                .getSubredditsLiveData(appDatabase.getSubredditDataDao())
                .observe(this, subredditData -> adapter.update(subredditData));
    }

    private void showAddDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Add subreddit");

        LayoutInflater inflater = getLayoutInflater();

        View v = inflater.inflate(R.layout.add_subreddit, null);
        Button add = v.findViewById(R.id.add_btn);
        EditText editText = v.findViewById(R.id.subreddit_editText);
        builder.setView(v);

        AlertDialog alertDialog = builder.create();
        alertDialog.show();

        add.setOnClickListener(view -> {
            String input = editText.getText().toString();
            if(input.matches(subredditNameRegex)) {
                new Thread(() -> appDatabase.getSubredditDataDao().insert(new SubredditData(input))).start();
                alertDialog.cancel();
            }
            else {
                Toast.makeText(SubredditActivity.this, "Subreddit name not allowed", Toast.LENGTH_SHORT).show();
            }
        });




    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

}
