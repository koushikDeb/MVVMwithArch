package com.example.mvvmsample.notes.repo;

import androidx.lifecycle.MutableLiveData;

import com.example.mvvmsample.notes.model.User;

import java.util.ArrayList;

public class LoadUserrepo {

    public void populateList(MutableLiveData<ArrayList<User>> users) {
        User user = new User();
        user.setTitle("User Added:: "+users.getValue().size());
        user.setDescription("LiveData testing ");
        ArrayList<User> userlist = users.getValue();
        userlist.add(user);
        users.setValue(userlist);
    }
}
