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

    @Query("SELECT AVG(age) as average FROM employees")
    Single<Integer> getAverageAge();

    @Query("SELECT AVG(age) FROM(SELECT age FROM employees ORDER BY age LIMIT 2 - (SELECT COUNT(*) FROM employees) % 2 OFFSET (SELECT (COUNT(*) - 1) / 2 FROM employees))")
    Single<String> getMedianAge();

  /*  @Query("SELECT MAX(salary) FROM employees")
    Single<String> */

    @Query("SELECT sum(case when gender='Male' then 1 else 0 end)/count(*) as male_ratio, sum(case when gender='Female' then 1 else 0 end)/count(*) as female_ratio from employees")
    Single<Ratio> getRatio();

}
