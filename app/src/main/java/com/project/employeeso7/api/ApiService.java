package com.project.employeeso7.api;

import com.project.employeeso7.model.googleCustomSearch.GoogleCustomSearchResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("v1")
    Observable<GoogleCustomSearchResponse> getGoogleResults(
            @Query("key") String apiKey,
            @Query("cx") String searchEngine,
            @Query("q") String query
    );
}
