package com.mall.shopping.biz.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String userId;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String password;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = false, length = 15)
    private String phoneNumber;

    @Column(nullable = false, length = 500)
    private String address;

    @Column(length = 500)
    private String addressDetails;

    @Column(nullable = false, length = 10)
    private String zipcode;

    @Column(nullable = false, length = 100)
    private String email;


}
