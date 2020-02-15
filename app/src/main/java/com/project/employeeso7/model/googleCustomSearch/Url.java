package com.project.employeeso7.model.googleCustomSearch;

import com.google.gson.annotations.SerializedName;

public class Url{

	@SerializedName("template")
	private String template;

	@SerializedName("type")
	private String type;

	public void setTemplate(String template){
		this.template = template;
	}

	public String getTemplate(){
		return template;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	@Override
 	public String toString(){
		return 
			"Url{" + 
			"template = '" + template + '\'' + 
			",type = '" + type + '\'' + 
			"}";
		}
}