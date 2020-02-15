package com.project.employeeso7.model.googleCustomSearch;

import com.google.gson.annotations.SerializedName;

public class MetatagsItem{

	@SerializedName("og:image")
	private String ogImage;

	@SerializedName("og:type")
	private String ogType;

	@SerializedName("twitter:card")
	private String twitterCard;

	@SerializedName("twitter:title")
	private String twitterTitle;

	@SerializedName("og:site_name")
	private String ogSiteName;

	@SerializedName("og:title")
	private String ogTitle;

	@SerializedName("music:creator")
	private String musicCreator;

	@SerializedName("title")
	private String title;

	@SerializedName("og:description")
	private String ogDescription;

	@SerializedName("twitter:creator")
	private String twitterCreator;

	@SerializedName("article:author")
	private String articleAuthor;

	@SerializedName("twitter:image")
	private String twitterImage;

	@SerializedName("referrer")
	private String referrer;

	@SerializedName("viewport")
	private String viewport;

	@SerializedName("og:url")
	private String ogUrl;

	public void setOgImage(String ogImage){
		this.ogImage = ogImage;
	}

	public String getOgImage(){
		return ogImage;
	}

	public void setOgType(String ogType){
		this.ogType = ogType;
	}

	public String getOgType(){
		return ogType;
	}

	public void setTwitterCard(String twitterCard){
		this.twitterCard = twitterCard;
	}

	public String getTwitterCard(){
		return twitterCard;
	}

	public void setTwitterTitle(String twitterTitle){
		this.twitterTitle = twitterTitle;
	}

	public String getTwitterTitle(){
		return twitterTitle;
	}

	public void setOgSiteName(String ogSiteName){
		this.ogSiteName = ogSiteName;
	}

	public String getOgSiteName(){
		return ogSiteName;
	}

	public void setOgTitle(String ogTitle){
		this.ogTitle = ogTitle;
	}

	public String getOgTitle(){
		return ogTitle;
	}

	public void setMusicCreator(String musicCreator){
		this.musicCreator = musicCreator;
	}

	public String getMusicCreator(){
		return musicCreator;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setOgDescription(String ogDescription){
		this.ogDescription = ogDescription;
	}

	public String getOgDescription(){
		return ogDescription;
	}

	public void setTwitterCreator(String twitterCreator){
		this.twitterCreator = twitterCreator;
	}

	public String getTwitterCreator(){
		return twitterCreator;
	}

	public void setArticleAuthor(String articleAuthor){
		this.articleAuthor = articleAuthor;
	}

	public String getArticleAuthor(){
		return articleAuthor;
	}

	public void setTwitterImage(String twitterImage){
		this.twitterImage = twitterImage;
	}

	public String getTwitterImage(){
		return twitterImage;
	}

	public void setReferrer(String referrer){
		this.referrer = referrer;
	}

	public String getReferrer(){
		return referrer;
	}

	public void setViewport(String viewport){
		this.viewport = viewport;
	}

	public String getViewport(){
		return viewport;
	}

	public void setOgUrl(String ogUrl){
		this.ogUrl = ogUrl;
	}

	public String getOgUrl(){
		return ogUrl;
	}

	@Override
 	public String toString(){
		return 
			"MetatagsItem{" + 
			"og:image = '" + ogImage + '\'' + 
			",og:type = '" + ogType + '\'' + 
			",twitter:card = '" + twitterCard + '\'' + 
			",twitter:title = '" + twitterTitle + '\'' + 
			",og:site_name = '" + ogSiteName + '\'' + 
			",og:title = '" + ogTitle + '\'' + 
			",music:creator = '" + musicCreator + '\'' + 
			",title = '" + title + '\'' + 
			",og:description = '" + ogDescription + '\'' + 
			",twitter:creator = '" + twitterCreator + '\'' + 
			",article:author = '" + articleAuthor + '\'' + 
			",twitter:image = '" + twitterImage + '\'' + 
			",referrer = '" + referrer + '\'' + 
			",viewport = '" + viewport + '\'' + 
			",og:url = '" + ogUrl + '\'' + 
			"}";
		}
}