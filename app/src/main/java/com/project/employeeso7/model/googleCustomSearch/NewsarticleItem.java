package com.project.employeeso7.model.googleCustomSearch;

import com.google.gson.annotations.SerializedName;

public class NewsarticleItem{

	@SerializedName("articlebody")
	private String articlebody;

	@SerializedName("datemodified")
	private String datemodified;

	@SerializedName("keywords")
	private String keywords;

	@SerializedName("alternativeheadline")
	private String alternativeheadline;

	@SerializedName("title")
	private String title;

	@SerializedName("headline")
	private String headline;

	@SerializedName("url")
	private String url;

	@SerializedName("datepublished")
	private String datepublished;

	public void setArticlebody(String articlebody){
		this.articlebody = articlebody;
	}

	public String getArticlebody(){
		return articlebody;
	}

	public void setDatemodified(String datemodified){
		this.datemodified = datemodified;
	}

	public String getDatemodified(){
		return datemodified;
	}

	public void setKeywords(String keywords){
		this.keywords = keywords;
	}

	public String getKeywords(){
		return keywords;
	}

	public void setAlternativeheadline(String alternativeheadline){
		this.alternativeheadline = alternativeheadline;
	}

	public String getAlternativeheadline(){
		return alternativeheadline;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setHeadline(String headline){
		this.headline = headline;
	}

	public String getHeadline(){
		return headline;
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

	@Override
 	public String toString(){
		return 
			"NewsarticleItem{" + 
			"articlebody = '" + articlebody + '\'' + 
			",datemodified = '" + datemodified + '\'' + 
			",keywords = '" + keywords + '\'' + 
			",alternativeheadline = '" + alternativeheadline + '\'' + 
			",title = '" + title + '\'' + 
			",headline = '" + headline + '\'' + 
			",url = '" + url + '\'' + 
			",datepublished = '" + datepublished + '\'' + 
			"}";
		}
}