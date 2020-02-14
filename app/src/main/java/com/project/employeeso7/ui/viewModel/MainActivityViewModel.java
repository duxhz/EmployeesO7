package com.project.employeeso7.ui.viewModel;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.project.employeeso7.EO7Application;
import com.project.employeeso7.model.Employee;
import com.project.employeeso7.model.Ratio;
import com.project.employeeso7.repository.EO7Repository;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class MainActivityViewModel extends AndroidViewModel {

    private EO7Repository mGuestRepository;
    private Context mAppContext;
    MutableLiveData<Boolean> addedSuccess = new MutableLiveData<>();
    MutableLiveData<List<Employee>> employeeList = new MutableLiveData<>();
    MutableLiveData<Float> avgAge = new MutableLiveData<Float>();
    MutableLiveData<Float> medAge = new MutableLiveData<>();
    MutableLiveData<Ratio> ratioItem = new MutableLiveData<>();
    MutableLiveData<Double> salaryItem = new MutableLiveData<>();
    private CompositeDisposable compositeDisposable;

    public MainActivityViewModel(@NonNull Application application, @NonNull EO7Repository guestRepository) {
        super(application);
        mAppContext=application.getApplicationContext();
        mGuestRepository=guestRepository;
        this.compositeDisposable= new CompositeDisposable();
    }

    //GET MAX SALARY
    public LiveData<Double> updateMaxSalary(){
        return salaryItem;
    }
    public void getMaxSalary(){
        mGuestRepository.getMaxSalary()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<Double>() {
                    @Override
                    public void onSuccess(Double aDouble) {
                        salaryItem.postValue(aDouble);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }

    //GET MEDIAN AGE
    public LiveData<Float> updateMedAge(){
        return medAge;
    }
    public void getMedAge(){
        mGuestRepository.getMedianAge()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<Float>() {
                    @Override
                    public void onSuccess(Float aFloat) {
                        medAge.postValue(aFloat);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }


    //GET RATIO
    public LiveData<Ratio> updateRatio(){
        return ratioItem;
    }
    public void getRatio(){
        mGuestRepository.getRatio()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<Ratio>() {
                    @Override
                    public void onSuccess(Ratio ratio) {
                        ratioItem.postValue(ratio);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }

    //GET AVERAGE AGE
    public LiveData<Float> updateAverageAge(){
        return avgAge;
    }
    public void getAverageAge(){
        mGuestRepository.getAverageAge()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<Float>() {
                    @Override
                    public void onSuccess(Float integer) {
                        avgAge.postValue(integer);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }

    //GET EMPLOYEES
    public LiveData<List<Employee>> updateEmployees(){
        return employeeList;
    }
    public void getEmployees(){
        mGuestRepository.getEmployeesRepository()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<List<Employee>>() {
                    @Override
                    public void onNext(List<Employee> employees) {
                        employeeList.postValue(employees);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    //INSERT EMPLOYEE
    public void insertEmployee(Employee employee){
        mGuestRepository.insertEmployeeRepository(employee);
    }


    @Override
    protected void onCleared() {
        if (compositeDisposable != null && !compositeDisposable.isDisposed())
            compositeDisposable.clear();
    }

    public static class Factory extends ViewModelProvider.NewInstanceFactory {
        @NonNull
        private final Application mApplication;

        private final EO7Repository mRepository;

        public Factory(@NonNull Application application) {
            mApplication = application;

            mRepository = ((EO7Application) application).getRepository();
        }

        @Override
        public <T extends ViewModel> T create(Class<T> modelClass) {
            //noinspection unchecked
            return (T) new MainActivityViewModel(mApplication, mRepository);
        }
    }
}
