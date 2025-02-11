package com.example.style.domain.repository;

import com.example.style.domain.entity.CategoryItem;
import com.example.style.domain.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface CategoryItemRepository extends JpaRepository<CategoryItem, Long> {

    List<CategoryItem> findByCategory_Id(@NonNull Long id);


    List<CategoryItem> findByItem(@NonNull Item item);

}