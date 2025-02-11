/**
 * packageName : com.example.style.domain.entity
 * fileName : Clothes
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
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@DiscriminatorValue("C")
@Getter
@Setter
public class Clothes extends Item{

    private String color;
}
