package com.project.employeeso7.ui.view.home.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.employeeso7.R;
import com.project.employeeso7.model.Employee;

import java.util.List;

public class EmployeeListAdapter extends RecyclerView.Adapter<EmployeeListAdapter.EmployeeViewHolder> {

    List<Employee> employeesList;

    public EmployeeListAdapter(List<Employee> employeesList) {
        this.employeesList = employeesList;
    }

    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_employee, parent, false);
        return new EmployeeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder holder, int position) {
        Employee currentItem=employeesList.get(position);

        holder.name.setText(currentItem.getFirstName()+" "+currentItem.getLastName());
        holder.birthday.setText(currentItem.getBirthday());
        holder.gender.setText(currentItem.getGender());
        holder.salary.setText(String.valueOf(currentItem.getSalary()));
    }

    @Override
    public int getItemCount() {
        return employeesList.size();
    }

    public class EmployeeViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView birthday;
        TextView gender;
        TextView salary;

        public EmployeeViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.tv_employeeName);
            birthday=itemView.findViewById(R.id.tv_birthdate);
            gender=itemView.findViewById(R.id.tv_gender);
            salary=itemView.findViewById(R.id.tv_salary);
        }
    }
}
