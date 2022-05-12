package com.example.usersjsonprocessing.controller;

import com.example.usersjsonprocessing.http.*;
import com.example.usersjsonprocessing.processor.ResponseInstanceProcessor;
import com.example.usersjsonprocessing.service.AddressService;
import com.example.usersjsonprocessing.service.CompanyService;
import com.example.usersjsonprocessing.service.GeoService;
import com.example.usersjsonprocessing.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final ResponseInstanceProcessor responseInstanceProcessor;
    private final UserService userService;
    private final CompanyService companyService;
    private final AddressService addressService;
    private final GeoService geoService;

    @GetMapping("/users")
    void processUsers() throws IOException, InterruptedException {
        HttpClientInstance httpClientInstance = new HttpClientInstanceImpl();
        HttpRequestInstance httpRequestInstance = new HttpRequestInstanceImpl();
        HttpResponseInstance httpResponseInstance = new HttpResponseInstanceImpl(httpClientInstance, httpRequestInstance);
        httpResponseInstance.getHttpResponseInstance();
        System.out.println(httpResponseInstance.getHttpResponseInstance().body());
        System.out.println(httpResponseInstance.getHttpResponseInstance().statusCode());
        userService.fillUserObject();
        companyService.fillCompanyObject();
        addressService.fillAddressObject();
        geoService.fillGeoObject();
    }
}
