package com.project.employeeso7.model.googleCustomSearch;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Pagemap{

	@SerializedName("metatags")
	private List<MetatagsItem> metatags;

	@SerializedName("cse_image")
	private List<CseImageItem> cseImage;

	@SerializedName("cse_thumbnail")
	private List<CseThumbnailItem> cseThumbnail;

	@SerializedName("imageobject")
	private List<ImageobjectItem> imageobject;

	@SerializedName("person")
	private List<PersonItem> person;

	@SerializedName("organization")
	private List<OrganizationItem> organization;

	@SerializedName("sitenavigationelement")
	private List<SitenavigationelementItem> sitenavigationelement;

	@SerializedName("newsarticle")
	private List<NewsarticleItem> newsarticle;

	public void setMetatags(List<MetatagsItem> metatags){
		this.metatags = metatags;
	}

	public List<MetatagsItem> getMetatags(){
		return metatags;
	}

	public void setCseImage(List<CseImageItem> cseImage){
		this.cseImage = cseImage;
	}

	public List<CseImageItem> getCseImage(){
		return cseImage;
	}

	public void setCseThumbnail(List<CseThumbnailItem> cseThumbnail){
		this.cseThumbnail = cseThumbnail;
	}

	public List<CseThumbnailItem> getCseThumbnail(){
		return cseThumbnail;
	}

	public void setImageobject(List<ImageobjectItem> imageobject){
		this.imageobject = imageobject;
	}

	public List<ImageobjectItem> getImageobject(){
		return imageobject;
	}

	public void setPerson(List<PersonItem> person){
		this.person = person;
	}

	public List<PersonItem> getPerson(){
		return person;
	}

	public void setOrganization(List<OrganizationItem> organization){
		this.organization = organization;
	}

	public List<OrganizationItem> getOrganization(){
		return organization;
	}

	public void setSitenavigationelement(List<SitenavigationelementItem> sitenavigationelement){
		this.sitenavigationelement = sitenavigationelement;
	}

	public List<SitenavigationelementItem> getSitenavigationelement(){
		return sitenavigationelement;
	}

	public void setNewsarticle(List<NewsarticleItem> newsarticle){
		this.newsarticle = newsarticle;
	}

	public List<NewsarticleItem> getNewsarticle(){
		return newsarticle;
	}

	@Override
 	public String toString(){
		return 
			"Pagemap{" + 
			"metatags = '" + metatags + '\'' + 
			",cse_image = '" + cseImage + '\'' + 
			",cse_thumbnail = '" + cseThumbnail + '\'' + 
			",imageobject = '" + imageobject + '\'' + 
			",person = '" + person + '\'' + 
			",organization = '" + organization + '\'' + 
			",sitenavigationelement = '" + sitenavigationelement + '\'' + 
			",newsarticle = '" + newsarticle + '\'' + 
			"}";
		}
}