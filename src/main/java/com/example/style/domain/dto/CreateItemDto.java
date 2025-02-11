/**
 * packageName : com.example.style.domain.dto
 * fileName : CreateItemDto
 * author : user
 * date : 2025-02-04
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2025-02-04           user             최초 생성
 */
package com.example.style.domain.dto;

import com.example.style.common.util.CommonUtils;
import com.example.style.domain.entity.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateItemDto {

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

    private String color;

    private List<String> imageUrls;

    private Long categoryId;

    public CategoryItem toCategoryItem(Category category, Item item) {
        CategoryItem categoryItem = new CategoryItem();
        categoryItem.setCategory(category);
        categoryItem.setItem(item);
        return categoryItem;
    }

    public Clothes toItem() {
        Clothes clothes1 = new Clothes();
        clothes1.setName(this.name);
        clothes1.setPrice(this.price);
        clothes1.setStockQuantity(this.stockQuantity);
        clothes1.setManufacturerName(this.manufacturerName);
        clothes1.setThumbnailImageUrl(this.thumbnailImageUrl);
        clothes1.setDiscountRate(this.discountRate);
        clothes1.setItemNumber(this.itemNumber);
        clothes1.setGender(this.gender);
        clothes1.setShortDescription(this.shortDescription);
        clothes1.setColor(this.color);
        List<Image> images = CommonUtils.saveItemWithImages(imageUrls);
        images.stream().forEach(item -> clothes1.addImage(item));
        return clothes1;
    }
}
