/**
 * packageName : com.example.style.domain.entity
 * fileName : Member
 * author : user
 * date : 2025-01-20
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2025-01-20           user             최초 생성
 */
package com.example.style.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "member")
    @JsonIgnore
    private List<Order> orders = new ArrayList<>();

    // 불변 리스트를 반환하는 Getter
    public List<Order> getOrders() {
        return Collections.unmodifiableList(orders);
    }

    // 연관관계 편의 메서드
    public void addOrder(Order order) {
        this.orders.add(order);
        order.setMember(this);
    }
}
