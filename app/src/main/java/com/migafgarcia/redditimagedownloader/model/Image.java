package com.migafgarcia.redditimagedownloader.model;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Image implements Parcelable {

    public static final String TAG = Image.class.getName();
    public static final Creator<Image> CREATOR = new Creator<Image>() {
        @Override
        public Image createFromParcel(Parcel source) {
            return new Image(source);
        }

        @Override
        public Image[] newArray(int size) {
            return new Image[size];
        }
    };
    @SerializedName("source")
    @Expose
    private Resolution source;
    @SerializedName("resolutions")
    @Expose
    private List<Resolution> resolutions = null;
    @SerializedName("id")
    @Expose
    private String id;

    public Image() {
    }

    Image(Parcel in) {
        this.source = in.readParcelable(Resolution.class.getClassLoader());
        this.resolutions = new ArrayList<>();
        in.readList(this.resolutions, Resolution.class.getClassLoader());
        this.id = in.readString();
    }

    public Resolution getSource() {
        return source;
    }

    public List<Resolution> getResolutions() {
        return resolutions;
    }

    public String getId() {
        return id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.source, flags);
        dest.writeList(this.resolutions);
        dest.writeString(this.id);
    }
}