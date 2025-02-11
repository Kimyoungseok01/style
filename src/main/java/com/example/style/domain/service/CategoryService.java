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
import com.example.style.domain.entity.Category;
import com.example.style.domain.entity.Member;
import com.example.style.domain.repository.CategoryRepository;
import com.example.style.domain.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;


    public List<CategoryDto> categoryList() {
        return categoryRepository.findAll().stream()
                .map(Category::toDto) // Entity → DTO 변환
                .collect(Collectors.toList());
    }
}
