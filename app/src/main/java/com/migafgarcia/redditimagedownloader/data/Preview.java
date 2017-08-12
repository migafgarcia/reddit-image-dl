package com.migafgarcia.redditimagedownloader.data;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Preview {

    @SerializedName("images")
    @Expose
    public List<Image> images = null;
    @SerializedName("enabled")
    @Expose
    public Boolean enabled;

}