package com.project.employeeso7.model.googleCustomSearch;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Queries{

	@SerializedName("request")
	private List<RequestItem> request;

	@SerializedName("nextPage")
	private List<NextPageItem> nextPage;

	public void setRequest(List<RequestItem> request){
		this.request = request;
	}

	public List<RequestItem> getRequest(){
		return request;
	}

	public void setNextPage(List<NextPageItem> nextPage){
		this.nextPage = nextPage;
	}

	public List<NextPageItem> getNextPage(){
		return nextPage;
	}

	@Override
 	public String toString(){
		return 
			"Queries{" + 
			"request = '" + request + '\'' + 
			",nextPage = '" + nextPage + '\'' + 
			"}";
		}
}