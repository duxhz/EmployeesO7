package com.project.employeeso7;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.project.employeeso7.api.ApiService;
import com.project.employeeso7.api.RetrofitClient;
import com.project.employeeso7.db.AppDatabase;
import com.project.employeeso7.repository.EO7Repository;
import com.project.employeeso7.repository.local.LocalDataSource;
import com.project.employeeso7.repository.remote.ApiDataSource;

public class EO7Application extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Stetho.initializeWithDefaults(this);
    }

    public EO7Repository getRepository(){
        return EO7Repository.getInstance(
                LocalDataSource.getInstance(getAppDataBase()),
                ApiDataSource.getInstance(getAppService())
        );
    }

    public AppDatabase getAppDataBase() {
        return AppDatabase.getInstance(this);
    }

    public ApiService getAppService(){
        return RetrofitClient.getRetrofitInstance().create(ApiService.class);
    }



}
