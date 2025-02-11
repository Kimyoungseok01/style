/**
 * packageName : com.example.style.domain.dto
 * fileName : ItemDto
 * author : user
 * date : 2025-02-03
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2025-02-03           user             최초 생성
 */
package com.example.style.domain.dto;

import com.example.style.domain.entity.Category;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ItemDto {

    private Long id;
    private String name;
    private int price;
    private int stockQuantity;

    private String manufacturerName;  // 제조사명

    private BigDecimal discountRate;  // 할인률

    private String itemNumber;        // 품번

    private String gender;            // 성별

    private String shortDescription;  // 간단 상품 소개 (텍스트)

    private String thumbnailImageUrl;

    private List<String> imageUrls;

    private String parentCategoryName;

    private String categoryName;
}
