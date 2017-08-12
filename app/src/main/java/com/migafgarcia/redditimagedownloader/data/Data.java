package com.migafgarcia.redditimagedownloader.data;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("modhash")
    @Expose
    public String modhash;
    @SerializedName("children")
    @Expose
    public List<Child> children = null;
    @SerializedName("after")
    @Expose
    public String after;
    @SerializedName("before")
    @Expose
    public Object before;

}