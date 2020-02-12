package com.project.employeeso7.ui.view.employeeForm.view;


import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.project.employeeso7.R;
import com.project.employeeso7.databinding.FragmentEmployeeFormBinding;
import com.project.employeeso7.model.Employee;
import com.project.employeeso7.ui.viewModel.MainActivityViewModel;

import java.util.Calendar;

public class EmployeeFragment extends Fragment {

    FragmentEmployeeFormBinding binding;
    MainActivityViewModel mViewModel;
    View rootView;
    private int mYear, mMonth, mDay;
    String age1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_employee_form,container,false);
        rootView= binding.getRoot();

        if(getActivity() != null){
            mViewModel = ViewModelProviders.of(getActivity()).get(MainActivityViewModel.class);
        }

        insertEmployee();
        openCalendar();

        return rootView;
    }

    private void insertEmployee(){
        binding.btnAdd.setOnClickListener(v -> {
            if(!validateFirstName() | !validateLastName() | !validateBirthday() | !validateSalary()){
                return;
            }
            else{
            Employee employee= new Employee(binding.etFirstName.getText().toString(),
                    binding.etLastname.getText().toString(),
                    binding.etBirthday.getText().toString(),
                    binding.spinnerGender.getSelectedItem().toString(),
                    Double.parseDouble(binding.etSalary.getText().toString()),
                    age1);
            mViewModel.insertEmployee(employee);
            clearInput();
            }
        });
    }

    private void clearInput(){
        binding.etSalary.getText().clear();
        binding.etLastname.getText().clear();
        binding.etFirstName.getText().clear();
        binding.etBirthday.getText().clear();
        age1="";
    }

    private boolean validateFirstName(){
        if(binding.etFirstName.getText().toString().isEmpty()){
            binding.etFirstName.setError(getText(R.string.empty_field));
            return false;
        }
        else{
            binding.etFirstName.setError(null);
            return true;
        }
    }

    private boolean validateLastName(){
        if(binding.etLastname.getText().toString().isEmpty()){
            binding.etLastname.setError(getText(R.string.empty_field));
            return false;
        }
        else{
            binding.etLastname.setError(null);
            return true;
        }
    }

    private boolean validateBirthday(){
        if(binding.etBirthday.getText().toString().isEmpty()){
            binding.etBirthday.setError(getText(R.string.empty_field));
            return false;
        }
        else{
            binding.etBirthday.setError(null);
            return true;
        }
    }

    private boolean validateSalary(){
        if(binding.etSalary.getText().toString().isEmpty()){
            binding.etSalary.setError(getText(R.string.empty_field));
            return false;
        }
        else{
            binding.etSalary.setError(null);
            return true;
        }
    }

    private String getAge(int year, int month, int day){
        Calendar dob = Calendar.getInstance();
        Calendar today = Calendar.getInstance();

        dob.set(year, month, day);

        int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);

        if (today.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR)){
            age--;
        }

        Integer ageInt = new Integer(age);
        String ageS = ageInt.toString();

        return ageS;
    }

    private void openCalendar(){
        binding.ivCalendar.setOnClickListener(v -> {

            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(),
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {

                            String monthString = String.valueOf(monthOfYear + 1);
                            String dayString = String.valueOf(dayOfMonth);
                            if (monthString.length() == 1) {
                                monthString = "0" + monthString;
                            }
                            if (dayString.length() == 1) {
                                dayString = "0" + dayString;
                            }

                            binding.etBirthday.setText(dayString + "-" + (monthString) + "-" + year);
                            age1=getAge(year,Integer.parseInt(monthString),Integer.parseInt(dayString));
                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        });


}
}
