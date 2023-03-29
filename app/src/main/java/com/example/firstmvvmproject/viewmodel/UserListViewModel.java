package com.example.firstmvvmproject.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.firstmvvmproject.model.UserModel;
import com.example.firstmvvmproject.network.APIService;
import com.example.firstmvvmproject.network.RetroInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserListViewModel extends ViewModel {
    private MutableLiveData<List<UserModel>> userList;

    public UserListViewModel() {
        userList = new MutableLiveData<>();
    }

    public MutableLiveData<List<UserModel>> getUserListObserver(){
        return userList;
    }

    public void makeAPICall(){
        APIService apiService = RetroInstance.getRetroClient().create(APIService.class);
        Call<List<UserModel>> call = apiService.getUserList();
        call.enqueue(new Callback<List<UserModel>>() {
            @Override
            public void onResponse(Call<List<UserModel>> call, Response<List<UserModel>> response) {
                userList.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<UserModel>> call, Throwable t) {
                userList.postValue(null);
            }
        });
    }
}
