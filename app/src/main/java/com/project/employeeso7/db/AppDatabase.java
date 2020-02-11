package com.project.employeeso7.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.project.employeeso7.db.dao.EmployeesDAO;
import com.project.employeeso7.model.Employee;

@Database(entities = {Employee.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase sInstance;
    private static final String DATABASE_NAME="employees_db";

    public static synchronized AppDatabase getInstance(Context context) {
        if(sInstance == null){
            synchronized (AppDatabase.class){
                if(sInstance == null){
                    sInstance= Room.databaseBuilder(context.getApplicationContext(),AppDatabase.class,DATABASE_NAME).build();
                }
            }
        }
        return sInstance;
    }
    public abstract EmployeesDAO getEmployeeDAO();
}
