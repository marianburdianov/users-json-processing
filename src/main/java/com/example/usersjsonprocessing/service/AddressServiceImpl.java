package com.example.usersjsonprocessing.service;

import com.example.usersjsonprocessing.dao.AddressDao;
import com.example.usersjsonprocessing.entity.Address;
import com.example.usersjsonprocessing.entity.User;
import com.example.usersjsonprocessing.processor.ResponseInstanceProcessor;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

@RequiredArgsConstructor
@Service
public class AddressServiceImpl implements AddressService {
    private final AddressDao addressDao;
    private final ResponseInstanceProcessor responseInstanceProcessor;

    @Override
    public Address save(Address address) {
        return addressDao.save(address);
    }

    @Override
    public void fillAddressObject() throws IOException, InterruptedException {
        Address address = new Address();
        for (Object o : responseInstanceProcessor.getJsonBodyAsJsonArray()) {

            Gson json = new Gson();
            User user = json.fromJson(o.toString(), User.class);

            address.setAddressId(user.getId());
            address.setUserId(user.getId());
            address.setStreet(user.getAddress().getStreet());
            address.setSuite(user.getAddress().getSuite());
            address.setCity(user.getAddress().getCity());
            address.setZipcode(user.getAddress().getZipcode());

            save(address);

        }
    }
}
