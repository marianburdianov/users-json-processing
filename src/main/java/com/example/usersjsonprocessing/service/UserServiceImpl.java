package com.example.usersjsonprocessing.service;

import com.example.usersjsonprocessing.dao.UserDao;
import com.example.usersjsonprocessing.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    @Override
    public User save(User user) {
        return userDao.save(user);
    }
}
