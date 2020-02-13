package com.project.employeeso7.repository;

import androidx.annotation.NonNull;

import com.project.employeeso7.model.Employee;
import com.project.employeeso7.model.Ratio;

import java.util.List;
import java.util.concurrent.Executor;

import io.reactivex.Observable;
import io.reactivex.Single;

public class EO7Repository {

    private static EO7Repository sInstance;

    private EO7DataSource localGuestDataSource;

    private Executor mExecutor;

    public EO7Repository(@NonNull EO7DataSource localGuestDataSource, Executor executor) {
        this.localGuestDataSource = localGuestDataSource;
        mExecutor = executor;
    }

    public static EO7Repository getInstance(@NonNull EO7DataSource localDataSource, Executor executor){
        if(sInstance == null){
            synchronized (EO7Repository.class){
                if(sInstance == null){
                    sInstance= new EO7Repository(localDataSource,executor);
                }
            }
        }
        return sInstance;
    }

    public void insertEmployeeRepository(final Employee employee) {
        mExecutor.execute(() -> {
            localGuestDataSource.insertEmployeeDataSource(employee);
        });
    }

    public Observable<List<Employee>> getEmployeesRepository(){
        return localGuestDataSource.getEmployeesDataSource();
    }

    public Single<Integer> getAverageAge(){
        return localGuestDataSource.getAverageAge();
    }

    public Single<String> getMedianAge(){
        return localGuestDataSource.getMedianAge();
    }

    public Single<Ratio> getRatio(){
        return localGuestDataSource.getRatio();
    }

}
