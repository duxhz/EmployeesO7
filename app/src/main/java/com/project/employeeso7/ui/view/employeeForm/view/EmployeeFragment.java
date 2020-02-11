package com.project.employeeso7.ui.view.employeeForm.view;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.project.employeeso7.R;
import com.project.employeeso7.databinding.FragmentEmployeeFormBinding;

public class EmployeeFragment extends Fragment {

    FragmentEmployeeFormBinding binding;
    View rootView;
    Spinner spinner;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_employee_form,container,false);
        rootView= binding.getRoot();

        /*spinner=rootView.findViewById(R.id.spinner_gender);
        ArrayAdapter<CharSequence> adapter= ArrayAdapter.createFromResource(getContext(), R.array.gender, R.layout.spinner_gender_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);*/

        return rootView;
    }

    private void selectGender(){
        binding.spinnerGender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

}
