package com.example.style.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "image")
@Getter
@Setter
public class Image {

    @Id
    @GeneratedValue
    @Column(name = "image_id")
    private Long id;

    @Column(length = 1000)
    private String imageUrl;

    private String imageType;  // 이미지의 타입 (예: JPEG, PNG 등)

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;  // 해당 이미지를 소유한 아이템과 연결

}
