package com.example.usersjsonprocessing.dao;

import com.example.usersjsonprocessing.entity.Geo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeoDao extends JpaRepository<Geo, Long> {
}
