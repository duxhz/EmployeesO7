package com.project.employeeso7.db.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.project.employeeso7.model.Employee;
import com.project.employeeso7.model.Ratio;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;

@Dao
public interface EmployeesDAO {

    @Insert
    void insert(Employee... employees);

    @Query("SELECT * FROM employees")
    Observable<List<Employee>> getEmployees();

    @Query("SELECT * FROM employees WHERE id = :id")
    Employee getEmployeeById(Long id);

    @Query("SELECT AVG(date('now')-date(birthday)) FROM employees")
    Single<Float> getAverageAge();

    @Query("SELECT AVG(date('now')-date(birthday)) FROM(SELECT birthday FROM employees ORDER BY birthday LIMIT 2 - (SELECT COUNT(*) FROM employees) % 2 OFFSET (SELECT (COUNT(*) - 1) / 2 FROM employees))")
    Single<Float> getMedianAge();

    @Query("SELECT MAX(salary) FROM employees")
    Single<Double> getMaxSalary();

    @Query("SELECT 100*sum(case when gender='Male' then 1 else 0 end)/count(*) as male_ratio, 100*sum(case when gender='Female' then 1 else 0 end)/count(*) as female_ratio from employees")
    Single<Ratio> getRatio();

}
