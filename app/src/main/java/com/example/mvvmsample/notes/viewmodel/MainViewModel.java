package com.example.mvvmsample.notes.viewmodel;

import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.mvvmsample.notes.model.User;
import com.example.mvvmsample.notes.repo.LoadUserrepo;

import java.util.ArrayList;


public class MainViewModel extends ViewModel{
    LoadUserrepo ls = new LoadUserrepo();
    public MainViewModel() {
        users = new MutableLiveData<ArrayList<User>>();
        users.setValue(new ArrayList<User>());
    }
    private MutableLiveData<ArrayList<User>> users;
    public LiveData<ArrayList<User>> getUsers() {
        ls.populateList(users);
        return users;
    }

    public void buttonclicked()
    {
      getUsers();
    }
}
