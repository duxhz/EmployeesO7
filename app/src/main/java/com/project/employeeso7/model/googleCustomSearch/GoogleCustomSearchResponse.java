package com.project.employeeso7.model.googleCustomSearch;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class GoogleCustomSearchResponse{

	@SerializedName("kind")
	private String kind;

	@SerializedName("context")
	private Context context;

	@SerializedName("queries")
	private Queries queries;

	@SerializedName("searchInformation")
	private SearchInformation searchInformation;

	@SerializedName("items")
	private List<ItemsItem> items;

	@SerializedName("url")
	private Url url;

	public void setKind(String kind){
		this.kind = kind;
	}

	public String getKind(){
		return kind;
	}

	public void setContext(Context context){
		this.context = context;
	}

	public Context getContext(){
		return context;
	}

	public void setQueries(Queries queries){
		this.queries = queries;
	}

	public Queries getQueries(){
		return queries;
	}

	public void setSearchInformation(SearchInformation searchInformation){
		this.searchInformation = searchInformation;
	}

	public SearchInformation getSearchInformation(){
		return searchInformation;
	}

	public void setItems(List<ItemsItem> items){
		this.items = items;
	}

	public List<ItemsItem> getItems(){
		return items;
	}

	public void setUrl(Url url){
		this.url = url;
	}

	public Url getUrl(){
		return url;
	}

	@Override
 	public String toString(){
		return 
			"GoogleCustomSearchResponse{" + 
			"kind = '" + kind + '\'' + 
			",context = '" + context + '\'' + 
			",queries = '" + queries + '\'' + 
			",searchInformation = '" + searchInformation + '\'' + 
			",items = '" + items + '\'' + 
			",url = '" + url + '\'' + 
			"}";
		}
}