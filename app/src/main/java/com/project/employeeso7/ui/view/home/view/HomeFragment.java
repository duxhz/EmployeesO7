package com.project.employeeso7.ui.view.home.view;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.EditorInfo;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
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
import com.project.employeeso7.model.googleCustomSearch.ItemsItem;
import com.project.employeeso7.ui.view.home.adapter.EmployeeListAdapter;
import com.project.employeeso7.ui.view.home.adapter.PublicProfileAdapter;
import com.project.employeeso7.ui.viewModel.MainActivityViewModel;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements EmployeeListAdapter.ClickListener {

    private FragmentHomeBinding binding;
    private MainActivityViewModel mViewModel;
    private View rootView;
    private List<Employee> employeeList = new ArrayList<>();
    private List<ItemsItem> searchList = new ArrayList<>();
    private EmployeeListAdapter adapter;
    private PublicProfileAdapter adapter2;
    private RecyclerView recyclerView2;

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        rootView = binding.getRoot();

        if (getActivity() != null) {
            mViewModel = ViewModelProviders.of(getActivity()).get(MainActivityViewModel.class);
        }

        setupRecyclerView();
        initSearch();

        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getEmployees();
    }

    private void setupRecyclerView() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        binding.rvList.setLayoutManager(layoutManager);

        adapter = new EmployeeListAdapter(employeeList, this);
        binding.rvList.setAdapter(adapter);
    }

    private void observeSearchResults() {
        mViewModel.updateSearchResults().observe(getViewLifecycleOwner(), itemsItems -> {
                searchList = itemsItems;
                adapter2 = new PublicProfileAdapter(searchList);
                recyclerView2.setAdapter(adapter2);
                adapter2.notifyDataSetChanged();
             });
    }

    private void getSearchResults(String query) {
        mViewModel.getSearchResults(getString(R.string.api_key), getString(R.string.search_engine_key), query);
    }

    private void initSearch() {
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

    private void getEmployees() {
        mViewModel.getEmployeesLD().observe(getViewLifecycleOwner(), employees -> {
            employeeList = employees;
            adapter.updateEmployeeListItems(employees);
        });
    }

    @Override
    public void searchResults(int size, String constraint) {
        Snackbar snackbar = Snackbar
                .make(getView(), "Search results: " + size + "\nfor query: " + constraint, Snackbar.LENGTH_SHORT);
        snackbar.show();
    }

    public void searchResultsDialog() {
        AlertDialog.Builder alert;

        alert = new AlertDialog.Builder(getContext());

        LayoutInflater inflater = getLayoutInflater();

        View view = inflater.inflate(R.layout.dialog_public_profile, null);

        ImageView cancel = view.findViewById(R.id.iv_cancel);
        recyclerView2 = view.findViewById(R.id.recyclerView_search);

        alert.setView(view);
        alert.setCancelable(true);

        RecyclerView.LayoutManager layoutManager2 = new LinearLayoutManager(getContext());
        recyclerView2.setLayoutManager(layoutManager2);
        observeSearchResults();

        AlertDialog alertDialog = alert.create();
        alertDialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        alertDialog.show();

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.cancel();
            }
        });
    }

    @Override
    public void googleSearch(int position) {
        getSearchResults(employeeList.get(position).getFirstName());
        searchResultsDialog();
    }

}
