package com.example.mvvmsample.notes.ui;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvmsample.R;
import com.example.mvvmsample.databinding.ActivityMainBinding;
import com.example.mvvmsample.notes.adapter.RecyclerViewAdapter;
import com.example.mvvmsample.notes.model.User;
import com.example.mvvmsample.notes.viewmodel.MainViewModel;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements LifecycleOwner {

    MainActivity context;
    RecyclerView recyclerView;
    RecyclerViewAdapter recyclerViewAdapter;
    MainViewModel model;
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        recyclerView = binding.rvMain;
        model = new ViewModelProvider(this).get(MainViewModel.class);
        model.getUsers().observe(this, new Observer<ArrayList<User>>() {
            @Override
            public void onChanged(ArrayList<User> users) {

                recyclerViewAdapter = new RecyclerViewAdapter(MainActivity.this,users);
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                recyclerView.setAdapter(recyclerViewAdapter);
                recyclerViewAdapter.notifyDataSetChanged();

            }
        });
    }


}
