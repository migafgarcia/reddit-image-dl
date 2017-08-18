package com.migafgarcia.redditimagedownloader.reddit_json;


import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Image {

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
}