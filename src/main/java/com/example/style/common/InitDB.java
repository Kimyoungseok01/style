/**
 * packageName : com.example.style.common
 * fileName : InitDB
 * author : user
 * date : 2025-01-20
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2025-01-20           user             최초 생성
 */
package com.example.style.common;

import com.example.style.domain.entity.*;
import com.example.style.domain.entity.Enum.DeliveryStatus;
import com.example.style.domain.entity.Enum.OrderStatus;
import com.example.style.domain.repository.*;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class InitDB {

    private final MemberRepository memberRepository;

    private final CategoryItemRepository categoryItemRepository;

    private final CategoryRepository categoryRepository;

    private final DeliveryRepository deliveryRepository;

    private final ItemRepository itemRepository;

    private final OrderRepository orderRepository;

    private final OrderItemRepository orderItemRepository;

    private final ImageRepository imageRepository;


    @PostConstruct
    @Transactional
    @SneakyThrows
    void initDB(){
        Address address1 = new Address("Seoul", "Gangnam Street", "12345");
        Address address2 = new Address("Busan", "Haeundae Street", "67890");

        // Create Members
        Member member1 = Member.builder()
                .name("John Doe")
                .address(address1)
                .build();

        Member member2 = Member.builder()
                .name("Jane Doe")
                .address(address2)
                .build();

        memberRepository.save(member1);
        memberRepository.save(member2);

        // 1. Create Categories
        Category clothesCategory = Category.builder()
                .name("의류")
                .build();

        Category category1 = Category.builder()
                .name("아우터")
                .parent(clothesCategory)
                .build();
        Category category2 = Category.builder()
                .name("악세사리")
                .parent(clothesCategory)
                .build();
        Category category3 = Category.builder()
                .name("모자")
                .parent(clothesCategory)
                .build();

        Category shoesCategory = Category.builder()
                .name("신발")
                .build();

        Category categoryS1 = Category.builder()
                .name("운동화")
                .parent(shoesCategory)
                .build();
        Category categoryS2 = Category.builder()
                .name("구두")
                .parent(shoesCategory)
                .build();


        categoryRepository.save(clothesCategory);
        categoryRepository.save(category1);
        categoryRepository.save(category2);
        categoryRepository.save(category3);
        categoryRepository.save(shoesCategory);
        categoryRepository.save(categoryS1);
        categoryRepository.save(categoryS2);


        // Create Items
        Clothes clothes1 = new Clothes();
        clothes1.setName("Seok-Padding");
        clothes1.setPrice(200000);
        clothes1.setStockQuantity(100);
        clothes1.setManufacturerName("Seok-House");
        clothes1.setThumbnailImageUrl("https://image.msscdn.net/thumbnails/images/goods_img/20230420/3248773/3248773_16909350098593_big.jpg?w=1200");
        clothes1.setDiscountRate(BigDecimal.valueOf(0.0));
        clothes1.setItemNumber("SEOK-113");
        clothes1.setGender("MALE");
        clothes1.setShortDescription("창렬의 패딩");

        clothes1.setColor("WHITE");

        List<String> outerImages = new ArrayList<>();
        outerImages.add("https://image.msscdn.net/thumbnails/images/goods_img/20230420/3248773/3248773_16909350098593_big.jpg?w=1200");
        outerImages.add("https://image.msscdn.net/thumbnails/images/prd_img/20230420/3248773/detail_3248773_16909350140496_big.jpg?w=1200");

        List<Image> clothImageList = this.saveItemWithImages(outerImages);

        clothImageList.stream().forEach(data -> clothes1.addImage(data));

        itemRepository.save(clothes1);


        // Create Items
        Clothes clothes2 = new Clothes();
        clothes2.setName("NJ1DQ81B 여성 마티에 RDS 다운 자켓_PASTEL PINK");
        clothes2.setPrice(239000);
        clothes2.setStockQuantity(100);
        clothes2.setManufacturerName("노스페이스");
        clothes2.setThumbnailImageUrl("https://image.msscdn.net/thumbnails/images/goods_img/20240904/4401140/4401140_17254117855751_big.jpg?w=780");
        clothes2.setDiscountRate(BigDecimal.valueOf(0.3));
        clothes2.setItemNumber("NJ1DQ81B");
        clothes2.setGender("FEMALE");
        clothes2.setShortDescription("아웃도어 활동 및 일상 생활에서도 착용 가능한 여성 경량 스탠넥 다운 자켓으로, 비윤리적 동물학대 행위를 하지 않은 덕 다운을 사용하였습니다.");
        clothes2.setColor("PASTEL PINK");

        List<String> imageList2 = new ArrayList<>();
        imageList2.add("https://image.msscdn.net/thumbnails/images/goods_img/20240904/4401140/4401140_17254117855751_big.jpg?w=1200");
        imageList2.add("https://image.msscdn.net/thumbnails/images/prd_img/20240904/4401140/detail_4401140_17254117878138_big.jpg?w=1200");
        imageList2.add("https://image.msscdn.net/thumbnails/images/prd_img/20240904/4401140/detail_4401140_17254117891682_big.jpg?w=1200");
        imageList2.add("https://image.msscdn.net/thumbnails/images/prd_img/20240904/4401140/detail_4401140_17254117904138_big.jpg?w=1200");
        imageList2.add("https://image.msscdn.net/thumbnails/snap/images/2024/11/07/093dfce0946840d18772e57f05684309.jpg?w=1200");

        List<Image> clothImageList2 = this.saveItemWithImages(imageList2);
        clothImageList2.stream().forEach(data -> clothes2.addImage(data));


        // Create Items
        Hat hat1 = new Hat();
        hat1.setName("아크틱(Actic) 캡_BG");
        hat1.setPrice(39000);
        hat1.setStockQuantity(100);
        hat1.setManufacturerName("베어하우스");
        hat1.setThumbnailImageUrl("https://image.msscdn.net/thumbnails/images/goods_img/20240731/4287442/4287442_17224376195813_big.jpg?w=780");
        hat1.setDiscountRate(BigDecimal.valueOf(0.1));
        hat1.setItemNumber("B23ZUR-CA901_BG");
        hat1.setGender("MALE");
        hat1.setShortDescription("소프트한 촉감과 편안한 착용감의 아크틱 캡");
        hat1.setColor("WHITE");
        List<String> imageList3 = new ArrayList<>();
        imageList3.add("https://image.msscdn.net/thumbnails/images/goods_img/20240731/4287442/4287442_17224376195813_big.jpg?w=1200");
        imageList3.add("https://image.msscdn.net/thumbnails/images/prd_img/20240731/4287442/detail_4287442_17224376342463_big.jpg?w=1200");
        imageList3.add("https://image.msscdn.net/thumbnails/images/prd_img/20240731/4287442/detail_4287442_17224376353524_big.jpg?w=1200");
        imageList3.add("https://image.msscdn.net/thumbnails/images/prd_img/20240731/4287442/detail_4287442_17224376367016_big.jpg?w=1200");
        imageList3.add("https://image.msscdn.net/thumbnails/images/prd_img/20240731/4287442/detail_4287442_17224376384129_big.jpg?w=1200");

        List<Image> clothImageList3 = this.saveItemWithImages(imageList3);
        clothImageList3.stream().forEach(data -> hat1.addImage(data));


        // Create Items
        Hat hat2 = new Hat();
        hat2.setName("아크틱(Actic) 캡_BK");
        hat2.setPrice(39000);
        hat2.setStockQuantity(100);
        hat2.setManufacturerName("베어하우스");
        hat2.setThumbnailImageUrl("https://image.msscdn.net/thumbnails/images/goods_img/20240731/4287443/4287443_17224378517993_big.jpg?w=780");
        hat2.setDiscountRate(BigDecimal.valueOf(0.1));
        hat2.setItemNumber("B23ZUR-CA901_BK");
        hat2.setGender("MALE");
        hat2.setShortDescription("소프트한 촉감과 편안한 착용감의 아크틱 캡");
        hat2.setColor("BLACK");

        List<String> imageList4 = new ArrayList<>();
        imageList4.add("https://image.msscdn.net/thumbnails/images/goods_img/20240731/4287443/4287443_17224378517993_big.jpg?w=1200");
        imageList4.add("https://image.msscdn.net/thumbnails/images/prd_img/20240731/4287443/detail_4287443_17224378665041_big.jpg?w=1200");
        imageList4.add("https://image.msscdn.net/thumbnails/images/prd_img/20240731/4287443/detail_4287443_17224378673636_big.jpg?w=1200");
        imageList4.add("https://image.msscdn.net/thumbnails/images/prd_img/20240731/4287443/detail_4287443_17224378688850_big.jpg?w=1200");
        imageList4.add("https://image.msscdn.net/thumbnails/images/prd_img/20240731/4287443/detail_4287443_17224378702339_big.jpg?w=1200");
        List<Image> clothImageList4 = this.saveItemWithImages(imageList4);

        clothImageList4.stream().forEach(data -> hat2.addImage(data));



        // Create Items
        Shoes shoes1 = new Shoes();
        shoes1.setName("캔버스 풀문 스니커즈 (블랙)");
        shoes1.setPrice(179000);
        shoes1.setStockQuantity(100);
        shoes1.setManufacturerName("빈폴 액세서리");
        shoes1.setThumbnailImageUrl("https://image.msscdn.net/thumbnails/images/goods_img/20240109/3782267/3782267_17047637490525_big.jpg?w=780");
        shoes1.setDiscountRate(BigDecimal.valueOf(0.33));
        shoes1.setItemNumber("BE41K2M015");
        shoes1.setGender("FEMALE");
        shoes1.setShortDescription("둥근 앞코의 미니멀한 디자인의 스니커즈 입니다.");
        shoes1.setColor("BLACK");

        List<String> imageList5 = new ArrayList<>();
        imageList5.add("https://image.msscdn.net/thumbnails/images/goods_img/20240109/3782267/3782267_17047637490525_big.jpg?w=1200");
        imageList5.add("https://image.msscdn.net/thumbnails/images/prd_img/20240109/3782267/detail_3782267_17047637517349_big.jpg?w=1200");
        imageList5.add("https://image.msscdn.net/thumbnails/images/prd_img/20240109/3782267/detail_3782267_17047637528636_big.jpg?w=1200");
        imageList5.add("https://image.msscdn.net/thumbnails/images/prd_img/20240109/3782267/detail_3782267_17047637539573_big.jpg?w=1200");
        imageList5.add("https://image.msscdn.net/thumbnails/images/prd_img/20240109/3782267/detail_3782267_17047637552763_big.jpg?w=1200");

        List<Image> clothImageList5 = this.saveItemWithImages(imageList5);

        clothImageList5.stream().forEach(data -> shoes1.addImage(data));

        itemRepository.save(clothes2);
        itemRepository.save(hat1);
        itemRepository.save(hat2);
        itemRepository.save(shoes1);


        // Link Items to Categories
        CategoryItem categoryItem1 = new CategoryItem();
        categoryItem1.setCategory(category1);
        categoryItem1.setItem(clothes1);

        CategoryItem categoryItem2 = new CategoryItem();
        categoryItem2.setCategory(category1);
        categoryItem2.setItem(clothes2);

        CategoryItem categoryItem3 = new CategoryItem();
        categoryItem3.setCategory(category3);
        categoryItem3.setItem(hat1);

        CategoryItem categoryItem4 = new CategoryItem();
        categoryItem4.setCategory(category3);
        categoryItem4.setItem(hat2);

        CategoryItem categoryItem5 = new CategoryItem();
        categoryItem5.setCategory(categoryS1);
        categoryItem5.setItem(shoes1);


        categoryItemRepository.save(categoryItem1);
        categoryItemRepository.save(categoryItem2);
        categoryItemRepository.save(categoryItem3);
        categoryItemRepository.save(categoryItem4);
        categoryItemRepository.save(categoryItem5);

        // Create Delivery
        Delivery delivery = Delivery.builder()
                .address(address1)
                .status(DeliveryStatus.READY)
                .build();

        // Create Order
        OrderItem orderItem1 = OrderItem.builder()
                .item(clothes1)
                .orderPrice(clothes1.getPrice())
                .count(2)
                .build();

        OrderItem orderItem2 = OrderItem.builder()
                .item(hat1)
                .orderPrice(hat1.getPrice())
                .count(1)
                .build();


        Order order = Order.builder()
                .member(member1)
                .delivery(delivery)
                .status(OrderStatus.ORDER)
                .orderDate(LocalDateTime.now())
                .build();

        // Associate order items with the order
        order.addOrderItem(orderItem1);
        order.addOrderItem(orderItem2);

        orderRepository.save(order);
    }


    public List<Image> saveItemWithImages(List<String> imageUrls) {
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
