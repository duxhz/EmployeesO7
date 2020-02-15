package com.project.employeeso7.model.googleCustomSearch;

import com.google.gson.annotations.SerializedName;

public class SitenavigationelementItem{

	@SerializedName("datemodified")
	private String datemodified;

	@SerializedName("author")
	private String author;

	@SerializedName("name")
	private String name;

	@SerializedName("url")
	private String url;

	@SerializedName("datepublished")
	private String datepublished;

	@SerializedName("mainentityofpage")
	private String mainentityofpage;

	public void setDatemodified(String datemodified){
		this.datemodified = datemodified;
	}

	public String getDatemodified(){
		return datemodified;
	}

	public void setAuthor(String author){
		this.author = author;
	}

	public String getAuthor(){
		return author;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	public void setDatepublished(String datepublished){
		this.datepublished = datepublished;
	}

	public String getDatepublished(){
		return datepublished;
	}

	public void setMainentityofpage(String mainentityofpage){
		this.mainentityofpage = mainentityofpage;
	}

	public String getMainentityofpage(){
		return mainentityofpage;
	}

	@Override
 	public String toString(){
		return 
			"SitenavigationelementItem{" + 
			"datemodified = '" + datemodified + '\'' + 
			",author = '" + author + '\'' + 
			",name = '" + name + '\'' + 
			",url = '" + url + '\'' + 
			",datepublished = '" + datepublished + '\'' + 
			",mainentityofpage = '" + mainentityofpage + '\'' + 
			"}";
		}
}