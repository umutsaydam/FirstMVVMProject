package com.example.firstmvvmproject.model;

public class UserModel {
    private String title;
    private String  completed;

    public UserModel(String title, String completed) {
        this.title = title;
        this.completed = completed;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String isCompleted() {
        return completed;
    }

    public void setCompleted(String completed) {
        this.completed = completed;
    }
}
