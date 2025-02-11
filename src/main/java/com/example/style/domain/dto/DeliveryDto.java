package com.example.style.domain.dto;

import com.example.style.domain.entity.Delivery;
import lombok.Data;

@Data
public class DeliveryDto {
    private Long id;
    private String city;
    private String street;
    private String zipcode;
    private String status;

    public static DeliveryDto fromEntity(Delivery delivery) {
        DeliveryDto dto = new DeliveryDto();
        dto.setId(delivery.getId());
        dto.setCity(delivery.getAddress().getCity());
        dto.setStreet(delivery.getAddress().getStreet());
        dto.setZipcode(delivery.getAddress().getZipCode());
        dto.setStatus(delivery.getStatus().name());
        return dto;
    }
}