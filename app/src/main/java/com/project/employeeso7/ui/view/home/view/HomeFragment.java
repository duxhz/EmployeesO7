package com.project.employeeso7.ui.view.home.view;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.project.employeeso7.R;
import com.project.employeeso7.databinding.FragmentHomeBinding;
import com.project.employeeso7.model.Employee;
import com.project.employeeso7.ui.view.home.adapter.EmployeeListAdapter;
import com.project.employeeso7.ui.viewModel.MainActivityViewModel;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

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

        return rootView;
    }

    private void observeEmployees() {
        mViewModel.updateEmployees().observe(getViewLifecycleOwner(), employees -> {
            employeeList=employees;
            adapter=new EmployeeListAdapter(employeeList);
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
}
