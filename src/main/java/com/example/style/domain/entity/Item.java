package com.example.style.domain.entity;

import com.example.style.domain.dto.ItemDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "item")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
@Getter
@Setter
public abstract class Item {

    @Id @GeneratedValue
    @Column(name = "item_id")
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



    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Image> Images = new ArrayList<>();


    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL ,orphanRemoval = true)
    private List<CategoryItem> categoryItems = new ArrayList<>();

    public void addImage(Image Image) {
        Images.add(Image);
        Image.setItem(this);
    }

    public void addCategoryItem(CategoryItem categoryItem) {
        categoryItems.add(categoryItem);
        categoryItem.setItem(this);
    }
    public void decreaseStock(int quantity) {
        if (this.stockQuantity < quantity) {
            throw new IllegalStateException("Not enough stock");
        }
        this.stockQuantity -= quantity;
    }
    public void increaseStock(int quantity){
        if (this.stockQuantity > quantity) {
            throw new IllegalStateException("Not enough stock");
        }
        this.stockQuantity += quantity;
    }

    public ItemDto toListDto(){
        return ItemDto.builder()
                .id(this.id)
                .name(this.name)
                .price(this.price)
                .stockQuantity(this.stockQuantity)
                .manufacturerName(this.manufacturerName)
                .discountRate(this.discountRate)
                .thumbnailImageUrl(this.thumbnailImageUrl)
                .build();
    }

    public ItemDto toDetailDto(String parent,String child){
        return ItemDto.builder()
                .id(this.id)
                .name(this.name)
                .price(this.price)
                .stockQuantity(this.stockQuantity)
                .manufacturerName(this.manufacturerName)
                .discountRate(this.discountRate)
                .itemNumber(this.itemNumber)
                .gender(this.getGender())
                .shortDescription(this.shortDescription)
                .thumbnailImageUrl(thumbnailImageUrl)
                .imageUrls(this.Images.stream().map(item -> item.getImageUrl()).collect(Collectors.toList()))
                .parentCategoryName(parent)
                .categoryName(child)
                .build();
    }
}