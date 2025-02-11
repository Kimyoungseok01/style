/**
 * packageName : com.example.style.domain.Embedded
 * fileName : Address
 * author : user
 * date : 2025-01-23
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2025-01-23           user             최초 생성
 */
package com.example.style.domain.entity;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Address {

    private String city;
    private String street;

    private String zipCode;


    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipCode = zipcode;
    }
}
