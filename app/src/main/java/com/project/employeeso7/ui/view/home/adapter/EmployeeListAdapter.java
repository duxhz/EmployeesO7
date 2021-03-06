package com.project.employeeso7.ui.view.home.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.project.employeeso7.R;
import com.project.employeeso7.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeListAdapter extends RecyclerView.Adapter<EmployeeListAdapter.EmployeeViewHolder> {

    private List<Employee> employeesList;
    private List<Employee> employeeListFull;
    private ClickListener mClickListener;

    public EmployeeListAdapter(List<Employee> employeesList, ClickListener clickListener) {
        this.employeesList = employeesList;
        employeeListFull = new ArrayList<>(employeesList);
        mClickListener = clickListener;
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
        Employee currentItem = employeesList.get(position);

            holder.name.setText(currentItem.getFirstName() + " " + currentItem.getLastName());
            holder.birthday.setText(currentItem.getBirthday());
            holder.gender.setText(currentItem.getGender());
            holder.salary.setText(String.valueOf(currentItem.getSalary()));

    }

    @Override
    public int getItemCount() {
        return employeesList.size();
    }

    public void updateEmployeeListItems(List<Employee> employees) {
        final EmployeesDiffCallback diffCallback = new EmployeesDiffCallback(this.employeesList, employees);
        final DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(diffCallback);

        this.employeesList.clear();
        this.employeesList.addAll(employees);
        employeeListFull.clear();
        employeeListFull.addAll(employees);

        diffResult.dispatchUpdatesTo(this);
    }

    public class EmployeeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView name;
        TextView birthday;
        TextView gender;
        TextView salary;
        ClickListener clkListener;

        public EmployeeViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tv_employeeName);
            birthday = itemView.findViewById(R.id.tv_birthdate);
            gender = itemView.findViewById(R.id.tv_gender);
            salary = itemView.findViewById(R.id.tv_salary);

            clkListener = mClickListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            mClickListener.googleSearch(getAdapterPosition());
        }
    }

    public Filter getFilter() {
        return homeFilter;
    }

    private Filter homeFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Employee> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(employeeListFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (Employee item : employeeListFull) {
                    String fullName = item.getFirstName().toLowerCase() + " " + item.getLastName().toLowerCase();
                    String fullName2 = item.getLastName().toLowerCase() + " " +item.getFirstName().toLowerCase();
                    if (fullName.contains(filterPattern) || fullName2.contains(filterPattern) || item.getGender().toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            employeesList.clear();
            employeesList.addAll((List) results.values);
            notifyDataSetChanged();
            mClickListener.searchResults(employeesList.size(), constraint.toString());
        }
    };

    public interface ClickListener {
        void searchResults(int size, String query);
        void googleSearch(int position);
    }
}
