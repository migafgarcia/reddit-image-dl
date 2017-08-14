package com.migafgarcia.redditimagedownloader.data;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Preview {

    @SerializedName("images")
    @Expose
    private List<Image> images = null;

    @SerializedName("enabled")
    @Expose
    private Boolean enabled;

    public List<Image> getImages() {
        return images;
    }

    public Boolean getEnabled() {
        return enabled;
    }
}
