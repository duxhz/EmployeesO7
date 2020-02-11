package com.project.employeeso7.db.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.project.employeeso7.model.Employee;

import java.util.List;

import io.reactivex.Observable;

@Dao
public interface EmployeesDAO {

    @Insert
    void insert(Employee... employees);

    @Query("SELECT * FROM employees")
    Observable<List<Employee>> getEmployees();

    @Query("SELECT * FROM employees WHERE id = :id")
    Employee getEmployeeById(Long id);
}
