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
import com.project.employeeso7.repository.EO7Repository;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class MainActivityViewModel extends AndroidViewModel {

    private EO7Repository mGuestRepository;
    private Context mAppContext;
    MutableLiveData<Boolean> addedSuccess = new MutableLiveData<>();
    MutableLiveData<List<Employee>> employeeList = new MutableLiveData<>();
    private CompositeDisposable compositeDisposable;

    public MainActivityViewModel(@NonNull Application application, @NonNull EO7Repository guestRepository) {
        super(application);
        mAppContext=application.getApplicationContext();
        mGuestRepository=guestRepository;
        this.compositeDisposable= new CompositeDisposable();
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
