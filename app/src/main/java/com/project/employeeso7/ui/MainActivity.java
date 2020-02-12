package com.project.employeeso7.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.project.employeeso7.R;
import com.project.employeeso7.databinding.ActivityMainBinding;
import com.project.employeeso7.ui.viewModel.MainActivityViewModel;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private NavController navController;
    private BottomNavigationView bottomNavigation;
    private MainActivityViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        MainActivityViewModel.Factory factory = new MainActivityViewModel.Factory(
                MainActivity.this.getApplication()
        );

        mViewModel = ViewModelProviders.of(this, factory).get(MainActivityViewModel.class);

        navController= Navigation.findNavController(this,R.id.fragment_container);
        bottomNavigation= findViewById(R.id.bottomNavigationView);
        NavigationUI.setupWithNavController(bottomNavigation,navController);
    }

    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(navController, (DrawerLayout) null);
    }

}
