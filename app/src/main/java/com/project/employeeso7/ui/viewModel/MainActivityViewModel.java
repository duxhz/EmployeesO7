package com.project.employeeso7.ui.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.project.employeeso7.EO7Application;
import com.project.employeeso7.model.Employee;
import com.project.employeeso7.model.Ratio;
import com.project.employeeso7.model.googleCustomSearch.GoogleCustomSearchResponse;
import com.project.employeeso7.model.googleCustomSearch.ItemsItem;
import com.project.employeeso7.repository.EO7Repository;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;


public class MainActivityViewModel extends AndroidViewModel {

    private EO7Repository mRepository;
    MutableLiveData<List<ItemsItem>> googleItem = new MutableLiveData<>();
    private CompositeDisposable compositeDisposable;

    public MainActivityViewModel(@NonNull Application application, @NonNull EO7Repository guestRepository) {
        super(application);
        mRepository =guestRepository;
        this.compositeDisposable= new CompositeDisposable();
    }

    //GOOGLE CUSTOM SEARCH JSON API
    public LiveData<List<ItemsItem>> updateSearchResults(){
        return googleItem;
    }
    public void getSearchResults(String apiKey, String searchEngine, String query){
        compositeDisposable.add(
        mRepository.getGoogleResultsRepository(apiKey,searchEngine,query)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<GoogleCustomSearchResponse>() {
                    @Override
                    public void onNext(GoogleCustomSearchResponse googleCustomSearchResponse) {
                        if(!googleCustomSearchResponse.getSearchInformation().getTotalResults().equals("0")){
                        List<ItemsItem> searchData=googleCustomSearchResponse.getItems();
                        googleItem.postValue(searchData);}
                        else{
                            List<ItemsItem> searchData2=new ArrayList<>();
                            googleItem.postValue(searchData2);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                }));
    }

    //GET MAX SALARY
    public LiveData<Double> getMaxSalaryLD(){
        return mRepository.getMaxSalaryLD();
    }


    //GET MEDIAN AGE
    public LiveData<Float> getMedAge(){
        return mRepository.getMedianAgeLD();
    }

    //GET RATIO
    public LiveData<Ratio> updateRatioLD(){
        return mRepository.getRatioLD();
    }

    //GET AVERAGE AGE
    public LiveData<Float> getAverageAgeLD(){
        return mRepository.getAverageAgeLD();
    }

    //GET EMPLOYEES
    public LiveData<List<Employee>> getEmployeesLD(){
        return mRepository.getEmployeesRepositoryLD();
    }

    //INSERT EMPLOYEE
    public void insertEmployee(Employee employee){
        compositeDisposable.add(
                mRepository.insertEmployeeRepository(employee)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(new DisposableSingleObserver<Long>() {
                            @Override
                            public void onSuccess(Long aLong) {

                            }

                            @Override
                            public void onError(Throwable e) {

                            }
                        }));
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
