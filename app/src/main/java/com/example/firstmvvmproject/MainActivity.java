package com.example.firstmvvmproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.firstmvvmproject.adapter.UserListAdapter;
import com.example.firstmvvmproject.model.UserModel;
import com.example.firstmvvmproject.viewmodel.UserListViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recycler;
    private List<UserModel> userModelList;
    private UserListAdapter adapter;
    private UserListViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycler = findViewById(R.id.recycler);
        adapter = new UserListAdapter(this, userModelList);
        recycler.setAdapter(adapter);

        viewModel = ViewModelProviders.of(this).get(UserListViewModel.class);
        viewModel.getUserListObserver().observe(this, new Observer<List<UserModel>>() {
            @Override
            public void onChanged(List<UserModel> userModels) {
                if (userModels != null){
                    userModelList = userModels;
                    adapter.setUserModelList(userModels);
                }
            }
        });
        viewModel.makeAPICall();
    }
}