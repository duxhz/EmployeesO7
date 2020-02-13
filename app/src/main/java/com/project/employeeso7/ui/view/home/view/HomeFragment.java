package com.project.employeeso7.ui.view.home.view;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;

import androidx.appcompat.widget.SearchView;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;
import com.project.employeeso7.R;
import com.project.employeeso7.databinding.FragmentHomeBinding;
import com.project.employeeso7.model.Employee;
import com.project.employeeso7.ui.view.home.adapter.EmployeeListAdapter;
import com.project.employeeso7.ui.viewModel.MainActivityViewModel;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements EmployeeListAdapter.ClickListener {

    FragmentHomeBinding binding;
    MainActivityViewModel mViewModel;
    View rootView;
    List<Employee> employeeList=new ArrayList<>();
    EmployeeListAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_home,container,false);
        rootView= binding.getRoot();

        if(getActivity() != null){
            mViewModel = ViewModelProviders.of(getActivity()).get(MainActivityViewModel.class);
        }

        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getContext());
        binding.rvList.setLayoutManager(layoutManager);

        observeEmployees();
        updateEmployees();
        initSearch();

        return rootView;
    }

    private void initSearch(){
        binding.searchViewHome.setImeOptions(EditorInfo.IME_ACTION_DONE);
        queryListener();
    }

    private boolean queryListener() {
        binding.searchViewHome.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }

    private void observeEmployees() {
        mViewModel.updateEmployees().observe(getViewLifecycleOwner(), employees -> {
            employeeList=employees;
            adapter=new EmployeeListAdapter(employeeList,this);
            binding.rvList.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        });
    }

    private void updateEmployees(){
        mViewModel.getEmployees();
    }

    @Override
    public void onResume() {
        super.onResume();
        updateEmployees();
    }

    @Override
    public void searchResults(int size,String constraint) {
        Snackbar snackbar = Snackbar
                .make(getView() , "Search results: "+String.valueOf(size)+"\nfor query: "+constraint.toString(), Snackbar.LENGTH_SHORT);
        snackbar.show();
    }
}
