/**
 * packageName : com.example.style.common.advisor
 * fileName : ApiResponse
 * author : user
 * date : 2025-01-20
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2025-01-20           user             최초 생성
 */
package com.example.style.common.advisor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T> {

    private int status;

    private String message;

    private T data;
}
