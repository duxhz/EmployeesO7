package com.project.employeeso7.model.googleCustomSearch;

import com.google.gson.annotations.SerializedName;

public class ItemsItem{

	@SerializedName("snippet")
	private String snippet;

	@SerializedName("htmlFormattedUrl")
	private String htmlFormattedUrl;

	@SerializedName("htmlTitle")
	private String htmlTitle;

	@SerializedName("kind")
	private String kind;

	@SerializedName("pagemap")
	private Pagemap pagemap;

	@SerializedName("displayLink")
	private String displayLink;

	@SerializedName("link")
	private String link;

	@SerializedName("htmlSnippet")
	private String htmlSnippet;

	@SerializedName("title")
	private String title;

	@SerializedName("formattedUrl")
	private String formattedUrl;

	@SerializedName("cacheId")
	private String cacheId;

	public void setSnippet(String snippet){
		this.snippet = snippet;
	}

	public String getSnippet(){
		return snippet;
	}

	public void setHtmlFormattedUrl(String htmlFormattedUrl){
		this.htmlFormattedUrl = htmlFormattedUrl;
	}

	public String getHtmlFormattedUrl(){
		return htmlFormattedUrl;
	}

	public void setHtmlTitle(String htmlTitle){
		this.htmlTitle = htmlTitle;
	}

	public String getHtmlTitle(){
		return htmlTitle;
	}

	public void setKind(String kind){
		this.kind = kind;
	}

	public String getKind(){
		return kind;
	}

	public void setPagemap(Pagemap pagemap){
		this.pagemap = pagemap;
	}

	public Pagemap getPagemap(){
		return pagemap;
	}

	public void setDisplayLink(String displayLink){
		this.displayLink = displayLink;
	}

	public String getDisplayLink(){
		return displayLink;
	}

	public void setLink(String link){
		this.link = link;
	}

	public String getLink(){
		return link;
	}

	public void setHtmlSnippet(String htmlSnippet){
		this.htmlSnippet = htmlSnippet;
	}

	public String getHtmlSnippet(){
		return htmlSnippet;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setFormattedUrl(String formattedUrl){
		this.formattedUrl = formattedUrl;
	}

	public String getFormattedUrl(){
		return formattedUrl;
	}

	public void setCacheId(String cacheId){
		this.cacheId = cacheId;
	}

	public String getCacheId(){
		return cacheId;
	}

	@Override
 	public String toString(){
		return 
			"ItemsItem{" + 
			"snippet = '" + snippet + '\'' + 
			",htmlFormattedUrl = '" + htmlFormattedUrl + '\'' + 
			",htmlTitle = '" + htmlTitle + '\'' + 
			",kind = '" + kind + '\'' + 
			",pagemap = '" + pagemap + '\'' + 
			",displayLink = '" + displayLink + '\'' + 
			",link = '" + link + '\'' + 
			",htmlSnippet = '" + htmlSnippet + '\'' + 
			",title = '" + title + '\'' + 
			",formattedUrl = '" + formattedUrl + '\'' + 
			",cacheId = '" + cacheId + '\'' + 
			"}";
		}
}