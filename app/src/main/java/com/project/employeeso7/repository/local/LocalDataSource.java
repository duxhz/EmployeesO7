package com.project.employeeso7.repository.local;

import androidx.lifecycle.LiveData;

import com.project.employeeso7.db.AppDatabase;
import com.project.employeeso7.model.Employee;
import com.project.employeeso7.model.Ratio;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;

public class LocalDataSource {

    private static LocalDataSource sInstance;

    private LocalDataSource localGuestDataSource;

    private AppDatabase mAppDatabase;

    public LocalDataSource(AppDatabase appDatabase) {
        mAppDatabase = appDatabase;
    }

    public static LocalDataSource getInstance(AppDatabase appDatabase) {
        if (sInstance == null) {
            synchronized (LocalDataSource.class) {
                if (sInstance == null) {
                    sInstance = new LocalDataSource(appDatabase);
                }
            }
        }
        return sInstance;
    }

    public Single<Long> insertEmployeeDataSource(Employee employee) {
        return mAppDatabase.getEmployeeDAO().insert(employee);
    }

    public LiveData<List<Employee>> getEmployeesDataSource() {
        return mAppDatabase.getEmployeeDAO().getEmployees();
    }

    public LiveData<List<Employee>> getEmployeesDataSourceLD() {
        return mAppDatabase.getEmployeeDAO().getEmployeesLD();
    }


    public Single<Float> getAverageAge() {
        return mAppDatabase.getEmployeeDAO().getAverageAge();
    }

    public Single<Float> getMedianAge() {
        return mAppDatabase.getEmployeeDAO().getMedianAge();
    }

    public Single<Double> getMaxSalary() {
        return mAppDatabase.getEmployeeDAO().getMaxSalary();
    }


    public Single<Ratio> getRatio() {
        return mAppDatabase.getEmployeeDAO().getRatio();
    }


}
