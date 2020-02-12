package com.project.employeeso7.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "employees")
public class Employee {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    private long id;

    @ColumnInfo(name="firstName")
    private String firstName;

    @ColumnInfo(name="lastName")
    private String lastName;

    @ColumnInfo(name="birthday")
    private String birthday;

    @ColumnInfo(name="gender")
    private String gender;

    @ColumnInfo(name="salary")
    private double salary;

    @ColumnInfo(name="age")
    private String age;

    public Employee(String firstName, String lastName, String birthday, String gender, double salary, String age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.gender = gender;
        this.salary = salary;
        this.age=age;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
