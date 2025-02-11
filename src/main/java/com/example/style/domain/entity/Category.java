package com.example.style.domain.entity;

import com.example.style.domain.dto.CategoryDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue
    @Column(name = "category_id")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CategoryItem> categoryItems = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    @JsonIgnore // 순환 참조 방지
    private Category parent;

    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY)
    private List<Category> child = new ArrayList<>();

    // 자식 카테고리 추가
    public void addChildCategory(Category child) {
        this.child.add(child);
        child.setParent(this);
    }

    // 카테고리 아이템 추가
    public void addCategoryItem(CategoryItem categoryItem) {
        this.categoryItems.add(categoryItem);
        categoryItem.setCategory(this);
    }

    // 불변 리스트 제공
    public List<Category> getChild() {
        return Collections.unmodifiableList(child);
    }

    public List<CategoryItem> getCategoryItems() {
        return Collections.unmodifiableList(categoryItems);
    }

    public CategoryDto toDto() {
        return CategoryDto.builder()
                .id(this.id)
                .name(this.name)
                .parentId(this.parent != null ? this.parent.getId() : null)
                .build();
    }

    // DTO → Entity 변환 메서드
    public static Category fromDto(CategoryDto dto, Category parent) {
        Category category = Category.builder()
                .id(dto.getId())
                .name(dto.getName())
                .parent(parent)
                .build();

        // 자식 Category 설정
        if (dto.getChildren() != null) {
            category.setChild(dto.getChildren().stream()
                    .map(childDto -> fromDto(childDto, category))
                    .collect(Collectors.toList()));
        }

        return category;
    }
}