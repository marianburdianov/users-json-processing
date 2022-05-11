package com.example.usersjsonprocessing.controller;

import com.example.usersjsonprocessing.entity.User;
import com.example.usersjsonprocessing.http.*;
import com.example.usersjsonprocessing.processor.ResponseInstanceProcessor;
import com.example.usersjsonprocessing.service.UserService;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final ResponseInstanceProcessor responseInstanceProcessor;
    private final UserService userService;

    @GetMapping("/users")
    void processUsers() throws IOException, InterruptedException {
        HttpClientInstance httpClientInstance = new HttpClientInstanceImpl();
        HttpRequestInstance httpRequestInstance = new HttpRequestInstanceImpl();
        HttpResponseInstance httpResponseInstance = new HttpResponseInstanceImpl(httpClientInstance, httpRequestInstance);
        httpResponseInstance.getHttpResponseInstance();
        System.out.println(httpResponseInstance.getHttpResponseInstance().body());
        System.out.println(httpResponseInstance.getHttpResponseInstance().statusCode());

        for (Object o : responseInstanceProcessor.getJsonBodyAsJsonArray()) {

            Gson json = new Gson();
            User user = json.fromJson(o.toString(), User.class);

            userService.save(user);

        }
    }
}
