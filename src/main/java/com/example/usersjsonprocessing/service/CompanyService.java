package com.example.usersjsonprocessing.service;

import com.example.usersjsonprocessing.entity.Company;

import java.io.IOException;

public interface CompanyService {
    Company save(Company company);
    void fillCompanyObject() throws IOException, InterruptedException;
}
