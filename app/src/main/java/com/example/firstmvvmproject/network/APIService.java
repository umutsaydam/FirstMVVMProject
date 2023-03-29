package com.example.firstmvvmproject.network;

import com.example.firstmvvmproject.model.UserModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {
    @GET("/todos/")
    Call<List<UserModel>> getUserList();
}
