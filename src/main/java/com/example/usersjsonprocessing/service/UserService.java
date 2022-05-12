package com.example.usersjsonprocessing.service;

import com.example.usersjsonprocessing.entity.User;

import java.io.IOException;

public interface UserService {
    User save(User user) throws IOException, InterruptedException;
    void fillUserObject() throws IOException, InterruptedException;
}
