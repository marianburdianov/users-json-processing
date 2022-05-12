package com.example.usersjsonprocessing.service;

import com.example.usersjsonprocessing.dao.GeoDao;
import com.example.usersjsonprocessing.entity.Geo;
import com.example.usersjsonprocessing.entity.User;
import com.example.usersjsonprocessing.processor.ResponseInstanceProcessor;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

@RequiredArgsConstructor
@Service
public class GeoServiceImpl implements GeoService {
    private final GeoDao geoDao;
    private final ResponseInstanceProcessor responseInstanceProcessor;

    @Override
    public Geo save(Geo geo) {
        return geoDao.save(geo);
    }

    @Override
    public void fillGeoObject() throws IOException, InterruptedException {
        Geo geo = new Geo();
        for (Object o : responseInstanceProcessor.getJsonBodyAsJsonArray()) {

            Gson json = new Gson();
            User user = json.fromJson(o.toString(), User.class);

            geo.setGeoId(user.getId());
            geo.setAddressId(user.getId());
            geo.setLat(user.getAddress().getGeo().getLat());
            geo.setLng(user.getAddress().getGeo().getLng());

            save(geo);

        }
    }
}
