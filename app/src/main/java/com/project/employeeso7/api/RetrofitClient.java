package com.project.employeeso7.api;

import com.facebook.stetho.okhttp3.StethoInterceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public abstract class RetrofitClient {
    private static Retrofit retrofit;
    private static final String BASE_URL = "https://www.googleapis.com/customsearch/";

    public static synchronized Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            synchronized (RetrofitClient.class) {
                if (retrofit == null) {

                    OkHttpClient.Builder okHttpClient = new OkHttpClient().newBuilder()
                            .connectTimeout(60, TimeUnit.SECONDS)
                            .readTimeout(60, TimeUnit.SECONDS)
                            .writeTimeout(60, TimeUnit.SECONDS);

                    okHttpClient.addNetworkInterceptor(new StethoInterceptor());

                    retrofit = new retrofit2.Retrofit.Builder()
                            .baseUrl(BASE_URL)
                            .client(okHttpClient.build())
                            .addConverterFactory(GsonConverterFactory.create())
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .build();
                }
            }
        }
        return retrofit;
    }
}
