package com.example.style.domain.controller;

import com.example.style.domain.dto.CreateDeliveryDto;
import com.example.style.domain.dto.DeliveryDto;
import com.example.style.domain.entity.Delivery;
import com.example.style.domain.entity.Enum.DeliveryStatus;
import com.example.style.domain.service.DeliveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/delivery")
public class DeliveryController {

    private final DeliveryService deliveryService;

    @GetMapping
    public ResponseEntity<List<DeliveryDto>> getAllDeliveries() {
        return ResponseEntity.ok(deliveryService.getAllDeliveries());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeliveryDto> getDelivery(@PathVariable Long id) {
        return ResponseEntity.ok(deliveryService.getDelivery(id));
    }

    @PostMapping
    public ResponseEntity<Void> createDelivery(@RequestBody CreateDeliveryDto dto) {
        deliveryService.createDelivery(dto);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Void> updateDeliveryStatus(@PathVariable Long id, 
                                                     @RequestParam DeliveryStatus status) {
        deliveryService.updateDeliveryStatus(id, status);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDelivery(@PathVariable Long id) {
        deliveryService.deleteDelivery(id);
        return ResponseEntity.noContent().build();
    }
}