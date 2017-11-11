package com.migafgarcia.imagedownloaderforreddit.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ImagesItem{

	@SerializedName("resolutions")
	private List<ResolutionsItem> resolutions;

	@SerializedName("source")
	private Source source;

	@SerializedName("variants")
	private Variants variants;

	@SerializedName("id")
	private String id;

	public void setResolutions(List<ResolutionsItem> resolutions){
		this.resolutions = resolutions;
	}

	public List<ResolutionsItem> getResolutions(){
		return resolutions;
	}

	public void setSource(Source source){
		this.source = source;
	}

	public Source getSource(){
		return source;
	}

	public void setVariants(Variants variants){
		this.variants = variants;
	}

	public Variants getVariants(){
		return variants;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	@Override
 	public String toString(){
		return 
			"ImagesItem{" + 
			"resolutions = '" + resolutions + '\'' + 
			",source = '" + source + '\'' + 
			",variants = '" + variants + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}