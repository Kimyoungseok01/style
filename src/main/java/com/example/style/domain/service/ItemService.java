/**
 * packageName : com.example.style.domain.service
 * fileName : MemberService
 * author : user
 * date : 2025-01-20
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2025-01-20           user             최초 생성
 */
package com.example.style.domain.service;

import com.example.style.domain.dto.CategoryDto;
import com.example.style.domain.dto.CreateItemDto;
import com.example.style.domain.dto.ItemDto;
import com.example.style.domain.entity.Category;
import com.example.style.domain.entity.CategoryItem;
import com.example.style.domain.entity.Clothes;
import com.example.style.domain.entity.Item;
import com.example.style.domain.repository.CategoryItemRepository;
import com.example.style.domain.repository.CategoryRepository;
import com.example.style.domain.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    private final CategoryItemRepository categoryItemRepository;

    private final CategoryRepository categoryRepository;

    public List<ItemDto> itemList(Long categoryId) {
        List<CategoryItem> categoryItem = categoryItemRepository.findByCategory_Id(categoryId);

        if(!categoryItem.isEmpty()){
            List<Item> itemList = itemRepository.findByCategoryItemsIn(categoryItem);
            return itemList.stream().map(Item::toListDto)
                    .collect(Collectors.toList());
        }else {
            throw new IllegalArgumentException("Category not found with id: " + categoryId);
        }
    }

    public ItemDto getItem(Long itemId) {
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new IllegalArgumentException("Item not found with id: " + itemId));

        List<CategoryItem> categoryItems = categoryItemRepository.findByItem(item);

        Category childCategory = categoryItems.stream()
                .map(CategoryItem::getCategory)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Category not found for item id: " + itemId));

        Category parentCategory = categoryRepository.findById(childCategory.getParent().getId())
                .orElseThrow(() -> new IllegalArgumentException("Category not found for item id: " + childCategory.getId()));;


        return item.toDetailDto(parentCategory.getName(), childCategory.getName());
    }

    @Transactional
    public void itemCreate(CreateItemDto param) {

        Optional<Category> category = categoryRepository.findById(param.getCategoryId());

        if(category.isPresent()){
            Clothes clothes = param.toItem();
            itemRepository.save(clothes);
            categoryItemRepository.save(param.toCategoryItem(category.get(),clothes));
        }else {
            throw new IllegalArgumentException("Category not found with id: " + param.getCategoryId());
        }


    }

    public void deleteItem(Long itemId) {
        Item item = itemRepository.findById(itemId).orElseThrow(() -> new IllegalArgumentException("Not Found itemId"));
        itemRepository.delete(item);
    }
}
