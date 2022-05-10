package com.example.usersjsonprocessing;

import com.example.usersjsonprocessing.http.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class UsersJsonProcessingApplication {

    public static void main(String[] args) throws IOException, InterruptedException {
        SpringApplication.run(UsersJsonProcessingApplication.class, args);

        HttpClientInstance httpClientInstance = new HttpClientInstanceImpl();
        HttpRequestInstance httpRequestInstance = new HttpRequestInstanceImpl();
        HttpResponseInstance httpResponseInstance = new HttpResponseInstanceImpl(httpClientInstance, httpRequestInstance);
        httpResponseInstance.getHttpResponseInstance();
        System.out.println(httpResponseInstance.getHttpResponseInstance().body());
        System.out.println(httpResponseInstance.getHttpResponseInstance().statusCode());


    }

}
