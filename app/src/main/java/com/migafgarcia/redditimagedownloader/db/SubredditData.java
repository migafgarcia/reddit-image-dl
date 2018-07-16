package com.migafgarcia.redditimagedownloader.db;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * mgarcia
 * 16-07-2018
 * DCC/FCUP
 */
@Entity
public class SubredditData {
    @PrimaryKey
    @NonNull
    public String name;

    public SubredditData(String name) {
        this.name = name;
    }
}
