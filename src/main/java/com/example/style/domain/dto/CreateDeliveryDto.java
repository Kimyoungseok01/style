package com.example.style.domain.dto;

import com.example.style.domain.entity.Address;
import com.example.style.domain.entity.Delivery;
import com.example.style.domain.entity.Enum.DeliveryStatus;
import lombok.Data;

@Data
public class CreateDeliveryDto {
    private String city;
    private String street;
    private String zipcode;

    public Delivery toEntity() {
        Address address = new Address(city, street, zipcode);
        return Delivery.builder()
                .address(address)
                .status(DeliveryStatus.READY)
                .build();
    }
}