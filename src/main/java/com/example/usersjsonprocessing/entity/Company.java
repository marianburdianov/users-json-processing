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
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(generator = "increment")
    @Column(name = "company_id")
    private Long companyId;
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "name")
    private String name;
    @Column(name = "catch_phrase")
    private String catchPhrase;
    @Column(name = "bs")
    private String bs;

}
