/**
 * packageName : com.example.style.domain.dto
 * fileName : CategoryDto
 * author : user
 * date : 2025-01-24
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2025-01-24           user             최초 생성
 */
package com.example.style.domain.dto;

import com.example.style.domain.entity.Category;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {

    private Long id;
    private String name;
    private Long parentId;
    private List<CategoryDto> children; // 계층 구조 표현


}
