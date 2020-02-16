package com.project.employeeso7.ui.view.statistics.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.project.employeeso7.R;
import com.project.employeeso7.databinding.FragmentStatisticsBinding;
import com.project.employeeso7.ui.viewModel.MainActivityViewModel;

import java.util.ArrayList;

public class StatisticsFragment extends Fragment {

    private FragmentStatisticsBinding binding;
    private MainActivityViewModel mViewModel;
    private View rootView;
    private ArrayList<PieEntry> value = new ArrayList<>();
    private float m, f;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_statistics, container, false);
        rootView = binding.getRoot();

        if (getActivity() != null) {
            mViewModel = ViewModelProviders.of(getActivity()).get(MainActivityViewModel.class);
        }

        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        observeRatio();
        getMedAge();
        getAvgAge();
        getMaxSalary();
    }

    private void getAvgAge() {
        mViewModel.getAverageAgeLD().observe(getViewLifecycleOwner(),aFloat -> {
            if(aFloat!=null){
            binding.tvAvgAge.setText(String.valueOf(aFloat));
            }
            else{
                binding.tvAvgAge.setText(getText(R.string.no_data));
            }
        });
    }

    private void getMaxSalary() {
        mViewModel.getMaxSalaryLD().observe(getViewLifecycleOwner(), aDouble -> {
            if(aDouble!=null) {
                binding.tvMaxSalary.setText(String.valueOf(aDouble) + getText(R.string.euro_sign));
            }
            else{
                binding.tvMaxSalary.setText(getText(R.string.no_data));
            }
        });
    }

    private void getMedAge() {
        mViewModel.getMedAge().observe(getViewLifecycleOwner(),aFloat -> {
            if(aFloat!=null) {
                binding.tvMedAge.setText(String.valueOf(aFloat));
            }
            else{
                binding.tvMedAge.setText(getText(R.string.no_data));
            }
        });
    }

    private void observeRatio() {
        mViewModel.updateRatioLD().observe(getViewLifecycleOwner(), ratio -> {
            m = ratio.getMale_ratio();
            f = ratio.getFemale_ratio();
            ratioPieChart();
        });
    }

    private void ratioPieChart() {
        binding.pcRatio.setUsePercentValues(true);
        if (value.size() < 2) {
            value.add(new PieEntry(m, "Male"));
            value.add(new PieEntry(f, "Female"));
        } else {
            value.set(0, new PieEntry(m, "Male"));
            value.set(1, new PieEntry(f, "Female"));
        }
        PieDataSet dataSet = new PieDataSet(value, "");
        dataSet.setColors(getContext().getResources().getColor(R.color.colorPrimary), getContext().getResources().getColor(R.color.blue_app));
        PieData data = new PieData(dataSet);
        data.setValueFormatter(new PercentFormatter());
        binding.pcRatio.setData(data);
        Description desc = new Description();
        desc.setText("Gender Ratio");
        binding.pcRatio.setDescription(desc);
        binding.pcRatio.invalidate();
    }
}
