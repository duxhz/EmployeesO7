package com.project.employeeso7.repository.remote;

import com.project.employeeso7.api.ApiService;
import com.project.employeeso7.model.googleCustomSearch.GoogleCustomSearchResponse;

import io.reactivex.Observable;

public class ApiDataSource {

    private static ApiDataSource sInstance;

    private ApiService mApiService;

    private ApiDataSource(ApiService apiService) {
        this.mApiService = apiService;
    }

    public static ApiDataSource getInstance(ApiService apiService) {
        if (sInstance == null) {
            synchronized (ApiDataSource.class) {
                if (sInstance == null) {
                    sInstance = new ApiDataSource(apiService);
                }
            }
        }
        return sInstance;
    }

    public Observable<GoogleCustomSearchResponse> getGoogleResultsDataSource(String apiKey, String searchEngine, String query){
        return mApiService.getGoogleResults(apiKey,searchEngine,query);
    }

}
