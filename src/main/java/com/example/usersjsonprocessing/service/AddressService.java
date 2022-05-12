package com.example.usersjsonprocessing.service;

import com.example.usersjsonprocessing.entity.Address;

import java.io.IOException;

public interface AddressService {
    Address save(Address address);
    void fillAddressObject() throws IOException, InterruptedException;
}
