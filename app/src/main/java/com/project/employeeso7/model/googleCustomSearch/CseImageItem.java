package com.project.employeeso7.model.googleCustomSearch;

import com.google.gson.annotations.SerializedName;

public class CseImageItem{

	@SerializedName("src")
	private String src;

	public void setSrc(String src){
		this.src = src;
	}

	public String getSrc(){
		return src;
	}

	@Override
 	public String toString(){
		return 
			"CseImageItem{" + 
			"src = '" + src + '\'' + 
			"}";
		}
}