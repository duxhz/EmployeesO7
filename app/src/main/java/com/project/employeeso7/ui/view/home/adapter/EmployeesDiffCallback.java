package com.project.employeeso7.ui.view.home.adapter;

import androidx.recyclerview.widget.DiffUtil;

import com.project.employeeso7.model.Employee;

import java.util.List;

public class EmployeesDiffCallback extends DiffUtil.Callback {

    private final List<Employee> mOldEmployeeList;
    private final List<Employee> mNewEmployeeList;

    public EmployeesDiffCallback(List<Employee> oldEmployeeList, List<Employee> newEmployeeList) {
        this.mOldEmployeeList = oldEmployeeList;
        this.mNewEmployeeList = newEmployeeList;
    }

    @Override
    public int getOldListSize() {
        return mOldEmployeeList.size();
    }

    @Override
    public int getNewListSize() {
        return mNewEmployeeList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return mOldEmployeeList.get(oldItemPosition).getId() == mNewEmployeeList.get(
                newItemPosition).getId();
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return mOldEmployeeList.get(oldItemPosition).equals(mNewEmployeeList.get(newItemPosition));
    }

    /*@Nullable
    @Override
    public Object getChangePayload(int oldItemPosition, int newItemPosition) {
        // Implement method if you're going to use ItemAnimator
        return super.getChangePayload(oldItemPosition, newItemPosition);
    }*/
}