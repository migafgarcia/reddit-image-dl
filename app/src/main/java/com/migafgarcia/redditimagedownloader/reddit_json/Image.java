package com.migafgarcia.redditimagedownloader.reddit_json;


import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Image implements Parcelable {

    public static final String TAG = Image.class.getName();

    @SerializedName("source")
    @Expose
    private Resolution source;

    @SerializedName("resolutions")
    @Expose
    private List<Resolution> resolutions = null;

    @SerializedName("id")
    @Expose
    private String id;

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

    public Image() {
    }

    protected Image(Parcel in) {
        this.source = in.readParcelable(Resolution.class.getClassLoader());
        this.resolutions = new ArrayList<Resolution>();
        in.readList(this.resolutions, Resolution.class.getClassLoader());
        this.id = in.readString();
    }

    public static final Parcelable.Creator<Image> CREATOR = new Parcelable.Creator<Image>() {
        @Override
        public Image createFromParcel(Parcel source) {
            return new Image(source);
        }

        @Override
        public Image[] newArray(int size) {
            return new Image[size];
        }
    };
}