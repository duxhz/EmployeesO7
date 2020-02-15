package com.project.employeeso7.repository.remote;

import androidx.annotation.NonNull;

import com.project.employeeso7.model.googleCustomSearch.GoogleCustomSearchResponse;

import java.util.concurrent.Executor;

import io.reactivex.Observable;

public class ApiRepository {

    private static ApiRepository sInstance;

    private ApiDataSource apiDataSource;

    private Executor mExecutor;

    public ApiRepository(ApiDataSource mApiDataSource, Executor executor) {
        apiDataSource = mApiDataSource;
        mExecutor = executor;
    }

    public static ApiRepository getInstance(@NonNull ApiDataSource apiDataSource, Executor executor){
        if(sInstance==null){
            synchronized (ApiDataSource.class){
                if(sInstance==null){
                    sInstance= new ApiRepository(apiDataSource, executor);
                }
            }
        }
        return sInstance;
    }

    public Observable<GoogleCustomSearchResponse> getGoogleResultsRepository(String apiKey, String searchEngine, String query){
        return apiDataSource.getGoogleResultsDataSource(apiKey,searchEngine,query);
    }
}
