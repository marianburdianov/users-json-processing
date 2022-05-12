package com.example.usersjsonprocessing.entity;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Data
@Setter
@Getter
@RequiredArgsConstructor
@Component
@Table(name = "geo")
public class Geo {

    @Id
    @GeneratedValue(generator = "increment")
    @Column(name = "geo_id")
    private Long geoId;
    @Column(name = "address_id")
    private Long addressId;
    @Column(name = "lat")
    private Double lat;
    @Column(name = "lng")
    private Double lng;
}
