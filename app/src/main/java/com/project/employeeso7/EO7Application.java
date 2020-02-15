package com.project.employeeso7;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.project.employeeso7.api.ApiService;
import com.project.employeeso7.api.RetrofitClient;
import com.project.employeeso7.db.AppDatabase;
import com.project.employeeso7.repository.local.EO7DataSource;
import com.project.employeeso7.repository.local.EO7Repository;
import com.project.employeeso7.repository.remote.ApiDataSource;
import com.project.employeeso7.repository.remote.ApiRepository;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class EO7Application extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Stetho.initializeWithDefaults(this);
    }

    public EO7Repository getRepository(){
        return EO7Repository.getInstance(
                EO7DataSource.getInstance(getAppDataBase()),
                        getExecutor());
    }

    public ApiRepository getApiRepository(){
        return ApiRepository.getInstance(ApiDataSource.getInstance(getAppService()),getExecutor());
    }


    public Executor getExecutor(){
        return  Executors.newFixedThreadPool(2);
    }

    public AppDatabase getAppDataBase() {
        return AppDatabase.getInstance(this);
    }

    public ApiService getAppService(){
        return RetrofitClient.getRetrofitInstance().create(ApiService.class);
    }



}
