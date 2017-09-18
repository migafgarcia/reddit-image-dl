package com.migafgarcia.redditimagedownloader.model;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Thing implements Parcelable {

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("kind")
    @Expose
    private String kind;

    @SerializedName("data")
    @Expose
    private Data data;

    public Thing(String id, String name, String kind, Data data) {
        this.id = id;
        this.name = name;
        this.kind = kind;
        this.data = data;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getKind() {
        return kind;
    }

    public Data getData() {
        return data;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public void setData(Data data) {
        this.data = data;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.name);
        dest.writeString(this.kind);
        dest.writeParcelable(this.data, flags);
    }

    protected Thing(Parcel in) {
        this.id = in.readString();
        this.name = in.readString();
        this.kind = in.readString();
        this.data = in.readParcelable(Data.class.getClassLoader());
    }

    public static final Parcelable.Creator<Thing> CREATOR = new Parcelable.Creator<Thing>() {
        @Override
        public Thing createFromParcel(Parcel source) {
            return new Thing(source);
        }

        @Override
        public Thing[] newArray(int size) {
            return new Thing[size];
        }
    };
}
