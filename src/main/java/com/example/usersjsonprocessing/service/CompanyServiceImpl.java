package com.example.usersjsonprocessing.service;

import com.example.usersjsonprocessing.dao.CompanyDao;
import com.example.usersjsonprocessing.entity.Company;
import com.example.usersjsonprocessing.entity.User;
import com.example.usersjsonprocessing.processor.ResponseInstanceProcessor;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

@RequiredArgsConstructor
@Service
public class CompanyServiceImpl implements CompanyService {
    private final CompanyDao companyDao;
    private final ResponseInstanceProcessor responseInstanceProcessor;

    @Override
    public Company save(Company company) {
        return companyDao.save(company);
    }

    @Override
    public void fillCompanyObject() throws IOException, InterruptedException {
        Company company = new Company();
        for (Object o : responseInstanceProcessor.getJsonBodyAsJsonArray()) {

            Gson json = new Gson();
            User user = json.fromJson(o.toString(), User.class);

            company.setCompanyId(user.getId());
            company.setUserId(user.getId());
            company.setName(user.getCompany().getName());
            company.setCatchPhrase(user.getCompany().getCatchPhrase());
            company.setBs(user.getCompany().getBs());

            save(company);

        }
    }
}
