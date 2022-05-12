package com.example.usersjsonprocessing.service;

import com.example.usersjsonprocessing.entity.Geo;

import java.io.IOException;

public interface GeoService {
    Geo save(Geo geo);
    void fillGeoObject() throws IOException, InterruptedException;
}
