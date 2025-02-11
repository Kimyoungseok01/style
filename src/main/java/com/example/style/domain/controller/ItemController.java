/**
 * packageName : com.example.style.domain.controller
 * fileName : MemberController
 * author : user
 * date : 2025-01-20
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2025-01-20           user             최초 생성
 */
package com.example.style.domain.controller;

import com.example.style.domain.dto.CategoryDto;
import com.example.style.domain.dto.CreateItemDto;
import com.example.style.domain.dto.ItemDto;
import com.example.style.domain.entity.Item;
import com.example.style.domain.service.CategoryService;
import com.example.style.domain.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @GetMapping("/item/list/{categoryId}")
    public List<ItemDto> itemList(@PathVariable("categoryId") Long categoryId){
        return itemService.itemList(categoryId);
    }

    @GetMapping("/item/get/{itemId}")
    public ItemDto getItem(@PathVariable("itemId") Long itemId){
        return itemService.getItem(itemId);
    }

    @PostMapping("/item/create")
    public void itemCreate(@RequestBody CreateItemDto param){
        itemService.itemCreate(param);
    }

    @DeleteMapping("/item/delete/{itemId}")
    public void deleteItem(@PathVariable("itemId") Long itemId){
        itemService.deleteItem(itemId);
    }
}
