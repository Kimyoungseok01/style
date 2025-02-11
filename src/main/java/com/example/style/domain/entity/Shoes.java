/**
 * packageName : com.example.style.domain.entity
 * fileName : Shoes
 * author : user
 * date : 2025-01-23
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2025-01-23           user             최초 생성
 */
package com.example.style.domain.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("S")
@Getter
@Setter
public class Shoes extends Item {
    private String makers;

    private String color;
}
