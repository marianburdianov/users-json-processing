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
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(generator = "increment")
    @Column(name = "address_id")
    private Long addressId;
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "street")
    private String street;
    @Column(name = "suite")
    private String suite;
    @Column(name = "city")
    private String city;
    @Column(name = "zipcode")
    private String zipcode;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Geo geo;

}
