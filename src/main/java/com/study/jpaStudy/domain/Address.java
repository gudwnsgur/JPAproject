package com.study.jpaStudy.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

// 값 타입
@Embeddable  // 어딘가 내장될 수 있다.
@Getter
public class Address {

    private String city;
    private String street;
    private String zipcode;

    // 기본 생성자 필요
    protected Address() {}

    // 값을 변경할 수 없게 설계 되어야 한다.
    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
