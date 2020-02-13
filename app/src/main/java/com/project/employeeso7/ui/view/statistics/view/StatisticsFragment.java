package com.project.employeeso7.ui.view.statistics.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

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

    FragmentStatisticsBinding binding;
    MainActivityViewModel mViewModel;
    View rootView;
    ArrayList<PieEntry> value= new ArrayList<>(2);
    float m,f;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_statistics,container,false);
        rootView= binding.getRoot();

        if(getActivity() != null){
            mViewModel = ViewModelProviders.of(getActivity()).get(MainActivityViewModel.class);
        }

        observeRatio();
        getRatio();
        ratioPieChart();

        return rootView;
    }

    private void observeRatio(){
        mViewModel.updateRatio().observe(getViewLifecycleOwner(), ratio -> {
            m=ratio.getMale_ratio();
            f=ratio.getFemale_ratio();
            /*binding.pcRatio.setUsePercentValues(true);
            if(value.size()<=2){
                value.add(0, new PieEntry(m, "Male"));
                value.add(1, new PieEntry(f, "Female"));
            }
            *//*if(value.size()<2) {

            }*//*
            PieDataSet dataSet= new PieDataSet(value, "");
            dataSet.setColors(getContext().getResources().getColor(R.color.colorPrimary),getContext().getResources().getColor(R.color.blue_app));
            PieData data= new PieData(dataSet);
            data.setValueFormatter(new PercentFormatter());
            binding.pcRatio.setData(data);
            Description desc= new Description();
            desc.setText("Gender Ratio");
            binding.pcRatio.setDescription(desc);
            Toast.makeText(getContext(), String.valueOf(value.size()), Toast.LENGTH_SHORT).show();*/
        });
    }

    private void getRatio(){
        mViewModel.getRatio();
    }

    private void ratioPieChart(){
            binding.pcRatio.setUsePercentValues(true);
        /*if(value.size()<=2){
            value.add(0, new PieEntry(m, "Male"));
            value.add(1, new PieEntry(f, "Female"));
        }*/
            value.add(0, new PieEntry(80.0f, "Male"));
            value.add(1, new PieEntry(20.0f, "Female"));
            PieDataSet dataSet= new PieDataSet(value, "");
            dataSet.setColors(getContext().getResources().getColor(R.color.colorPrimary),getContext().getResources().getColor(R.color.blue_app));
            PieData data= new PieData(dataSet);
            data.setValueFormatter(new PercentFormatter());
            binding.pcRatio.setData(data);
            Description desc= new Description();
            desc.setText("Gender Ratio");
            binding.pcRatio.setDescription(desc);
            Toast.makeText(getContext(), String.valueOf(value.size()), Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onResume() {
        super.onResume();
        getRatio();
    }
}
