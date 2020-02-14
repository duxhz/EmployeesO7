package com.project.employeeso7.repository;

import com.project.employeeso7.db.AppDatabase;
import com.project.employeeso7.model.Employee;
import com.project.employeeso7.model.Ratio;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;

public class EO7DataSource {

    private static EO7DataSource sInstance;

    private EO7DataSource localGuestDataSource;

    private AppDatabase mAppDatabase;

    public EO7DataSource(AppDatabase appDatabase) {
        mAppDatabase = appDatabase;
    }

    public static EO7DataSource getInstance(AppDatabase appDatabase){
        if(sInstance == null){
            synchronized (EO7DataSource.class){
                if(sInstance == null){
                    sInstance= new EO7DataSource(appDatabase);
                }
            }
        }
        return sInstance;
    }

    public void insertEmployeeDataSource(Employee employee) {
        mAppDatabase.getEmployeeDAO().insert(employee);
    }

    public Observable<List<Employee>> getEmployeesDataSource() {
        return mAppDatabase.getEmployeeDAO().getEmployees();
    }

    public Single<Float> getAverageAge(){
        return mAppDatabase.getEmployeeDAO().getAverageAge();
    }

    public Single<Float> getMedianAge(){
        return mAppDatabase.getEmployeeDAO().getMedianAge();
    }

    public Single<Double> getMaxSalary(){
        return mAppDatabase.getEmployeeDAO().getMaxSalary();
    }


    public Single<Ratio> getRatio(){
        return mAppDatabase.getEmployeeDAO().getRatio();
    }


}
