package com.project.employeeso7.repository;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import com.project.employeeso7.model.Employee;
import com.project.employeeso7.model.Ratio;
import com.project.employeeso7.model.googleCustomSearch.GoogleCustomSearchResponse;
import com.project.employeeso7.repository.local.LocalDataSource;
import com.project.employeeso7.repository.remote.ApiDataSource;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;

public class EO7Repository {

    private static EO7Repository sInstance;

    private LocalDataSource mLocalGuestDataSource;
    private ApiDataSource mApiDataSource;

    public EO7Repository(@NonNull LocalDataSource localGuestDataSource, ApiDataSource apiDataSource) {
        mLocalGuestDataSource = localGuestDataSource;
        mApiDataSource = apiDataSource;
    }

    public static EO7Repository getInstance(@NonNull LocalDataSource localDataSource, ApiDataSource apiDataSource){
        if(sInstance == null){
            synchronized (EO7Repository.class){
                if(sInstance == null){
                    sInstance= new EO7Repository(localDataSource,apiDataSource);
                }
            }
        }
        return sInstance;
    }

    public Single<Long> insertEmployeeRepository(final Employee employee) {
       return mLocalGuestDataSource.insertEmployeeDataSource(employee);
    }

    public LiveData<List<Employee>> getEmployeesRepository(){
        return mLocalGuestDataSource.getEmployeesDataSource();
    }

    public LiveData<List<Employee>> getEmployeesRepositoryLD(){
        return mLocalGuestDataSource.getEmployeesDataSourceLD();
    }


    public Single<Float> getAverageAge(){
        return mLocalGuestDataSource.getAverageAge();
    }

    public Single<Float> getMedianAge(){
        return mLocalGuestDataSource.getMedianAge();
    }

    public Single<Double> getMaxSalary(){
        return mLocalGuestDataSource.getMaxSalary();
    }

    public Single<Ratio> getRatio(){
        return mLocalGuestDataSource.getRatio();
    }

    public Observable<GoogleCustomSearchResponse> getGoogleResultsRepository(String apiKey, String searchEngine, String query){
        return mApiDataSource.getGoogleResultsDataSource(apiKey,searchEngine,query);
    }

}
