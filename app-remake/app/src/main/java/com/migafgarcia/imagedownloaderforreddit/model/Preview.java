package com.migafgarcia.imagedownloaderforreddit.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Preview{

	@SerializedName("images")
	private List<ImagesItem> images;

	@SerializedName("enabled")
	private boolean enabled;

	public void setImages(List<ImagesItem> images){
		this.images = images;
	}

	public List<ImagesItem> getImages(){
		return images;
	}

	public void setEnabled(boolean enabled){
		this.enabled = enabled;
	}

	public boolean isEnabled(){
		return enabled;
	}

	@Override
 	public String toString(){
		return 
			"Preview{" + 
			"images = '" + images + '\'' + 
			",enabled = '" + enabled + '\'' + 
			"}";
		}
}