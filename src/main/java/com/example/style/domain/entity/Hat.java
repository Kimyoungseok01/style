/**
 * packageName : com.example.style.domain.entity
 * fileName : Hat
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
@DiscriminatorValue("H")
@Getter
@Setter
public class Hat extends Item{

    private String logo;

    private String color;
}
