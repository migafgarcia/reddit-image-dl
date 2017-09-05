package com.migafgarcia.redditimagedownloader.reddit_json;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Preview implements Parcelable {

    public static final String TAG = Preview.class.getName();
    public static final Parcelable.Creator<Preview> CREATOR = new Parcelable.Creator<Preview>() {
        @Override
        public Preview createFromParcel(Parcel source) {
            return new Preview(source);
        }

        @Override
        public Preview[] newArray(int size) {
            return new Preview[size];
        }
    };
    @SerializedName("images")
    @Expose
    private List<Image> images = null;
    @SerializedName("enabled")
    @Expose
    private Boolean enabled;

    public Preview() {
    }

    Preview(Parcel in) {
        this.images = new ArrayList<>();
        in.readList(this.images, Image.class.getClassLoader());
        this.enabled = (Boolean) in.readValue(Boolean.class.getClassLoader());
    }

    public List<Image> getImages() {
        return images;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(this.images);
        dest.writeValue(this.enabled);
    }
}
