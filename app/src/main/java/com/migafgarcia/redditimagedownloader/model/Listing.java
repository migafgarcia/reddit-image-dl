package com.migafgarcia.redditimagedownloader.model;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Listing extends Data implements Parcelable {
    @SerializedName("modhash")
    @Expose
    private String modhash;

    @SerializedName("children")
    @Expose
    private List<Thing> children = null;

    @SerializedName("after")
    @Expose
    private String after;

    @SerializedName("before")
    @Expose
    private String before;

    public String getModhash() {
        return modhash;
    }

    public List<Thing> getChildren() {
        return children;
    }

    public String getAfter() {
        return after;
    }

    public String getBefore() {
        return before;
    }

    public void setModhash(String modhash) {
        this.modhash = modhash;
    }

    public void setChildren(List<Thing> children) {
        this.children = children;
    }

    public void setAfter(String after) {
        this.after = after;
    }

    public void setBefore(String before) {
        this.before = before;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.modhash);
        dest.writeTypedList(this.children);
        dest.writeString(this.after);
        dest.writeString(this.before);
    }

    public Listing() {
        children = new ArrayList<>();
    }

    protected Listing(Parcel in) {
        this.modhash = in.readString();
        this.children = in.createTypedArrayList(Thing.CREATOR);
        this.after = in.readString();
        this.before = in.readString();
    }

    public static final Parcelable.Creator<Listing> CREATOR = new Parcelable.Creator<Listing>() {
        @Override
        public Listing createFromParcel(Parcel source) {
            return new Listing(source);
        }

        @Override
        public Listing[] newArray(int size) {
            return new Listing[size];
        }
    };
}
