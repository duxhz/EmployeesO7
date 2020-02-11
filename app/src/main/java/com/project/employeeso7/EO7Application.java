package com.project.employeeso7;

import android.app.Application;
import android.content.Context;

import com.facebook.stetho.Stetho;
import com.project.employeeso7.db.AppDatabase;
import com.project.employeeso7.repository.EO7DataSource;
import com.project.employeeso7.repository.EO7Repository;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class EO7Application extends Application {
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();

        context=getApplicationContext();

        Stetho.initializeWithDefaults(this);
    }

    public EO7Repository getRepository(){
        return EO7Repository.getInstance(
                EO7DataSource.getInstance(getAppDataBase()),
                        getExecutor());
    }

    public Executor getExecutor(){
        return  Executors.newFixedThreadPool(2);
    }

    public AppDatabase getAppDataBase() {
        return AppDatabase.getInstance(this);
    }

    public static Context getAppContext() {
        return context;
    }


}
