/**
 * packageName : com.example.style.common.util
 * fileName : CommonUtils
 * author : user
 * date : 2025-02-04
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2025-02-04           user             최초 생성
 */
package com.example.style.common.util;

import com.example.style.domain.entity.Image;

import java.util.List;
import java.util.stream.Collectors;

public class CommonUtils {

    public static List<Image> saveItemWithImages(List<String> imageUrls) {
        List<Image> images = imageUrls.stream().map(imageUrl -> {
            Image image = new Image();
            image.setImageUrl(imageUrl);
            image.setImageType("image/jpeg"); // 기본적으로 JPEG 지정
            //return imageRepository.save(image);  // 영속성 컨텍스트에 추가 및 저장
            return image;
        }).collect(Collectors.toList());

        return images;
    }

}
