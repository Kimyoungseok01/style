package com.example.style.domain.service;

import com.example.style.domain.dto.CreateDeliveryDto;
import com.example.style.domain.dto.DeliveryDto;
import com.example.style.domain.entity.Delivery;
import com.example.style.domain.entity.Enum.DeliveryStatus;
import com.example.style.domain.repository.DeliveryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DeliveryService {

    private final DeliveryRepository deliveryRepository;

    public List<DeliveryDto> getAllDeliveries() {
        return deliveryRepository.findAll().stream()
                .map(DeliveryDto::fromEntity)
                .collect(Collectors.toList());
    }

    public DeliveryDto getDelivery(Long deliveryId) {
        Delivery delivery = deliveryRepository.findById(deliveryId)
                .orElseThrow(() -> new IllegalArgumentException("Delivery not found with id: " + deliveryId));
        return DeliveryDto.fromEntity(delivery);
    }

    public void createDelivery(CreateDeliveryDto createDeliveryDto) {
        Delivery delivery = createDeliveryDto.toEntity();
        deliveryRepository.save(delivery);
    }

    public void updateDeliveryStatus(Long deliveryId, DeliveryStatus status) {
        Delivery delivery = deliveryRepository.findById(deliveryId)
                .orElseThrow(() -> new IllegalArgumentException("Delivery not found with id: " + deliveryId));
        delivery.setStatus(status);
        deliveryRepository.save(delivery);
    }

    public void deleteDelivery(Long deliveryId) {
        Delivery delivery = deliveryRepository.findById(deliveryId)
                .orElseThrow(() -> new IllegalArgumentException("Delivery not found with id: " + deliveryId));
        deliveryRepository.delete(delivery);
    }
}