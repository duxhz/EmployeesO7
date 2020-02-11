package com.project.employeeso7.ui.viewModel;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.project.employeeso7.model.Employee;
import com.project.employeeso7.repository.EO7Repository;

import java.util.List;

import io.reactivex.disposables.CompositeDisposable;

public class MainActivityViewModel extends AndroidViewModel {

    private EO7Repository mGuestRepository;
    private Context mAppContext;
    MutableLiveData<Boolean> addedSuccess = new MutableLiveData<>();
    MutableLiveData<List<Employee>> employeeList = new MutableLiveData<>();
    private CompositeDisposable compositeDisposable;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
    }
}
