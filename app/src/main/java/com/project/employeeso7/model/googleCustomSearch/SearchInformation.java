package com.project.employeeso7.model.googleCustomSearch;

import com.google.gson.annotations.SerializedName;

public class SearchInformation{

	@SerializedName("searchTime")
	private double searchTime;

	@SerializedName("totalResults")
	private String totalResults;

	@SerializedName("formattedTotalResults")
	private String formattedTotalResults;

	@SerializedName("formattedSearchTime")
	private String formattedSearchTime;

	public void setSearchTime(double searchTime){
		this.searchTime = searchTime;
	}

	public double getSearchTime(){
		return searchTime;
	}

	public void setTotalResults(String totalResults){
		this.totalResults = totalResults;
	}

	public String getTotalResults(){
		return totalResults;
	}

	public void setFormattedTotalResults(String formattedTotalResults){
		this.formattedTotalResults = formattedTotalResults;
	}

	public String getFormattedTotalResults(){
		return formattedTotalResults;
	}

	public void setFormattedSearchTime(String formattedSearchTime){
		this.formattedSearchTime = formattedSearchTime;
	}

	public String getFormattedSearchTime(){
		return formattedSearchTime;
	}

	@Override
 	public String toString(){
		return 
			"SearchInformation{" + 
			"searchTime = '" + searchTime + '\'' + 
			",totalResults = '" + totalResults + '\'' + 
			",formattedTotalResults = '" + formattedTotalResults + '\'' + 
			",formattedSearchTime = '" + formattedSearchTime + '\'' + 
			"}";
		}
}