package com.migafgarcia.imagedownloaderforreddit.model;

import com.google.gson.annotations.SerializedName;

public class T3{

	@SerializedName("data")
	private Data data;

	@SerializedName("kind")
	private String kind;

	public void setData(Data data){
		this.data = data;
	}

	public Data getData(){
		return data;
	}

	public void setKind(String kind){
		this.kind = kind;
	}

	public String getKind(){
		return kind;
	}

	@Override
 	public String toString(){
		return 
			"T3{" + 
			"data = '" + data + '\'' + 
			",kind = '" + kind + '\'' + 
			"}";
		}
}