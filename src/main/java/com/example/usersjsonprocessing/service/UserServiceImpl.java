package com.example.usersjsonprocessing.service;

import com.example.usersjsonprocessing.dao.UserDao;
import com.example.usersjsonprocessing.entity.User;
import com.example.usersjsonprocessing.processor.ResponseInstanceProcessor;
import com.example.usersjsonprocessing.validator.EmailValidator;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    private final UserDao userDao;
    private final ResponseInstanceProcessor responseInstanceProcessor;

    private final EmailValidator emailValidator;

    @Override
    public User save(User user) {
        return userDao.save(user);
    }

    @Override
    public void fillUserObject() throws IOException, InterruptedException {
        User updatedUser = new User();
        for (Object o : responseInstanceProcessor.getJsonBodyAsJsonArray()) {

            Gson json = new Gson();
            User user = json.fromJson(o.toString(), User.class);

            updatedUser.setId(user.getId());
            updatedUser.setName(user.getName());
            updatedUser.setUsername(user.getUsername());
            updatedUser.setEmail(user.getEmail());
            updatedUser.setPhone(user.getPhone());
            updatedUser.setWebsite(user.getWebsite());

            save(updatedUser);

            String email = user.getEmail();
            boolean isValid = emailValidator.isEmailValid(email);
            if (!isValid) {
                logger.info("This email is not valid " + email);
            }

            int count = responseInstanceProcessor.getCountOfObjectsFromRequestedJson();
            if (!(count == 10)) {
                logger.info("This json is not valid");
            }

        }
    }
}
