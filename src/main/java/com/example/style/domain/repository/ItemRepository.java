package com.example.style.domain.repository;

import com.example.style.domain.entity.CategoryItem;
import com.example.style.domain.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.NonNull;

import java.util.Collection;
import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findByCategoryItemsIn(@NonNull Collection<CategoryItem> categoryItems);
    @Query("SELECT i FROM Item i JOIN i.categoryItems ci WHERE ci.category.id = :categoryId")
    List<Item> findItemsByCategoryId(@Param("categoryId") Long categoryId);
}