package com.project.employeeso7.model.googleCustomSearch;

import com.google.gson.annotations.SerializedName;

public class Context{

	@SerializedName("title")
	private String title;

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	@Override
 	public String toString(){
		return 
			"Context{" + 
			"title = '" + title + '\'' + 
			"}";
		}
}